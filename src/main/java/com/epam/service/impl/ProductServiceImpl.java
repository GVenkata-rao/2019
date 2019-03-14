package com.epam.service.impl;

import com.epam.dao.ProductRepository;
import com.epam.model.Product;
import com.epam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepo;

    public List<Product> findAll(){
        return productRepo.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepo.findOne(id);
    }
}
