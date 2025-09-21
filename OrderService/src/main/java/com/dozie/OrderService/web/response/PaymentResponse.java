package com.dozie.OrderService.web.response;

import com.dozie.OrderService.web.entity.enums.PaymentMode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {
    private String orderId;
    private Long amount;
    private String referenceId;
    private PaymentMode paymentMode;
}
