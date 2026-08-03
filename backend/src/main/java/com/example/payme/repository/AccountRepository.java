package com.example.payme.repository;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.payme.dto.CreateAccountRequest;
import com.example.payme.model.Account;

@Repository
public class AccountRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Account> accountMapper = (rs, rowNum) -> {
        return new Account(
        rs.getInt("id"),
        rs.getInt("user_id"),
        rs.getString("account_number"),
        rs.getString("currency"),
        rs.getDouble("balance")
        );
    };

    public void createAccount(CreateAccountRequest request) {
        String sql = "INSERT INTO accounts (user_id, account_number, currency, balance) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, request.userId, request.accountNumber, request.currency, request.balance);
    }

    public Account getAccountById(int id) {
        String sql = "SELECT * FROM accounts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, accountMapper, id);
    }

    public List<Account> getAccountsByUserId(int userId) {
        String sql = "SELECT * FROM accounts WHERE user_id = ?";
        return jdbcTemplate.query(sql, accountMapper, userId);
    }

    public List<Account> getAllAccounts() {
        String sql = "SELECT * FROM accounts";
        return jdbcTemplate.query(sql, accountMapper);
    }
}
