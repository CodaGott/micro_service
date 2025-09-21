package com.dozie.PaymentServicer.web.service;

import com.dozie.PaymentServicer.web.dto.PaymentRequest;
import com.dozie.PaymentServicer.web.entity.TransactionDetails;
import com.dozie.PaymentServicer.web.repository.TransactionDetailsRepository;
import com.dozie.PaymentServicer.web.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final TransactionDetailsRepository transactionDetailsRepository;
    private final BaseService baseService;

    @Override
    public String initiatePayment(PaymentRequest request) {

        TransactionDetails transaction  = new TransactionDetails();
        transaction.setAmount(request.getAmount());
        transaction.setPaymentMode(String.valueOf(request.getPaymentMode()));
        transaction.setOrderId(request.getOrderId());
        transaction.setPaymentStatus("Completed");
        transaction.setPaymentDate(OffsetDateTime.now());

        TransactionDetails savedTransaction = transactionDetailsRepository.save(transaction);

        return savedTransaction.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(String orderId) {
        TransactionDetails transactionDetails = transactionDetailsRepository.findByOrderId(orderId);
        if(transactionDetails == null){
            throw new RuntimeException("Order with id " + orderId + " not found"); // TODO : Change to the custom Exception later.
        }
        return baseService.buildTransactionResponse(transactionDetails);
    }
}
