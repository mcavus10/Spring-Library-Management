package com.example.mami1.repository;

import com.example.mami1.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    // Özel sorgular eklenecekse burada tanımlanır
}
