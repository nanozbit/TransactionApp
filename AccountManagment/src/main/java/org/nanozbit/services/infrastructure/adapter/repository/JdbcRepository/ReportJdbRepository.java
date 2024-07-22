package org.nanozbit.services.infrastructure.adapter.repository.JdbcRepository;

import jakarta.transaction.Transactional;
import org.nanozbit.services.domain.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ReportJdbRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String REPORT_QUERY = """
           
            select
                p.name,
                a.account_number,
                a.account_type,
                SUM(t.value) AS total_transaction_amount
             FROM account a
             JOIN client c ON a.client_id = c.id
             join person p on c.id = p.id
             JOIN account_transactions at ON at.account_id = a.id
             JOIN transaction t ON at.transactions_id = t.id
             WHERE t.transaction_date BETWEEN ? AND ?
             GROUP BY a.account_number, a.account_type, p.name;
            """;

    public Iterable<Report> getReport(LocalDateTime initialDate, LocalDateTime endDate) {
        var response = jdbcTemplate.queryForList(REPORT_QUERY,
                initialDate,
                endDate);

        return response.stream().map(m -> {
            Report report = new Report();
            report.setName(String.valueOf(m.get("name")));
            report.setAccountNumber(String.valueOf(m.get("account_number")));
            report.setAccountType(String.valueOf(m.get("account_type")));
            report.setTotalTransaction(Double.parseDouble(m.get("total_transaction_amount") + ""));
            return report;
        }).collect(Collectors.toList());

    }
}
