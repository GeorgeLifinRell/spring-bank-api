package com.basic.base.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.basic.base.model.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String>{
    
}
