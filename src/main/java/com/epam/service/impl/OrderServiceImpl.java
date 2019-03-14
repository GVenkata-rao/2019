package com.epam.service.impl;

import com.epam.dao.OrderRepository;
import com.epam.model.Orders;
import com.epam.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepo;

    @Override
    @Transactional
    public Orders saveOrder(Orders order) {
        return orderRepo.save(order);
    }

}
