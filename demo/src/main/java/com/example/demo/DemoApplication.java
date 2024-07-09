package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}






/*
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.Arrays;

@SpringBootApplication
public class PedidoService {
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> pedidosCollection;

    public PedidoService(String connectionString, String dbName) {
        this.mongoClient = MongoClients.create(connectionString);
        this.database = mongoClient.getDatabase(dbName);
        this.pedidosCollection = database.getCollection("pedidos");
    }

    // Create
    public void createPedido(Document pedido) {
        pedidosCollection.insertOne(pedido);
    }

    // Read
    public Document readPedido(ObjectId id) {
        return pedidosCollection.find(new Document("_id", id)).first();
    }

    // Update
    public void updatePedido(ObjectId id, Document update) {
        pedidosCollection.updateOne(new Document("_id", id), new Document("$set", update));
    }

    // Delete
    public void deletePedido(ObjectId id) {
        pedidosCollection.deleteOne(new Document("_id", id));
    }

    // Search by example
    public FindIterable<Document> searchByExample(Document example) {
        return pedidosCollection.find(example);
    }

    public static void main(String[] args) {
        PedidoService service = new PedidoService("mongodb://localhost:27017", "vendetudo");

        // Create example
        Document pedido = new Document()
                .append("clienteId", new ObjectId())
                .append("dataPedido", new java.util.Date())
                .append("itens", Arrays.asList(
                        new Document("produtoId", new ObjectId())
                                .append("quantidade", 2)
                                .append("precoUnitario", 50.0)))
                .append("valorTotal", 100.0)
                .append("status", "Processando");
        service.createPedido(pedido);

        // Read example
        ObjectId id = pedido.getObjectId("_id");
        Document result = service.readPedido(id);
        System.out.println("Pedido encontrado: " + result.toJson());

        // Update example
        Document update = new Document("status", "Enviado");
        service.updatePedido(id, update);

        // Commenting out the delete part
        // service.deletePedido(id);

        // Search by example
        Document searchExample = new Document("status", "Processando");
        FindIterable<Document> results = service.searchByExample(searchExample);
        for (Document doc : results) {
            System.out.println("Pedido encontrado: " + doc.toJson());
        }

        // Close the client
        service.mongoClient.close();
    }
}
*/