package com.dozie.OrderService.web.service;

import com.dozie.OrderService.web.entity.Order;
import com.dozie.OrderService.web.request.OrderRequest;
import com.dozie.OrderService.web.response.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    public OrderResponse buildOrderResponse(Order request){
        return OrderResponse.builder()
                .orderId(request.getId())
                .orderStatus(request.getOrderStatus())
                .orderDate(request.getOrderDate())
                .amount(request.getAmount())
                .build();
    }
}
