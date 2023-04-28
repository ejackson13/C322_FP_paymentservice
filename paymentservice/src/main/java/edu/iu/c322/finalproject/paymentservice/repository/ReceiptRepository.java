package edu.iu.c322.finalproject.paymentservice.repository;

import edu.iu.c322.finalproject.paymentservice.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
    Receipt getReceiptByOrderId(int orderId);
}
