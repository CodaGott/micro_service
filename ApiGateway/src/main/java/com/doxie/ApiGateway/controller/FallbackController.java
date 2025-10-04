package com.doxie.ApiGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/orderServiceFallBack")
    public String orderServiceFallback() {
        return "Order-Service is currently unavailable try later or contact us via any of our channels for support";
    }

    @GetMapping("/productServiceFallBack")
    public String productServiceFallback() {
        return "Product-Service is currently unavailable try later or contact us via any of our channels for support";
    }

    @GetMapping("/paymentServiceFallBack")
    public String paymentServiceFallback() {
        return "Payment-Service is currently unavailable try later or contact us via any of our channels for support";
    }
}
