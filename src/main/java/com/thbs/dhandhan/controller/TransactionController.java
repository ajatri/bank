package com.thbs.dhandhan.controller;

import com.thbs.dhandhan.controller.request.MiniStatementRequest;
import com.thbs.dhandhan.controller.request.TransactionRequest;
import com.thbs.dhandhan.data.entity.Transaction;
import com.thbs.dhandhan.data.repo.TransactionRepo;
import com.thbs.dhandhan.data.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @Autowired
    TransactionRepo transactionRepo;

    @GetMapping("/transactions")
    public List<Transaction> getTransaction() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transactions/{id}")
    public Transaction getTransaction(@PathVariable("id") Integer id) {
        return transactionService.getTransaction(id);
    }

    @PostMapping("/transactions")
    public Boolean addTransaction(@RequestBody TransactionRequest transactionRequest) {
        System.out.println(transactionRequest);
        return transactionService.transact(transactionRequest);
    }

    @PostMapping("/transactions/miniStatement")
    public List<Transaction>  getMiniStatement(@RequestBody MiniStatementRequest miniStatementRequest) {
        Integer customerId =  miniStatementRequest.getCustomerId();
        return transactionService.statement(customerId);
    }

    @DeleteMapping("/transactions/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) {
        transactionRepo.deleteById(id);
    }

}