package com.dozie.PaymentServicer.web.service;

import com.dozie.PaymentServicer.web.dto.PaymentMode;
import com.dozie.PaymentServicer.web.entity.TransactionDetails;
import com.dozie.PaymentServicer.web.response.OrderResponse;
import com.dozie.PaymentServicer.web.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BaseService {

    private final RestTemplate restTemplate;


    public PaymentResponse buildTransactionResponse(TransactionDetails transactionDetails) {

        return PaymentResponse.builder()
                .paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
                .amount(transactionDetails.getAmount())
                .referenceId(transactionDetails.getReferenceNumber())
                .orderId(transactionDetails.getOrderId())
                .paymentDate(transactionDetails.getPaymentDate())
                .build();
    }
}
