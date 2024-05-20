package com.logical.tronixpayadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logical.tronixpayadmin.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
