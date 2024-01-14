package com.apidemo.productservice.controlleradvices;

import com.apidemo.productservice.dtos.ExceptionResponseDTO;
import com.apidemo.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> productControllerExceptionHandler(ProductNotFoundException e){
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO();
        responseDTO.setMsg(e.getMessage());
        responseDTO.setCode(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(responseDTO,HttpStatus.NOT_FOUND);
    }
}
