package com.dozie.OrderService.web.external.client;

import com.dozie.OrderService.web.exception.CustomException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "Product-Service/products")
public interface ProductService {

    @PutMapping("/reduceQuantity/{id}")
    ResponseEntity<Void> reduceQuantity(@PathVariable("id") String productId,
                                        @RequestParam("quantity") Integer quantity);

    default void fallback(Exception e){
        throw new CustomException("Product service not available at the moment", "Internal server error", 500);
    }
}
