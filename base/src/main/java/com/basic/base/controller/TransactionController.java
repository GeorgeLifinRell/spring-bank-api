package com.basic.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.base.model.Transaction;
import com.basic.base.service.impl.TransactionServiceImpl;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionServiceImpl transactionServiceImpl;

    @PostMapping("/deposit")
    public ResponseEntity<Transaction> deposit(@RequestBody Transaction transaction) {
        try {
            Transaction newTransaction = transactionServiceImpl.deposit(transaction.getAccountNumber(),
                    transaction.getAmount());
            return ResponseEntity.ok(newTransaction);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> withdraw(@RequestBody Transaction transaction) {
        try {
            Transaction newTransaction = transactionServiceImpl.withdraw(transaction.getAccountNumber(),
                    transaction.getAmount());
            return ResponseEntity.ok(newTransaction);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/recent")
    public ResponseEntity<List<Transaction>> getRecentTransactions(@RequestBody String accountNumber) {
        try {
            List<Transaction> recentTransactions = transactionServiceImpl.getRecentTransactions(accountNumber, 10);
            return ResponseEntity.ok(recentTransactions);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
