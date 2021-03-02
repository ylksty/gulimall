package com.ylkget.common.exception;

/**
 * <p>
 * NoStockException
 * </p>
 *
 * @author joe 2021/3/2 11:48
 */
public class NoStockException extends RuntimeException {
    public NoStockException(Long skuId){
        super("商品id:"+skuId+"；没有足够的库存了");
    }

    public NoStockException(String message){
        super(message);
    }
}
