package com.dozie.ProductService.web.service;

import com.dozie.ProductService.web.model.request.ProductRequest;
import com.dozie.ProductService.web.model.response.ProductListResponse;
import com.dozie.ProductService.web.model.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);

    ProductListResponse getAll();

    ProductResponse getProductById(String id);

    void reduceQuantity(String productId, Integer quantity);
}
