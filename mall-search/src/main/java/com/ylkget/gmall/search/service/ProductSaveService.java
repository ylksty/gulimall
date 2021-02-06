package com.ylkget.gmall.search.service;

import com.ylkget.common.to.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @author joe 2021-02-06 11
 */
public interface ProductSaveService {
    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
