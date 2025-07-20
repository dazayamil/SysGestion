package com.techlab.sysgestion.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ClientRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 5, max = 20)
    private String name;

    @NotBlank(message = "Last name is required")
    @Size(min = 5, max = 50)
    private String lastName;

    @Email(message = "format email invalid")
    private String email;

    @NotBlank(message = "Phone is required")
    @Size(min = 10, max = 20)
    private String phone;
}
