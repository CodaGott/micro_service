package com.dozie.OrderService.web.external.client;

import com.dozie.OrderService.web.entity.dto.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Payment-Service/api/v1/payments")
public interface PaymentService {

    @PostMapping("/initiate-payment")
    ResponseEntity<String> initiatePayment(@RequestBody PaymentRequest request);
}
