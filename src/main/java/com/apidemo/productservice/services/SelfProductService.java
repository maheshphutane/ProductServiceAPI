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

import java.sql.Date;
import java.time.LocalDate;
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
        Optional<Product> productOptional = productRepository.findProductById(id);
        if(productOptional.isPresent()){
            return productOptional.get();
        }
        throw new ProductNotFoundException("Product Not Found for the given Id");
    }

    @Override
    @Transactional
    public ResponseEntity<Product> addProduct(Product product) {
        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());
        categoryOptional.ifPresent(product::setCategory);
        product.setCreatedAt(Date.valueOf(LocalDate.now()));
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity<Product> updateProduct(ProductDTO productDTO, Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findProductById(id);
        if(productOptional.isPresent()) {
            Product product = convertDTOToProduct(productDTO);
            product.setCreatedAt(Date.valueOf(LocalDate.now()));
            return new ResponseEntity<>(productRepository.save(product),HttpStatus.OK);
        }else{
            throw new ProductNotFoundException("Product with id: "+id +" Not Found");
        }
    }

    @Override
    @Transactional
    public Product replaceProduct(ProductDTO productDTO, Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findProductById(id);
        if(productOptional.isPresent()) {
            Product product = convertDTOToProduct(productDTO);
            product.setCreatedAt(Date.valueOf(LocalDate.now()));
            return productRepository.save(product);
        }else{
            throw new ProductNotFoundException("Product with id :"+id +" Not Found");
        }
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findProductById(id);
        if(productOptional.isPresent()){
            productRepository.deleteProductById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            throw new ProductNotFoundException("Product with id : "+id+" Not Found");
        }
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
