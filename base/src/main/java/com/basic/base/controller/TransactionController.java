package com.basic.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.base.model.Transaction;
import com.basic.base.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<Transaction> deposit(@RequestBody Transaction transaction) {
        try {
            Transaction newTransaction = transactionService.deposit(transaction.getAccountNumber(),
                    transaction.getAmount());
            return ResponseEntity.ok(newTransaction);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> withdraw(@RequestBody Transaction transaction) {
        try {
            Transaction newTransaction = transactionService.withdraw(transaction.getAccountNumber(),
                    transaction.getAmount());
            return ResponseEntity.ok(newTransaction);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // @GetMapping("/recent")
    // public ResponseEntity<List<Transaction>> getRecentTransactions() {

    // }

}
