package com.apidemo.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class ExceptionResponseDTO {
    private String msg;
    private HttpStatus code;
}
