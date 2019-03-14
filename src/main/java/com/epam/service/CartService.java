package com.epam.service;

import com.epam.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {

    public Cart saveCart(Cart cart);
    public Optional<Cart> findByProduct(Integer productId);
    List<Cart> findAll();
    public void deleteCartItem(Integer id);
}
