package com.apidemo.productservice.services;

import com.apidemo.productservice.dtos.ProductDTO;
import com.apidemo.productservice.exceptions.ProductNotFoundException;
import com.apidemo.productservice.models.Category;
import com.apidemo.productservice.models.Product;
import com.apidemo.productservice.repositories.jpa.CategoryRepository;
import com.apidemo.productservice.repositories.jpa.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
@Primary
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
        if(categoryOptional.isPresent()) {
            product.setCategory(categoryOptional.get());
        }
       else{
//            Category category = product.getCategory();
//            category.setCreatedAt(Date.valueOf(LocalDate.now()));
//            category.setProductList(new ArrayList<>());
//            category.getProductList().add(product);
//            categoryRepository.save(category);
        }
        product.setCreatedAt(Date.valueOf(LocalDate.now()));
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNumber,pageSize));
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
