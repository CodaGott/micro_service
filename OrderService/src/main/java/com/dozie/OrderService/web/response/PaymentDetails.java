package com.dozie.OrderService.web.response;

import com.dozie.OrderService.web.entity.enums.PaymentMode;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class PaymentDetails {
    private String orderId;
    private Long amount;
    private String referenceId;
    private PaymentMode paymentMode;
    private OffsetDateTime paymentDate;
}
