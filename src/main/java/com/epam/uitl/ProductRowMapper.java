package com.epam.uitl;

import com.epam.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("product_id"));
        product.setCode(rs.getString("code"));
        product.setName(rs.getString("name"));
        product.setPhoto(rs.getString("photo"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }
}
