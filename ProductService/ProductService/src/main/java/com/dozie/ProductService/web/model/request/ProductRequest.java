package com.dozie.ProductService.web.model.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private String category;
    private Double price;
    private String image;
    private Long quantity;
}
