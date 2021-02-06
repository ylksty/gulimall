package com.ylkget.gmall.product.web;

import com.ylkget.gmall.product.entity.CategoryEntity;
import com.ylkget.gmall.product.service.CategoryService;
import com.ylkget.gmall.product.vo.Catelog2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author joe 2021-02-06 22
 */
@Controller
public class IndexController {

    @Autowired
    CategoryService categoryService;

    @GetMapping({"/","/index.html"})
    public String indexPage(Model model){

        System.out.println(""+Thread.currentThread().getId());
        //TODO 1、查出所有的1级分类
        List<CategoryEntity> categoryEntities =  categoryService.getLevel1Categorys();

        // 视图解析器进行拼串：
        // classpath:/templates/ +返回值+  .html
        model.addAttribute("categorys",categoryEntities);
        return "index";
    }

    //index/catalog.json
    @ResponseBody
    @GetMapping("/index/catalog.json")
    public Map<String, List<Catelog2Vo>> getCatalogJson(){
        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJson();
        return catalogJson;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
