package com.apidemo.productservice;

import com.apidemo.productservice.repositories.CategoryRepository;
import com.apidemo.productservice.repositories.ProductRepository;
import com.apidemo.productservice.repositories.projections.ProductWithIdAndTitle;
import com.apidemo.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Test
    void contextLoads() {
    }

    @Test
    public void testQueries(){
        productRepository.findProductByTitleContaining("Mahesh");
//        List<ProductWithIdAndTitle> ans =  productRepository.customerHQLQuery(2L);
//        for(ProductWithIdAndTitle product : ans){
//            System.out.println(product.getId());
//            System.out.println(product.getTitle());
//        }
        categoryRepository.findById(1L);
        productRepository.findById(2L);
    }
}
