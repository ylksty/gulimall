package com.ylkget.mallcart.service.impl;

import com.ylkget.mallcart.service.CartService;
import com.ylkget.mallcart.vo.Cart;
import com.ylkget.mallcart.vo.CartItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/2/25 16:59
 */
@Slf4j
@Service
public class CartServiceImpl implements CartService {
    @Override
    public CartItem addToCart(Long skuId, Integer num) throws ExecutionException, InterruptedException {
        return null;
    }

    @Override
    public CartItem getCartItem(Long skuId) {
        return null;
    }

    @Override
    public Cart getCart() throws ExecutionException, InterruptedException {
        return null;
    }

    @Override
    public void clearCart(String cartkey) {

    }

    @Override
    public void checkItem(Long skuId, Integer check) {

    }

    @Override
    public void changeItemCount(Long skuId, Integer num) {

    }

    @Override
    public void deleteItem(Long skuId) {

    }

    @Override
    public List<CartItem> getUserCartItems() {
        return null;
    }
}
