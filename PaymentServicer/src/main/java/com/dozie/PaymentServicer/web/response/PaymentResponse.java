package com.dozie.PaymentServicer.web.response;

import com.dozie.PaymentServicer.web.dto.PaymentMode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {
    private String orderId;
    private Long amount;
    private String referenceId;
    private PaymentMode paymentMode;
    private OrderResponse orderResponse;
}
