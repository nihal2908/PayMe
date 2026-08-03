package com.example.payme.dto;

public class CreatePaymentRequest {
    public int senderUserId;
    public int senderAccountId;
    public int receiverUserId;
    public int receiverAccountId;
    public double amount;
}
