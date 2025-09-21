package com.dozie.OrderService.web.response;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.OffsetDateTime;

@Builder
@Data
public class OrderResponse {
    private String orderId;
    private String orderStatus;
    private Instant orderDate;
    private Long amount;
    private ProductDetails productDetails;


    @Builder
    @Data
    public static class ProductDetails {
        private String id;
        private String name;
        private String description;
        private String category;
        private Double price;
        private String image;
        private Long quantity;
        private OffsetDateTime createdDate;
    }
}
