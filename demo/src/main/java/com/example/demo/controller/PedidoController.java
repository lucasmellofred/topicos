package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Pedido;
import com.example.demo.repository.PedidoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable String id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable String id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable String id) {
        pedidoRepository.deleteById(id);
    }
}
