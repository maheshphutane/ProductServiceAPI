package com.apidemo.productservice.services;

import com.apidemo.productservice.dtos.ProductDTO;
import com.apidemo.productservice.exceptions.ProductNotFoundException;
import com.apidemo.productservice.models.Category;
import com.apidemo.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        ProductDTO productDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductDTO.class);
        if(productDTO == null){
            throw new ProductNotFoundException("Product with Id: "+id+" Not Found.");
        }
        return convertDTOToProduct(productDTO);
    }

    @Override
    public ResponseEntity<Product> addProduct(Product product) {
        ResponseEntity<Product> responseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products", product, Product.class);
        return responseEntity;
    }

    @Override
    public List<Product> getAllProducts() {
        ProductDTO[] productList = restTemplate.getForObject("https://fakestoreapi.com/products", ProductDTO[].class);
        List<Product> ans = new ArrayList<>();
        for(ProductDTO productDTO : productList){
            ans.add(convertDTOToProduct(productDTO));
        }
        return ans;
    }

    @Override
    public ResponseEntity<Product> updateProduct(ProductDTO productDTO, Long id) {
        Product product = restTemplate.patchForObject("https://fakestoreapi.com/products/"+id,convertDTOToProduct(productDTO), Product.class);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public Product replaceProduct(ProductDTO productDTO, Long id) {
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductService.class);
        HttpMessageConverterExtractor<ProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductService.class, restTemplate.getMessageConverters());
        ProductDTO productDTO1 = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertDTOToProduct(productDTO1);
    }

    private Product convertDTOToProduct(ProductDTO productDTO){
        Product product = new Product();
//        product.setId(productDTO.getId());
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImage());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(productDTO.getCategory());

        return product;
    }
}
