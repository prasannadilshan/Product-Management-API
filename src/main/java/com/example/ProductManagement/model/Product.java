package com.example.ProductManagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "products") // 👈 MongoDB collection name
public class Product {

    @Id
    private String id; // 👈 ObjectId in MongoDB is stored as a String

    private String productName;
    private String category;
    private double price;
    private int quantity;
}
