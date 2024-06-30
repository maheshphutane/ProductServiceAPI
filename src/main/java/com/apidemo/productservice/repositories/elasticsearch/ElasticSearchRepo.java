package com.apidemo.productservice.repositories.elasticsearch;

import com.apidemo.productservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface ElasticSearchRepo extends ElasticsearchRepository<Product,Long> {
    //List<Product> findProductByTitleContaining(String word);
   // Optional<Product> findProductById(Long id);
//    List<Product> findProductByCategory_Id(Long id);
//    Page<Product> findAll(Pageable pageable);
//    void deleteProductById(Long id);
}
