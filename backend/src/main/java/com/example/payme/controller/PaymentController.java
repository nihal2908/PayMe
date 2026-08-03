package com.example.payme.controller;

import com.example.payme.dto.CreatePaymentRequest;
import com.example.payme.model.Payment;
import com.example.payme.service.PaymentService;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/perform")
    public void performPayment(@RequestBody CreatePaymentRequest request) {
        paymentService.performPayment(request);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{paymentId}")
    public Payment getPaymentDetails(@PathVariable int paymentId) {
        return paymentService.getPaymentDetails(paymentId);
    }

    @GetMapping("/account/{accountId}")
    public List<Payment> getPaymentsByAccountId(@PathVariable int accountId) {
        return paymentService.getPaymentsByAccountId(accountId);
    }

    @GetMapping("/user/{userId}")
    public List<Payment> getPaymentsByUserId(@PathVariable int userId) {
        return paymentService.getPaymentsByUserId(userId);
    }

}
