package com.dozie.OrderService.web.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderResponse {
    private String orderId;
    private String orderStatus;
}
