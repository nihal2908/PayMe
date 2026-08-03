package com.example.payme.repository;

import com.example.payme.dto.CreatePaymentRequest;
import com.example.payme.model.Payment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public PaymentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Payment> paymentMapper = (rs, rowNum) -> {
        return new Payment(
            rs.getInt("id"),
            rs.getInt("sender_id"),
            rs.getInt("sender_account_id"),
            rs.getInt("receiver_id"),
            rs.getInt("receiver_account_id"),
            rs.getDouble("amount")
        );
    };

    public void createPayment(CreatePaymentRequest request) {
        String sql = "INSERT INTO payments (sender_id, sender_account_id, receiver_id, receiver_account_id, amount) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, request.senderUserId, request.senderAccountId, request.receiverUserId, request.receiverAccountId, request.amount);
    }

    public Payment getPaymentById(int id) {
        String sql = "SELECT * FROM payments WHERE id = ?";
        Payment payment = jdbcTemplate.queryForObject(sql, paymentMapper, id);
        return payment;
    }

    public List<Payment> getPaymentsByAccountId(int accountId) {
        String sql = "SELECT * FROM payments WHERE sender_account_id = ? OR receiver_account_id = ?";
        return jdbcTemplate.query(sql, paymentMapper, accountId, accountId);
    }

    public List<Payment> getPaymentsByUserId(int userId) {
        String sql = "SELECT * FROM payments WHERE sender_id = ? OR receiver_id = ?";
        return jdbcTemplate.query(sql, paymentMapper, userId, userId);
    }

    public List<Payment> getAllPayments() {
        String sql = "SELECT * FROM payments";
        return jdbcTemplate.query(sql, paymentMapper);
    }
}
