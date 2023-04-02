package com.xfactor.openlibrary.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xfactor.openlibrary.domain.Loan;
import com.xfactor.openlibrary.repository.LoanRepository;

@RestController
@RequestMapping("loans")
public class LoanController {
    // ArrayList <Loan> lloan = new ArrayList<>();

    private LoanRepository loanRepository;
    
    public LoanController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @PostMapping("/saveLoan")
    public Loan saveLoan(@RequestBody Loan loan) {
        loanRepository.save(loan);
        return loan;
    }

    @GetMapping("/getAllLoans")
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @GetMapping("/getLoanById/{id}")
    public Loan findById (@PathVariable Long id) {
        Optional<Loan> optionalOfLoan = loanRepository.findById(id);
        if (optionalOfLoan.isPresent()){
            return optionalOfLoan.get();
        }
        return null;
    }

    @GetMapping("/getLoanByBookId/{bookId}")
    public List<Loan> findByBookId (@PathVariable Long bookId) {
        List<Loan> listOfLoanByBookId = loanRepository.findByBookId(bookId);
        return listOfLoanByBookId;
    }

    @GetMapping("/getLoanByStudentId/{studentId}")
    public List<Loan> findByStudentId (@PathVariable Long studentId) {
        List<Loan> listOfLoanByStudentId = loanRepository.findByStudentId(studentId);
        return listOfLoanByStudentId;
    }

    @GetMapping("/getLoanByCheckoutDate/{checkoutDate}")
    public List<Loan> findByCheckoutDate (@PathVariable String checkoutDate) {
        List<Loan> listOfLoanByCheckoutDate = loanRepository.findByCheckoutDate(checkoutDate);
        return listOfLoanByCheckoutDate;
    }

    @GetMapping("/getLoanByDueDate/{dueDate}")
    public List<Loan> findByDueDate (@PathVariable String dueDate) {
        List<Loan> listOfLoanByDueDate = loanRepository.findByDueDate(dueDate);
        return listOfLoanByDueDate;
    }

    @GetMapping("/getLoanByReturnDate/{returnDate}")
    public List<Loan> findByReturnDate (@PathVariable String returnDate) {
        List<Loan> listOfLoanByReturnDate = loanRepository.findByReturnDate(returnDate);
        return listOfLoanByReturnDate;
    }

    @PutMapping("/updateLoan")
    public Loan updateLoan (@RequestBody Loan loan) {
        if (loan.getId() != null){
            Loan updatedLoan = loanRepository.save(loan);
            return updatedLoan;
        }
        return null;
    }

    @DeleteMapping("/deleteLoan/{id}")
    public void deleteLoan (@PathVariable Long id) {
        loanRepository.deleteById(id);
    }

}
