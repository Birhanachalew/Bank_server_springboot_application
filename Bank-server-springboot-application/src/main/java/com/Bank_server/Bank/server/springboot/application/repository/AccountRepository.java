package com.Bank_server.Bank.server.springboot.application.repository;

import com.Bank_server.Bank.server.springboot.application.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
