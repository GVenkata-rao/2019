package com.epam.service.impl;

import com.epam.dao.OrderDetailsRepository;
import com.epam.model.OrderDetails;
import com.epam.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Override
    public OrderDetails saveOrderDetails(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public List<OrderDetails> getOrderDetails() {
        return orderDetailsRepository.findAll();
    }
}
