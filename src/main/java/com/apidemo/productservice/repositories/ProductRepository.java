package com.apidemo.productservice.repositories;

import com.apidemo.productservice.models.Product;
import com.apidemo.productservice.repositories.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductByTitleContaining(String word);
    Product findProductById(Long id);
    List<Product> findProductByCategory_Id(Long id);
    List<Product> findAll();

    //HQL Example with projections
    @Query("select p.id as Id, p.title as Title from Product p where p.id = :id")
    List<ProductWithIdAndTitle> customerHQLQuery(@Param("id") Long id);

    //Native Query Example
    @Query(value = "select * from product p where p.id = :id")
    Product getMyProduct(@Param("id")Long id);
}
