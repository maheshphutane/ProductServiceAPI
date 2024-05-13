package com.apidemo.productservice.controllers;

import com.apidemo.productservice.dtos.ProductDTO;
import com.apidemo.productservice.exceptions.ProductNotFoundException;
import com.apidemo.productservice.models.Product;
import com.apidemo.productservice.services.AuthenticationCommons;
import com.apidemo.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    @Qualifier("FakeStoreProductService")
    private ProductService productService;

//    @Autowired
//    private AuthenticationCommons  authenticationCommons;
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") Long id, @RequestBody ProductDTO product) throws ProductNotFoundException {
        return productService.updateProduct(product,id);
    }
    @PutMapping("{id}")
    public Product replaceProductById(@PathVariable("id") Long id,@RequestBody ProductDTO productDTO) throws ProductNotFoundException {
        return productService.replaceProduct(productDTO,id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.deleteProductById(id);
    }
}
