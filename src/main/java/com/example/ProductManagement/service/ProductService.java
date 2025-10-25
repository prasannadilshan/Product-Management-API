package com.example.ProductManagement.service;

import com.example.ProductManagement.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);
    String deleteProductByName(String name);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> searchProducts(String category);
}
