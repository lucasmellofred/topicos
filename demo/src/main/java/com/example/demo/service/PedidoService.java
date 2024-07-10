package com.example.demo.service;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pedido;
import com.example.demo.repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(String id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido updatePedido(String id, Pedido pedido) {
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }

    public void deletePedido(String id) {
        pedidoRepository.deleteById(id);
    }
}*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pedido;

import java.util.List;
import java.util.Map;

@Service
public class PedidoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /*public List<Pedido> searchPedidos(Map<String, Object> query) {
        Query mongoQuery = new Query();
        if (query.containsKey("rules")) {
            List<Map<String, Object>> rules = (List<Map<String, Object>>) query.get("rules");
            for (Map<String, Object> rule : rules) {
                String field = (String) rule.get("id");
                String operator = (String) rule.get("operator");
                Object value = rule.get("value");
                Criteria criteria = Criteria.where(field);

                switch (operator) {
                    case "equal":
                        criteria.is(value);
                        break;
                    case "not_equal":
                        criteria.ne(value);
                        break;
                    case "less":
                        criteria.lt(value);
                        break;
                    case "less_or_equal":
                        criteria.lte(value);
                        break;
                    case "greater":
                        criteria.gt(value);
                        break;
                    case "greater_or_equal":
                        criteria.gte(value);
                        break;
                    case "begins_with":
                        criteria.regex("^" + value);
                        break;
                    case "contains":
                        criteria.regex(value.toString());
                        break;
                    case "ends_with":
                        criteria.regex(value + "$");
                        break;
                    // Adicione outros operadores conforme necessário
                }
                mongoQuery.addCriteria(criteria);
            }
        }
        return mongoTemplate.find(mongoQuery, Pedido.class);
    }*/

    public List<Pedido> searchPedidos(Map<String, Object> query) {
        Query mongoQuery = new Query();
        if (query.containsKey("rules")) {
            List<Map<String, Object>> rules = (List<Map<String, Object>>) query.get("rules");
            for (Map<String, Object> rule : rules) {
                String field = (String) rule.get("id");
                String operator = (String) rule.get("operator");
                Object value = rule.get("value");

                // Ajustar a lógica para arrays aninhados
                if (field.equals("items.productName")) {
                    field = "itens.product.productName";  // Corrigir o campo
                }

                Criteria criteria = Criteria.where(field);

                switch (operator) {
                    case "equal":
                        criteria.is(value);
                        break;
                    case "not_equal":
                        criteria.ne(value);
                        break;
                    case "less":
                        criteria.lt(value);
                        break;
                    case "less_or_equal":
                        criteria.lte(value);
                        break;
                    case "greater":
                        criteria.gt(value);
                        break;
                    case "greater_or_equal":
                        criteria.gte(value);
                        break;
                    case "begins_with":
                        criteria.regex("^" + value);
                        break;
                    case "contains":
                        criteria.regex(".*" + value + ".*", "i"); // Case-insensitive
                        break;
                    case "not_contains":
                        criteria.not().regex(".*" + value + ".*", "i"); // Case-insensitive
                        break;
                    case "ends_with":
                        criteria.regex(value + "$");
                        break;
                    // Adicione outros operadores conforme necessário
                }
                mongoQuery.addCriteria(criteria);
            }
        }
        return mongoTemplate.find(mongoQuery, Pedido.class);
    }
}