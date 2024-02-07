package com.apidemo.productservice.services;

import com.apidemo.productservice.dtos.ProductDTO;
import com.apidemo.productservice.exceptions.ProductNotFoundException;
import com.apidemo.productservice.models.Category;
import com.apidemo.productservice.models.Product;
import com.apidemo.productservice.repositories.CategoryRepository;
import com.apidemo.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return productRepository.findProductById(id);
    }

    @Override
    @Transactional
    public ResponseEntity<Product> addProduct(Product product) {
        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());
        categoryOptional.ifPresent(product::setCategory);
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity<Product> updateProduct(ProductDTO productDTO, Long id) {
//        productDTO.setId(id);
        Product product = convertDTOToProduct(productDTO);
        return new ResponseEntity<>(productRepository.save(product),HttpStatus.OK);
    }

    @Override
    @Transactional
    public Product replaceProduct(ProductDTO productDTO, Long id) {
//        productDTO.setId(id);
        Product product = convertDTOToProduct(productDTO);
        return productRepository.save(product);
    }
    private Product convertDTOToProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImage());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(productDTO.getCategory());

        return product;
    }
}
