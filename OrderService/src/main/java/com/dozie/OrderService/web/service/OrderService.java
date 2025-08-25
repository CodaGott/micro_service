package com.dozie.OrderService.web.service;


import com.dozie.OrderService.web.request.OrderRequest;
import com.dozie.OrderService.web.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);
    List<OrderResponse> getOrders();
}
