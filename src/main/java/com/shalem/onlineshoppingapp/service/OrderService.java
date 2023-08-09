package com.shalem.onlineshoppingapp.service;

import com.shalem.onlineshoppingapp.dto.OrderDto;
import com.shalem.onlineshoppingapp.entity.Order;
import org.bson.types.ObjectId;

import java.util.List;

public interface OrderService {
    Order placeOrder(ObjectId id, OrderDto orderDto);

    List<Order> getAllOrders();

    Order getOrderById(ObjectId id);
}
