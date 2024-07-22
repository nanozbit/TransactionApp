package org.nanozbit.services.infrastructure.adapter.rest;

import org.nanozbit.services.application.service.Transaction.TransactionService;
import org.nanozbit.services.domain.model.Account;
import org.nanozbit.services.domain.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Transaction>> getAllTransactions() {
        return new ResponseEntity<>(this.transactionService.getTransactions(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long id) {
        var transaction = this.transactionService.getTransaction(id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        var transactionResponse = this.transactionService.saveTransaction(transaction);
        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") Long id, @RequestBody Transaction transaction) {
        var transactionResponse = this.transactionService.updateTransaction(id, transaction);
        return new ResponseEntity<>(transactionResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTransaction(@PathVariable("id") Long id) {
        this.transactionService.deleteTransaction(id);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
