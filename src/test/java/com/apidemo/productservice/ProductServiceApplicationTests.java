package com.apidemo.productservice;

import com.apidemo.productservice.repositories.ProductRepository;
import com.apidemo.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Test
    void contextLoads() {
    }

    @Test
    public void testQueries(){
        productRepository.findProductByTitleContaining("Mahesh");
    }
}
