package com.dozie.PaymentServicer.web.response;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class OrderResponse {
    private String orderId;
    private String orderStatus;
    private Instant orderDate;
    private Long amount;
    private ProductDetails productDetails;
}
