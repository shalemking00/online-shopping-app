package com.shalem.onlineshoppingapp.service.serviceImpl;
import com.shalem.onlineshoppingapp.Exception.OrderNotFoundException;
import com.shalem.onlineshoppingapp.Exception.OutOfStockException;
import com.shalem.onlineshoppingapp.Exception.ProductNotFoundException;
import com.shalem.onlineshoppingapp.dto.OrderDto;
import com.shalem.onlineshoppingapp.entity.Order;
import com.shalem.onlineshoppingapp.entity.Product;
import com.shalem.onlineshoppingapp.repository.OrderRepository;
import com.shalem.onlineshoppingapp.repository.ProductRepository;
import com.shalem.onlineshoppingapp.service.OrderService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Order placeOrder(ObjectId id, OrderDto orderDto) {
        Product product=productRepository.findBy_id(id).orElseThrow(()->new ProductNotFoundException(String.format("%s not found",id)));
        if(orderDto.getQuantity()>product.getQuantity()){
            throw new OutOfStockException("The product is currently unavailable");
        }
        product.setQuantity(product.getQuantity()- orderDto.getQuantity());
        if(product.getQuantity()<0){
            product.setStatus("Out of Stock");
            throw new OutOfStockException("The product is currently unavailable");
        }else {
            product.setStatus("Order soon");
        }
        productRepository.save(product);
        Order newOrder=new Order();
        newOrder.setProductName(product.getProductName());
        newOrder.setFeatures(product.getFeatures());
        newOrder.setPrice(product.getPrice()* orderDto.getQuantity());
        newOrder.setProductDescription(product.getDescription());
        newOrder.setNoOfItems(orderDto.getQuantity());
        return orderRepository.save(newOrder);
    }

    @Override
    public List<Order> getAllOrders() {

        return orderRepository.findAll();


    }

    @Override
    public Order getOrderById(ObjectId id) {
        return orderRepository.findBy_id(id).orElseThrow(()->new OrderNotFoundException(String.format("Order not found with id:%s",id)));
    }
}
