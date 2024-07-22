package org.nanozbit.services.infrastructure.adapter.rest;

import org.nanozbit.services.application.service.account.AccountService;
import org.nanozbit.services.domain.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Account>> getAccounts() {
        return new ResponseEntity<>(this.accountService.getAccounts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
        var account = this.accountService.getAccount(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        var accountResponse = this.accountService.saveAccount(account);
        return new ResponseEntity<>(accountResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") Long id, @RequestBody Account account) {
        var accountResponse = this.accountService.updateAccount(id, account);
        return new ResponseEntity<>(accountResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteAccount(@PathVariable("id") Long id) {
        this.accountService.deleteAccount(id);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
