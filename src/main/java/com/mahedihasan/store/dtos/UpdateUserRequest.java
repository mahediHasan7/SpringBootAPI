package com.mahedihasan.store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateUserRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Name is required")
    @Email(message = "Valid email address is required")
    private String email;
}
