package com.dozie.ProductService.web.service;

import com.dozie.ProductService.web.model.entity.Product;
import com.dozie.ProductService.web.model.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class BaseService {

    public ProductResponse buildProductResponse(Product request){
        return ProductResponse.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(request.getImage())
                .category(request.getCategory())
                .quantity(request.getQuantity())
                .createdDate(OffsetDateTime.now())
                .build();
    }
}
