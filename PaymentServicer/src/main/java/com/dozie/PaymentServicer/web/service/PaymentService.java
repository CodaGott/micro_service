package com.dozie.PaymentServicer.web.service;

import com.dozie.PaymentServicer.web.dto.PaymentRequest;

public interface PaymentService {
    String initiatePayment(PaymentRequest request);
}
