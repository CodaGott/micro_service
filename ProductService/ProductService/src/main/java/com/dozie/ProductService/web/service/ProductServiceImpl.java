package com.dozie.ProductService.web.service;

import com.dozie.ProductService.web.exception.ProductServiceCustomException;
import com.dozie.ProductService.web.model.entity.Product;
import com.dozie.ProductService.web.model.request.ProductRequest;
import com.dozie.ProductService.web.model.response.ProductListResponse;
import com.dozie.ProductService.web.model.response.ProductResponse;
import com.dozie.ProductService.web.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository  productRepository;
    private final BaseService baseService;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        log.info("creating product");
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .image(request.getImage())
                .quantity(request.getQuantity())
                .category(request.getCategory())
                .price(request.getPrice())
                .createdAt(OffsetDateTime.now())
                .build();
        productRepository.save(product);
        log.info("product created");
        return baseService.buildProductResponse(product);
    }

    @Override
    public ProductListResponse getAll() {
        List<ProductResponse> responses = productRepository.findAll()
                .stream()
                .map(baseService::buildProductResponse)
                .collect(Collectors.toList());
        return new ProductListResponse(responses.size(), responses);
    }

    @Override
    public ProductResponse getProductById(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductServiceCustomException("Product with Id not found", "404"));
        return baseService.buildProductResponse(product);
    }

    @Override
    public void reduceQuantity(String productId, Integer quantity) {
        log.info("Reducing the quantity of product with id : {}", productId);
        Product productToReduce = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException("Product with Id not found", "404"));

        if (productToReduce.getQuantity() < quantity) {
            throw new ProductServiceCustomException("Product quantity we have is less than what you want now", "404");
        }else {
            productToReduce.setQuantity(productToReduce.getQuantity() - quantity);
            productRepository.save(productToReduce);

            log.info("product reduced successfully");
        }
    }

}
