package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    
}
