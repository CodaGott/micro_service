package com.dozie.OrderService.web.external.response;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
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
