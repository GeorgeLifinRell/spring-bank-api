package com.basic.base.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.base.enums.TransactionType;
import com.basic.base.model.Account;
import com.basic.base.model.Transaction;
import com.basic.base.repository.AccountRepository;
import com.basic.base.repository.TransactionRepository;


@Service
public class TransactionService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public Transaction deposit(String accountNumber, double amount) throws Exception {
        Account existingAccount = accountRepository.findAccountByAccountNumber(accountNumber);
        if (existingAccount != null) {
            double accountBalance = existingAccount.getBalance();
            double newBalance = accountBalance + amount;
            Transaction transaction = new Transaction();
            transaction.setAccountNumber(accountNumber);
            transaction.setAmount(amount);
            transaction.setType(TransactionType.CREDIT);
            transaction.setCreatedAt(new Date(System.currentTimeMillis()));
            transaction.setBalanceAfter(newBalance);
            return transactionRepository.save(transaction);
        } else {
            throw new Exception("Account not found");
        }
    }

    public Transaction withdraw(String accountNumber, double amount) throws Exception{
        Account existingAccount = accountRepository.findAccountByAccountNumber(accountNumber);
        if (existingAccount != null) {
            double accountBalance = existingAccount.getBalance();
            if (accountBalance < amount) {
                throw new Exception("Insufficient balance");
            }
            double newBalance = accountBalance - amount;
            Transaction transaction = new Transaction();
            transaction.setAccountNumber(accountNumber);
            transaction.setAmount(amount);
            transaction.setType(TransactionType.DEBIT);
            transaction.setCreatedAt(new Date(System.currentTimeMillis()));
            transaction.setBalanceAfter(newBalance);
            accountRepository.updateBalanceByAccountNumber(existingAccount.getAccountNumber(), newBalance);
            return transactionRepository.save(transaction);
        } else {
            throw new Exception("Account not found");
        }
    }
}
