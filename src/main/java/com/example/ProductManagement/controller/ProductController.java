package com.example.ProductManagement.controller;

import com.example.ProductManagement.dto.ProductDTO;
import com.example.ProductManagement.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    @PostMapping
    public ProductDTO addProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("category/{category}")
    public List<ProductDTO> getAllProductsByCategory(@PathVariable String category) {
        return productService.searchProducts(category);
    }

    @DeleteMapping("/{name}")
    public String deleteProduct(@PathVariable String name) {
        return productService.deleteProductByName(name);
    }

}
