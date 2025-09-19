package com.dozie.OrderService.web.entity.dto;

import com.dozie.OrderService.web.entity.enums.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private String orderId;
    private Long amount;
    private String referenceId;
    private PaymentMode paymentMode;
}
