package com.techlab.sysgestion.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponseDto {
    private int id;
    private String name;
    private String lastName;
    private String phone;
    private String email;
}
