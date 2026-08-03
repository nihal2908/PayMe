package com.example.payme.dto;

public class CreateAccountRequest {
    public int userId;
    public String accountNumber;
    public String currency;
    public double balance;
    
    public CreateAccountRequest(int userId, String accountNumber, String currency, double balance) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = balance;
    }
}
