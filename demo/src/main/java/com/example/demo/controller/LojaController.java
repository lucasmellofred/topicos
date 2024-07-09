package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Loja;
import com.example.demo.repository.LojaRepository;

@RestController
@RequestMapping("/api/lojas")
public class LojaController {
    @Autowired
    private LojaRepository lojaRepository;

    @GetMapping
    public List<Loja> getAllLojas() {
        return lojaRepository.findAll();
    }
}
