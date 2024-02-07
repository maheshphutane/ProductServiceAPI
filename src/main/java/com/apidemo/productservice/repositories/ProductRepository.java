package com.apidemo.productservice.repositories;

import com.apidemo.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductByTitleContaining(String word);
    Product findProductById(Long id);
    List<Product> findProductByCategory_Id(Long id);
    List<Product> findAll();
}
