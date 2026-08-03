package com.example.payme.service;

import com.example.payme.dto.CreateAccountRequest;
import com.example.payme.model.Account;
import com.example.payme.repository.AccountRepository;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountService {
    
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(CreateAccountRequest request) {
        accountRepository.createAccount(request);
    }

    public Account getAccountById(int id) {
        return accountRepository.getAccountById(id);
    }

    public List<Account> getAccountsByUserId(int userId) {
        return accountRepository.getAccountsByUserId(userId);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }
}
