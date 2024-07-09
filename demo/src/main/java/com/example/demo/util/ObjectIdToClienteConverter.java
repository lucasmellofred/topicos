/*package com.example.demo.util;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Cliente;

@Component
public class ObjectIdToClienteConverter implements Converter<ObjectId, Cliente> {
    @Override
    public Cliente convert(ObjectId source) {
        Cliente cliente = new Cliente();
        cliente.setId(source);
        return cliente;
    }
}

*/