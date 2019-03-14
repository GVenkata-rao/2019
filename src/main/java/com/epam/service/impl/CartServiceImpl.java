package com.epam.service.impl;

import com.epam.dao.CartRepository;
import com.epam.model.Cart;
import com.epam.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Optional<Cart> findByProduct(Integer productId) {
        return cartRepository.findByProduct(productId);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteCartItem(Integer id) {
        cartRepository.delete(id);
    }


}
