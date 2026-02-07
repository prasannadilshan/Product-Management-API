package com.example.ProductManagement.service.impl;

import com.example.ProductManagement.dto.ProductDTO;
import com.example.ProductManagement.model.Product;
import com.example.ProductManagement.repository.ProductRepository;
import com.example.ProductManagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .category(productDTO.getCategory())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .build();
        Product savedProduct = productRepository.save(product);
        productDTO.setId(savedProduct.getId());
        return productDTO;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> searchProducts(String category) {
        return productRepository.findByCategoryIgnoreCase(category).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteProductByName(String name) {
        return productRepository.findByProductNameIgnoreCase(name)
                .map(p -> {
                    productRepository.delete(p);
                    return "Product '" + name + "' deleted successfully.";
                })
                .orElse("Product '" + name + "' not found.");
    }

    private ProductDTO mapToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .category(product.getCategory())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}
