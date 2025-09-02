package com.mahedihasan.store.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateOrUpdateProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Byte categoryId;
}
