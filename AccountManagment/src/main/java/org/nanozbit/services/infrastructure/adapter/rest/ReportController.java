package org.nanozbit.services.infrastructure.adapter.rest;

import org.nanozbit.services.application.service.account.AccountService;
import org.nanozbit.services.domain.model.Account;
import org.nanozbit.services.domain.model.Report;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

    private final AccountService accountService;

    public ReportController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Report>> getAccount(@RequestParam("initialDate") LocalDateTime initialDate , @RequestParam("endDate") LocalDateTime endDate) {
        var report = this.accountService.getReport(initialDate, endDate);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

}
