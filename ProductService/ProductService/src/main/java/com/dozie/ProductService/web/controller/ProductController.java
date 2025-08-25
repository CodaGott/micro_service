package com.dozie.ProductService.web.controller;

import com.dozie.ProductService.web.model.request.ProductRequest;
import com.dozie.ProductService.web.model.response.ProductListResponse;
import com.dozie.ProductService.web.model.response.ProductResponse;
import com.dozie.ProductService.web.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {
        ProductResponse productResponse = productService.createProduct(request);
        return ResponseEntity.ok().body(productResponse);
    }

    @GetMapping
    public ResponseEntity<ProductListResponse > getAllProducts() {
        ProductListResponse productResponses = productService.getAll();
        return ResponseEntity.ok().body(productResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        ProductResponse productResponse = productService.getProductById(id);
        return ResponseEntity.ok().body(productResponse);
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") String productId,
                                               @RequestParam("quantity") Integer quantity) {
        log.info("Reducing the quantity of product with id : {}", productId);

        productService.reduceQuantity(productId, quantity);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
