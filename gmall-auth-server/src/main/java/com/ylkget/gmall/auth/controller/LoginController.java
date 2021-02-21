package com.ylkget.gmall.auth.controller;

import com.alibaba.fastjson.TypeReference;
import com.ylkget.common.constant.AuthServerConstant;
import com.ylkget.common.utils.R;
import com.ylkget.gmall.auth.feign.MemberFeignService;
import com.ylkget.gmall.auth.vo.UserRegistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
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
    StringRedisTemplate redisTemplate;

    @Autowired
    MemberFeignService memberFeignService;

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

                    return "redirect:http://auth.gulimall.com/login.html";
                }else{
                    Map<String, String> errors = new HashMap<>();
                    errors.put("msg",r.getData("msg",new TypeReference<String>(){}));
                    redirectAttributes.addFlashAttribute("errors",errors);
                    return "redirect:http://auth.gulimall.com/reg.html";
                }

            }else{
                Map<String, String> errors =  new HashMap<>();
                errors.put("code","验证码错误");
                redirectAttributes.addFlashAttribute("errors",errors);
                return "redirect:http://auth.gulimall.com/reg.html";
            }
        }else {
            Map<String, String> errors =  new HashMap<>();
            errors.put("code","验证码错误");
            redirectAttributes.addFlashAttribute("errors",errors);
            //校验出错，转发到注册页
            return "redirect:http://auth.gulimall.com/reg.html";
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
}
