package com.epam.controller;

import com.epam.dao.ProductRepository;
import com.epam.dao.UserRepository;
import com.epam.model.Product;
import com.epam.model.User;
import com.epam.uitl.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/addProduct")
    public String addProduct() {

        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            productList.add(new Product(" code", "name", "photo", 200.00));
        }

        productRepository.save(productList);
        userRepository.save(new User("12345","12345"));
        return "";
    }


    @GetMapping(value = "/getIds")
    public void delete() {
        int total = jdbcTemplate.queryForList("SELECT * FROM PRODUCT").size();
        System.out.println("" + total);
        List<Integer> ids = productRepository.getAllProductIds();
        System.out.println(ids);
    }


    @GetMapping(value = "products")
    public List<Product> getProducts() {
        return jdbcTemplate.query("SELECT * FROM PRODUCT", new ProductRowMapper());
    }

}
