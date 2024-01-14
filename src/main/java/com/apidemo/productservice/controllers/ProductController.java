package com.apidemo.productservice.controllers;

import com.apidemo.productservice.dtos.FakeStoreProductDTO;
import com.apidemo.productservice.exceptions.ProductNotFoundException;
import com.apidemo.productservice.models.Product;
import com.apidemo.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }
    @PostMapping
    public ResponseEntity<FakeStoreProductDTO> addProduct(@RequestBody FakeStoreProductDTO fakeStoreProductDTO){
        return productService.addProduct(fakeStoreProductDTO);
    }
//    Not Supported by API
//    @PatchMapping("/{id}")
//    public ResponseEntity<Product> updateProductById(@PathVariable("id") Long id, @RequestBody FakeStoreProductDTO fakeStoreProductDTO){
//        return productService.updateProduct(fakeStoreProductDTO,id);
//    }
    @PutMapping("{id}")
    public Product replaceProductById(@PathVariable("id") Long id,@RequestBody FakeStoreProductDTO fakeStoreProductDTO){
        return productService.replaceProduct(fakeStoreProductDTO,id);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id){

    }
}
