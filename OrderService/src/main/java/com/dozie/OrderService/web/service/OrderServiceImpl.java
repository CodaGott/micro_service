package com.dozie.OrderService.web.service;

import com.dozie.OrderService.web.entity.Order;
import com.dozie.OrderService.web.external.client.ProductService;
import com.dozie.OrderService.web.repository.OrderRepository;
import com.dozie.OrderService.web.request.OrderRequest;
import com.dozie.OrderService.web.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    private final com.dozie.OrderService.web.service.BaseService baseService;

    @Override
    public OrderResponse createOrder(OrderRequest request) {

        // Order entity
        // Product Service
        // Payment service
        // Cancel ==> if order fails

        productService.reduceQuantity(request.getProductId(), request.getQuantity());
        log.info("Creating Order with status created");
        log.info("create Order {}", request);
        Order order = Order.builder()
                .orderStatus("CREATED")
                .productId(request.getProductId())
                .amount(request.getTotalPrice())
                .quantity(request.getQuantity())
                .orderDate(Instant.now())
                .build();

        order = orderRepository.save(order);

        log.info("order completed {}", order);

        return baseService.buildOrderResponse(order);
    }

    @Override
    public List<OrderResponse> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(baseService::buildOrderResponse)
                .collect(Collectors.toList());
    }
}
