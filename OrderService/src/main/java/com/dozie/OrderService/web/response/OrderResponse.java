package com.dozie.OrderService.web.response;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class OrderResponse {
    private String orderId;
    private String orderStatus;
    private Instant orderDate;
    private Long amount;
}
