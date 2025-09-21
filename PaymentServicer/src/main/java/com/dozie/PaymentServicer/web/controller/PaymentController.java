package com.dozie.PaymentServicer.web.controller;

import com.dozie.PaymentServicer.web.dto.PaymentRequest;
import com.dozie.PaymentServicer.web.response.PaymentResponse;
import com.dozie.PaymentServicer.web.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/payments")
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/initiate-payment")
    public ResponseEntity<String> initiatePayment(@RequestBody PaymentRequest request) {
        return new ResponseEntity<>(paymentService.initiatePayment(request), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable String id) {
        return ResponseEntity.ok(paymentService.getPaymentDetails(id));
    }

}
