package com.dozie.PaymentServicer.web.service;

import com.dozie.PaymentServicer.web.dto.PaymentRequest;
import com.dozie.PaymentServicer.web.response.PaymentResponse;
import org.springframework.http.HttpStatusCode;

public interface PaymentService {
    String initiatePayment(PaymentRequest request);

    PaymentResponse getPaymentDetails(String id);
}
