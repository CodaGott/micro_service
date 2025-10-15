package com.dozie.OrderService.web.external.client;

import com.dozie.OrderService.web.entity.dto.PaymentRequest;
import com.dozie.OrderService.web.exception.CustomException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "Payment-Service/api/v1/payments")
public interface PaymentService {

    @PostMapping("/initiate-payment")
    ResponseEntity<String> initiatePayment(@RequestBody PaymentRequest request);

    default void fallback(Exception e){
        throw new CustomException("Payment service not available at the moment", "UNAVAILABLE", 500);
    }
}
