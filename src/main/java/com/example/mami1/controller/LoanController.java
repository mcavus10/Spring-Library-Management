package com.example.mami1.controller;

import com.example.mami1.dto.LoanDTO;
import com.example.mami1.model.Loan;
import com.example.mami1.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public List<LoanDTO> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanDTO> getLoanById(@PathVariable Long id) {
        Optional<LoanDTO> loan = loanService.getLoanById(id);
        return loan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@Valid @RequestBody LoanDTO loanDTO) {
        Loan createdLoan = loanService.createLoan(loanDTO);
        return ResponseEntity.ok(createdLoan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @Valid @RequestBody LoanDTO loanDTO) {
        Optional<Loan> updatedLoan = loanService.updateLoan(id, loanDTO);
        return updatedLoan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        return loanService.deleteLoan(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
