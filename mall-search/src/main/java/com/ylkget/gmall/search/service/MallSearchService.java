package com.ylkget.gmall.search.service;

import com.ylkget.gmall.search.vo.SearchParam;
import com.ylkget.gmall.search.vo.SearchResult;

/**
 * <p>
 * $
 * </p>
 *
 * @author joe 2021-02-08 18:48
 */
public interface MallSearchService {
    /**
     *
     * @param param  检索的所有参数
     * @return 返回检索的结果,里面包含页面需要的所有信息
     */
    SearchResult search(SearchParam param);
}
