package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pedido;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.service.PedidoService;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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

    /*@GetMapping("/search")
    public List<Pedido> searchPedidos(@RequestParam(required = false) Double valorMinimo) {
        if (valorMinimo != null) {
            return pedidoRepository.findByValorTotalGreaterThan(valorMinimo);
        }
        return pedidoRepository.findAll();
    }*/
    /*@Autowired
    private PedidoService pedidoService;
    @PostMapping("/search")
    public List<Pedido> searchPedidos(@RequestBody Map<String, Object> query) {
        return pedidoService.searchPedidos(query);
    }*/
    private static final Logger logger = Logger.getLogger(PedidoController.class.getName());

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/search")
    public List<Pedido> searchPedidos(@RequestBody Map<String, Object> query) {
        List<Pedido> result = pedidoService.searchPedidos(query);
        logger.info("Query: " + query);
        logger.info("Result: " + result);
        return result;
    }
}
