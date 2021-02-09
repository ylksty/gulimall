package com.ylkget.gmall.search.controller;

import com.ylkget.gmall.search.service.MallSearchService;
import com.ylkget.gmall.search.vo.SearchParam;
import com.ylkget.gmall.search.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 搜索列表
 * </p>
 *
 * @author joe 2021-02-08 18:44
 */
@Controller
public class SearchController {
    @Autowired
    MallSearchService mallSearchService;

    /**
     * 自动将页面提交过来的所有请求查询参数封装成指定的对象
     * @param param
     * @return
     */
    @GetMapping("/list.html")
    public String listPage(SearchParam param, Model model, HttpServletRequest request){
        System.out.println("aaa");

        param.set_queryString(request.getQueryString());
        //1、根据传递来的页面的查询参数，去es中检索商品
        SearchResult result = mallSearchService.search(param);

        model.addAttribute("result",result);

        return "list";
    }
}
