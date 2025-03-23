package com.example.mami1.service;

import com.example.mami1.dto.LoanDTO;
import com.example.mami1.model.Book;
import com.example.mami1.model.Loan;
import com.example.mami1.model.User;
import com.example.mami1.repository.BookRepository;
import com.example.mami1.repository.LoanRepository;
import com.example.mami1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    // ✔ Tüm ödünç kayıtlarını getir
    public List<LoanDTO> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ✔ ID ile ödünç bilgisi getir
    public Optional<LoanDTO> getLoanById(Long id) {
        return loanRepository.findById(id)
                .map(this::convertToDTO);
    }

    // ✔ Yeni ödünç oluştur (Kullanıcı ve kitap kontrolü ile)
    public Loan createLoan(LoanDTO loanDTO) {
        User user = userRepository.findById(loanDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı (ID: " + loanDTO.getUserId() + ")"));

        Book book = bookRepository.findById(loanDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı (ID: " + loanDTO.getBookId() + ")"));

        Loan loan = Loan.builder()
                .user(user)
                .book(book)
                .loanDate(loanDTO.getLoanDate())
                .returnDate(loanDTO.getReturnDate())
                .returned(loanDTO.isReturned())
                .build();

        return loanRepository.save(loan);
    }

    // ✔ Mevcut ödünç kaydını güncelle
    public Optional<Loan> updateLoan(Long id, LoanDTO loanDTO) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        if (optionalLoan.isEmpty()) return Optional.empty();

        Loan loan = optionalLoan.get();
        loan.setLoanDate(loanDTO.getLoanDate());
        loan.setReturnDate(loanDTO.getReturnDate());
        loan.setReturned(loanDTO.isReturned());

        // Kullanıcı ve kitap kontrolü
        User user = userRepository.findById(loanDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı (ID: " + loanDTO.getUserId() + ")"));
        Book book = bookRepository.findById(loanDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı (ID: " + loanDTO.getBookId() + ")"));

        loan.setUser(user);
        loan.setBook(book);

        return Optional.of(loanRepository.save(loan));
    }

    // ✔ Ödünç kaydını sil
    public boolean deleteLoan(Long id) {
        if (loanRepository.existsById(id)) {
            loanRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // ✔ DTO Dönüşümü
    private LoanDTO convertToDTO(Loan loan) {
        return new LoanDTO(
                loan.getUser().getId(),
                loan.getBook().getId(),
                loan.getLoanDate(),
                loan.getReturnDate(),
                loan.isReturned()
        );
    }
}
