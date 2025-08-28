package com.dozie.OrderService.web.request;

import com.dozie.OrderService.web.entity.enums.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private String productId;
    private Integer quantity;
    private Long totalPrice;
    private PaymentMode paymentMode;

}
