package com.epam.dao;

import com.epam.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "FROM Cart cart WHERE cart.product.id=:productId")
    public Optional<Cart> findByProduct(@Param("productId") Integer productId);
}
