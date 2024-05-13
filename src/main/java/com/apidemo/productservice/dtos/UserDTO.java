package com.apidemo.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class UserDTO {
    private String email;
    private String username;
    private String hashedPass;
    private List<RolesDTO> rolesList;
    private Boolean isEmailVerified;

}
