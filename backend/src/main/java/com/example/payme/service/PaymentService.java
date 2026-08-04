package com.example.payme.service;

import com.example.payme.model.Payment;
import com.example.payme.dto.CreatePaymentRequest;
import com.example.payme.repository.PaymentRepository;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PaymentService {
    
    private final AccountService accountService;
    private final PaymentRepository paymentRepository;

    public PaymentService(AccountService accountService, PaymentRepository paymentRepository) {
        this.accountService = accountService;
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public void performPayment(CreatePaymentRequest request) {
        // start a transaction
        // debit
        // credit
        // add payment record
        // commit transaction
        
    }

    public Payment getPaymentDetails(int paymentId) {
        return paymentRepository.getPaymentById(paymentId);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.getAllPayments();
    }

    public List<Payment> getPaymentsByAccountId(int accountId) {
        return paymentRepository.getPaymentsByAccountId(accountId);
    }

    public List<Payment> getPaymentsByUserId(int userId) {
        return paymentRepository.getPaymentsByUserId(userId);
    }
}
