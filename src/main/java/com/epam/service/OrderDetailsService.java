package com.epam.service;

import com.epam.model.OrderDetails;

import java.util.List;

public interface OrderDetailsService {

    OrderDetails saveOrderDetails(OrderDetails orderDetails);

    List<OrderDetails> getOrderDetails();
}
