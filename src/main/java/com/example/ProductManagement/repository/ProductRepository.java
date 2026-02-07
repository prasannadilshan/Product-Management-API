package com.example.ProductManagement.repository;

import com.example.ProductManagement.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByCategoryIgnoreCase(String category);

    Optional<Product> findByProductNameIgnoreCase(String productName);
}
