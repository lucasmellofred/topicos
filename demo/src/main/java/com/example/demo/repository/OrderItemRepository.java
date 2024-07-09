package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.OrderItem;

public interface OrderItemRepository extends MongoRepository<OrderItem, String> {
}
