package com.dozie.PaymentServicer.web.controller;

import com.dozie.PaymentServicer.web.dto.PaymentRequest;
import com.dozie.PaymentServicer.web.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/v1/payments")
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/initiate-payment")
    public ResponseEntity<String> initiatePayment(@RequestBody PaymentRequest request) {
        return new ResponseEntity<>(paymentService.initiatePayment(request), HttpStatus.OK);
    }

}
