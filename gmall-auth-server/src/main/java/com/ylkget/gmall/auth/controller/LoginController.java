package com.ylkget.gmall.auth.controller;

import com.alibaba.fastjson.TypeReference;
import com.ylkget.common.constant.AuthServerConstant;
import com.ylkget.common.exception.BizCodeEnume;
import com.ylkget.common.utils.R;
import com.ylkget.common.vo.MemberRespVo;
import com.ylkget.gmall.auth.feign.MemberFeignService;
import com.ylkget.gmall.auth.feign.ThirdPartFeignService;
import com.ylkget.gmall.auth.vo.UserLoginVo;
import com.ylkget.gmall.auth.vo.UserRegistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>
 * LoginController
 * </p>
 *
 * @author joe 2021/2/21 20:38
 */
@Controller
public class LoginController {
    @Autowired
    ThirdPartFeignService thirdPartFeignService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    MemberFeignService memberFeignService;


    /**
     * 获取短信验证码
     * @param phone
     * @return
     */
    @ResponseBody
    @GetMapping("/sms/sendcode")
    public R sendCode(@RequestParam("phone") String phone){

        //TODO 1、接口防刷。
        String redisCode = redisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone);
        if(!StringUtils.isEmpty(redisCode)){
            long l = Long.parseLong(redisCode.split("_")[1]);
            if(System.currentTimeMillis() - l < 60000){
                //60秒内不能再发
                return R.error(BizCodeEnume.SMS_CODE_EXCEPTION.getCode(),BizCodeEnume.SMS_CODE_EXCEPTION.getMsg());
            }
        }


        //2、验证码的再次校验。redis。存key-phone，value-code   sms:code:17512080612 -> 45678
        String code = UUID.randomUUID().toString().substring(0, 5);
        String substring = code+"_"+System.currentTimeMillis();
        //redis缓存验证码，防止同一个phone在60秒内再次发送验证码

        redisTemplate.opsForValue().set(AuthServerConstant.SMS_CODE_CACHE_PREFIX+phone,substring,10, TimeUnit.MINUTES);
        System.out.println(phone + ":" + code);
        thirdPartFeignService.sendCode(phone,code);
        return R.ok();
    }

    /**
     *
     *   //TODO 重定向携带数据，利用session原理。将数据放在session中。
     *     只要跳到下一个页面取出这个数据以后，session里面的数据就会删掉
     *
     *  //TODO 1、分布式下的session问题。
     * RedirectAttributes redirectAttributes：模拟重定向携带数据
     * @param vo
     * @param result
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/regist")
    public String regist(@Valid UserRegistVo vo, BindingResult result,
                         RedirectAttributes redirectAttributes,
                         HttpSession session){
        if(result.hasErrors()){

            /**
             * .map(fieldError -> {
             *                 String field = fieldError.getField();
             *                 String defaultMessage = fieldError.getDefaultMessage();
             *                 errors.put(field,defaultMessage);
             *                 return
             *             })
             */
            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
//            model.addAttribute("errors",errors);
            redirectAttributes.addFlashAttribute("errors",errors);
            //Request method 'POST' not supported
            //用户注册->/regist[post]----》转发/reg.html（路径映射默认都是get方式访问的。）

//            session.set
            //校验出错，转发到注册页
            return "redirect:http://auth.gmall.com/reg.html";
        }


        //1、校验验证码
        String code = vo.getCode();

        String s = redisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + vo.getPhone());
        if(!StringUtils.isEmpty(s)){
            if(code.equals(s.split("_")[0])){
                //删除验证码;令牌机制
                redisTemplate.delete(AuthServerConstant.SMS_CODE_CACHE_PREFIX + vo.getPhone());
                //验证码通过。 //真正注册。调用远程服务进行注册
                R r = memberFeignService.regist(vo);
                if(r.getCode() == 0){
                    //成功

                    return "redirect:http://auth.gmall.com/login.html";
                }else{
                    Map<String, String> errors = new HashMap<>();
                    errors.put("msg",r.getData("msg",new TypeReference<String>(){}));
                    redirectAttributes.addFlashAttribute("errors",errors);
                    return "redirect:http://auth.gmall.com/reg.html";
                }

            }else{
                Map<String, String> errors =  new HashMap<>();
                errors.put("code","验证码错误");
                redirectAttributes.addFlashAttribute("errors",errors);
                return "redirect:http://auth.gmall.com/reg.html";
            }
        }else {
            Map<String, String> errors =  new HashMap<>();
            errors.put("code","验证码错误");
            redirectAttributes.addFlashAttribute("errors",errors);
            //校验出错，转发到注册页
            return "redirect:http://auth.gmall.com/reg.html";
        }
    }

    @GetMapping("/login.html")
    public String loginPage(HttpSession session){
        System.out.println("LoginController.loginPage");
        Object attribute = session.getAttribute(AuthServerConstant.LOGIN_USER);
        if(attribute == null){
            //没登录
            return "login";
        }else {
            return "redirect:http://gmall.com";
        }

    }

    @PostMapping("/login")
    public String login(UserLoginVo vo, RedirectAttributes redirectAttributes,
                        HttpSession session){


        //远程登录
        R login = memberFeignService.login(vo);
        if(login.getCode()==0){

            MemberRespVo data = login.getData("data", new TypeReference<MemberRespVo>() {
            });
            ////成功放到session中
            session.setAttribute(AuthServerConstant.LOGIN_USER,data);
            return "redirect:http://gmall.com";
        }else {
            Map<String,String > errors = new HashMap<>();
            errors.put("msg",login.getData("msg",new TypeReference<String>(){}));
            redirectAttributes.addFlashAttribute("errors",errors);
            return "redirect:http://auth.gmall.com/login.html";
        }
    }
}
