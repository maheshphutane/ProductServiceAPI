package com.apidemo.productservice.services;

import com.apidemo.productservice.dtos.ProductDTO;
import com.apidemo.productservice.exceptions.ProductNotFoundException;
import com.apidemo.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    @Transactional
    ResponseEntity<Product> addProduct(Product product);

    List<Product> getAllProducts();
    ResponseEntity<Product> updateProduct(ProductDTO productDTO, Long id);

    Product replaceProduct(ProductDTO productDTO, Long id);

}
