package com.apidemo.productservice.services;

import com.apidemo.productservice.dtos.FakeStoreProductDTO;
import com.apidemo.productservice.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    ResponseEntity<FakeStoreProductDTO> addProduct(FakeStoreProductDTO fakeStoreProductDTO);
    List<Product> getAllProducts();
    ResponseEntity<Product> updateProduct(FakeStoreProductDTO fakeStoreProductDTO,Long id);

    Product replaceProduct(FakeStoreProductDTO fakeStoreProductDTO, Long id);
}
