package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Loja;

public interface LojaRepository extends MongoRepository<Loja, String> {
}
