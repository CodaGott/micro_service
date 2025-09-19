package com.dozie.PaymentServicer.web.repository;

import com.dozie.PaymentServicer.web.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, String> {
}
