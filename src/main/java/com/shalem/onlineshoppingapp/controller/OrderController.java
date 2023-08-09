package com.shalem.onlineshoppingapp.controller;

import com.shalem.onlineshoppingapp.dto.OrderDto;
import com.shalem.onlineshoppingapp.entity.Order;
import com.shalem.onlineshoppingapp.service.OrderService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/{id}/place")
    public ResponseEntity<Order> placeOrder(@PathVariable("id")ObjectId id, @RequestBody OrderDto orderDto){
        return new ResponseEntity<>(orderService.placeOrder(id,orderDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id")ObjectId id){
        return new ResponseEntity<>(orderService.getOrderById(id),HttpStatus.OK);
    }

}
