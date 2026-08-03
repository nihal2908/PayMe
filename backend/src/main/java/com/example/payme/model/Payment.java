package com.example.payme.model;

public class Payment {
    private int id;
    private int senderUserId;
    private int senderAccountId;
    private int receiverUserId;
    private int receiverAccountId;
    private double amount;

    public Payment(int id, int senderUserId, int senderAccountId, int receiverUserId, int receiverAccountId, double amount) {
        this.id = id;
        this.senderUserId = senderUserId;
        this.senderAccountId = senderAccountId;
        this.receiverUserId = receiverUserId;
        this.receiverAccountId = receiverAccountId;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSenderUserId() {
        return senderUserId;
    }
    public void setSenderUserId(int senderUserId) {
        this.senderUserId = senderUserId;
    }
    public int getSenderAccountId() {
        return senderAccountId;
    }
    public void setSenderAccountId(int senderAccountId) {
        this.senderAccountId = senderAccountId;
    }
    public int getReceiverUserId() {
        return receiverUserId;
    }
    public void setReceiverUserId(int receiverUserId) {
        this.receiverUserId = receiverUserId;
    }
    public int getReceiverAccountId() {
        return receiverAccountId;
    }
    public void setReceiverAccountId(int receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

}
