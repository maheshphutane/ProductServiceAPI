package com.apidemo.productservice.services;

import com.apidemo.productservice.dtos.FakeStoreProductDTO;
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

@Service
public class FakeStoreProductService implements ProductService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        return convertDTOToProduct(fakeStoreProductDTO);
    }

    @Override
    public ResponseEntity<FakeStoreProductDTO> addProduct(FakeStoreProductDTO fakeStoreProductDTO) {

        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products",fakeStoreProductDTO, FakeStoreProductDTO.class);
        return responseEntity;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] productList = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDTO[].class);
        List<Product> ans = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : productList){
            ans.add(convertDTOToProduct(fakeStoreProductDTO));
        }
        return ans;
    }

    @Override
    public ResponseEntity<Product> updateProduct(FakeStoreProductDTO fakeStoreProductDTO, Long id) {
        Product product = restTemplate.patchForObject("https://fakestoreapi.com/products/"+id,convertDTOToProduct(fakeStoreProductDTO), Product.class);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public Product replaceProduct(FakeStoreProductDTO fakeStoreProductDTO, Long id) {
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductService.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductService.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertDTOToProduct(fakeStoreProductDTO1);
    }

    private Product convertDTOToProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImage(fakeStoreProductDTO.getImage());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDTO.getCategory());

        return product;
    }
}
