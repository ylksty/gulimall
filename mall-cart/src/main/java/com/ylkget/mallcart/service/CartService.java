package com.ylkget.mallcart.service;

import com.ylkget.mallcart.vo.Cart;
import com.ylkget.mallcart.vo.CartItem;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 * CartService
 * </p>
 *
 * @author joe 2021/2/25 16:58
 */
public interface CartService {
    /**
     * 将商品添加到购物车
     * @param skuId
     * @param num
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    CartItem addToCart(Long skuId, Integer num) throws ExecutionException, InterruptedException;


    /**
     * 获取购物车中某个购物项
     * @param skuId
     * @return
     */
    CartItem getCartItem(Long skuId);


    /**
     * 获取整个购物车
     * @return
     */
    Cart getCart() throws ExecutionException, InterruptedException;

    /**
     * 清空购物车数据
     * @param cartkey
     */
    void clearCart(String cartkey);

    /**
     * 勾选购物项
     * @param skuId
     * @param check
     */
    void checkItem(Long skuId, Integer check);


    /**
     * 修改购物项数量
     * @param skuId
     * @param num
     */
    void changeItemCount(Long skuId, Integer num);

    /**
     * 删除购物项
     * @param skuId
     */
    void deleteItem(Long skuId);


    List<CartItem> getUserCartItems();
}
