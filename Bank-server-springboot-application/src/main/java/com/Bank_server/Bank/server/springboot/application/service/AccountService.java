package com.Bank_server.Bank.server.springboot.application.service;

import com.Bank_server.Bank.server.springboot.application.model.Account;
import com.Bank_server.Bank.server.springboot.application.repository.AccountRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account creatAccount(Account account){
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long id){
        return accountRepository.findById(id);
    }
    public Account deposit(Long id, double amount){
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    public Account withdraw(Long id, double amount){
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("account not found"));
        if (account.getBalance() < amount){
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

}
