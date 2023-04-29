package edu.iu.c322.finalproject.paymentservice.controller;

import edu.iu.c322.finalproject.paymentservice.model.*;
import edu.iu.c322.finalproject.paymentservice.repository.ReceiptRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private ReceiptRepository receiptRepository;

    public PaymentController(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }


    // return order info for all orders given customer/seller id
    @GetMapping("/{type}/{userId}")
    @CrossOrigin()
    public List<Summary> getAllOrderInfo(@PathVariable String type, @PathVariable int userId) {
        List<Receipt> allReceipts = receiptRepository.findAll();
        List<Receipt> validReceipts = new ArrayList<>();

        for(Receipt r:allReceipts) {
            Order order = r.getOrder();


            if(type.equals("customer")) {
                if(order.getCustomer() == userId)
                    validReceipts.add(r);
            } else {
                if(order.getSellerId() == userId)
                    validReceipts.add(r);
            }
        }

        SummaryTemplate summaryMaker = templateFactory(type);
        return summaryMaker.createSummary(validReceipts);
    }

    // return order info for the given customer/seller id and order id
    @GetMapping("/{type}/{userId}/{orderId}")
    @CrossOrigin()
    public Summary getOrderInfoById(@PathVariable String type, @PathVariable int userId, @PathVariable int orderId) {
        Receipt receipt = receiptRepository.getReceiptByOrderId(orderId);

        if(receipt==null) {
            throw new IllegalStateException("No order with this id exists");
        }

        if(type.equals("customer")){
            if(receipt.getOrder().getCustomer() != userId) {
                throw new IllegalStateException("No order with this id exists for this customer");
            }
        } else {
            if(receipt.getOrder().getSellerId() != userId) {
                throw new IllegalStateException("No order with this id exists for this seller");
            }
        }

        SummaryTemplate summaryMaker = templateFactory(type);
        return summaryMaker.createSummary(receipt);
    }
    
    
    // factory method
    private SummaryTemplate templateFactory(String type) {
        if(type.equals("customer")) {
            return new SummaryTemplateCustomer();
        } else {
            return new SummaryTemplateSeller();
        }
    }
}
