package com.dozie.ProductService.web.model.response;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Builder
@Data
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private String category;
    private Double price;
    private String image;
    private Long quantity;
    private OffsetDateTime createdDate;
}
