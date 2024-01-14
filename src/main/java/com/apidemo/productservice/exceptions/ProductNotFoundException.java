package com.apidemo.productservice.exceptions;

public class ProductNotFoundException extends Exception {
    private String msg;
    public ProductNotFoundException(String msg){
        super(msg);
        this.msg = msg;
    }
}
