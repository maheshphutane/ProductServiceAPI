package com.apidemo.productservice.repositories;

import com.apidemo.productservice.models.Product;
import com.apidemo.productservice.repositories.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductByTitleContaining(String word);
    Optional<Product> findProductById(Long id);
    List<Product> findProductByCategory_Id(Long id);
    List<Product> findAll();
    void deleteProductById(Long id);

    //HQL Example with projections
    @Query("select p.id as id, p.title as title from Product p where p.id = :id")
    List<ProductWithIdAndTitle> customerHQLQuery(@Param("id") Long id);

    //Native Query Example
    @Query(value = "select p from product p where p.id = :id",nativeQuery = true)
    Product getMyProduct(@Param("id")Long id);
}
