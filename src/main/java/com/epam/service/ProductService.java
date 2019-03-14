package com.epam.service;

import com.epam.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public Product findById(Integer id);

}
