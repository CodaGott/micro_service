package com.dozie.OrderService.web.service;

import com.dozie.OrderService.web.entity.Order;
import com.dozie.OrderService.web.external.response.ProductResponse;
import com.dozie.OrderService.web.response.OrderResponse;
import com.dozie.OrderService.web.response.PaymentDetails;
import com.dozie.OrderService.web.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BaseService {

    private final RestTemplate restTemplate;

    public OrderResponse buildOrderResponse(Order request, boolean includeProductDetails){

        OrderResponse.ProductDetails productDetails = null;
        PaymentResponse paymentResponse = null;
        PaymentDetails paymentDetails = null;
        if (includeProductDetails) {
            ProductResponse productResponse = restTemplate.getForObject(
                    "http://PRODUCT-SERVICE/products/" + request.getProductId(), ProductResponse.class
            );
            if (productResponse != null) {
                productDetails = OrderResponse.ProductDetails.builder()
                        .id(request.getProductId())
                        .name(productResponse.getName())
                        .description(productResponse.getDescription())
                        .price(productResponse.getPrice())
                        .quantity(productResponse.getQuantity())
                        .image(productResponse.getImage())
                        .category(productResponse.getCategory())
                        .createdDate(productResponse.getCreatedDate())
                        .build();
            }
            paymentResponse = restTemplate.getForObject(
                    "http://PAYMENT-SERVICE/api/v1/payments/order/" + request.getId(), PaymentResponse.class
            );
            if (paymentResponse != null) {
                 paymentDetails = PaymentDetails.builder()
                        .amount(paymentResponse.getAmount())
                        .paymentDate(paymentResponse.getPaymentDate())
                        .referenceId(paymentResponse.getReferenceId())
                        .paymentMode(paymentResponse.getPaymentMode())
                        .orderId(paymentResponse.getOrderId())
                        .build();
            }

        }

        return OrderResponse.builder()
                .orderId(request.getId())
                .orderStatus(request.getOrderStatus())
                .orderDate(request.getOrderDate())
                .amount(request.getAmount())
                .productDetails(productDetails)
                .paymentDetails(paymentDetails)
                .build();
    }
}
