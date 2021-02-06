package com.ylkget.gmall.product.feign;

import com.ylkget.common.to.es.SkuEsModel;
import com.ylkget.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author joe 2021-02-06 11
 */
@FeignClient("server-search")
public interface SearchFeignService {
    @PostMapping("/search/save/product")
    R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);
}
