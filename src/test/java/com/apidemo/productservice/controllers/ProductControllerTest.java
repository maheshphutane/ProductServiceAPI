package com.apidemo.productservice.controllers;

import com.apidemo.productservice.exceptions.ProductNotFoundException;
import com.apidemo.productservice.models.Product;
import com.apidemo.productservice.services.ProductService;
import org.assertj.core.util.Arrays;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@Ignore
class ProductControllerTest {
//    @Autowired
//    private ProductController productController;
//
//    @MockBean
//    private ProductService productService;
//
//    @Test
//    public void testProductService(){
//        when(productService.getAllProducts()).thenReturn(new ArrayList<>());
//        List<Product> productList = productService.getAllProducts();
//        assert productList.size()==0;
//    }
//
//    @Test
//    public void testGelAllProducts(){
//        Product p1 = new Product();
//        Product p2 = new Product();
//        p2.setTitle("P1");
//        List<Product> productList = List.of(p1,p2);
//        System.out.println(productList.getClass());
//    }
}