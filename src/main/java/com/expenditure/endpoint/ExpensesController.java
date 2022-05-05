package com.expenditure.endpoint;

import com.expenditure.domain.Expense;
import com.expenditure.domain.exception.ResourceNotFoundException;
import com.expenditure.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ExpensesController {

    @Autowired
    ExpenseRepository expenseRepository;

    @GetMapping("/expenses")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(expenseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/expenses/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        verifyExpenses(id);
        return new ResponseEntity<>(expenseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/expenses")
    public ResponseEntity<?> save(@Valid @RequestBody Expense expense) {
        return new ResponseEntity<>(expenseRepository.save(expense), HttpStatus.OK);
    }

    @PutMapping("/expenses/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Expense expense, @PathVariable("id") Long id) {
        findById(id);
        expense.setId(id);
        return new ResponseEntity<>(expenseRepository.save(expense), HttpStatus.OK);
    }

    @GetMapping("/expenses/find/{description}")
    public ResponseEntity<?> findByDescription(@PathVariable("description") String description) {
        return new ResponseEntity<>(expenseRepository.findByDescriptionIgnoreCaseContaining(description), HttpStatus.OK);
    }

    @DeleteMapping("/expenses/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(userDetails);
        verifyExpenses(id);
        expenseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyExpenses(Long id) {
        if (expenseRepository.findById(id).isEmpty())
            throw new ResourceNotFoundException("No match records found for id : " + id);
    }
}
