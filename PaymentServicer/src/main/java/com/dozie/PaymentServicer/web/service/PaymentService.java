package com.dozie.PaymentServicer.web.service;

import com.dozie.PaymentServicer.web.dto.PaymentRequest;
import com.dozie.PaymentServicer.web.response.PaymentResponse;

public interface PaymentService {
    String initiatePayment(PaymentRequest request);

    PaymentResponse getPaymentDetailsByOrderId(String id);
}
