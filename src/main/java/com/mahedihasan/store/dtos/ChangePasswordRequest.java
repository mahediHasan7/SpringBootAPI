package com.mahedihasan.store.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChangePasswordRequest {
    @NotBlank(message = "Old Password is required")
    @Size(min = 4, max = 12, message = "Please enter your old password between 4-12 characters")
    private String oldPassword;

    @NotBlank(message = "New Password is required")
    @Size(min = 4, max = 12, message = "Please enter a new password between 4-12 characters")
    private String newPassword;
}
