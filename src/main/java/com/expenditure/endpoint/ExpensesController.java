package com.expenditure.endpoint;

import com.expenditure.domain.Expense;
import com.expenditure.domain.exception.CustonTypeError;
import com.expenditure.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        if (expenseRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(new CustonTypeError("NOT FOUND"), HttpStatus.NOT_FOUND);
        }
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

    @DeleteMapping("/expenses/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        expenseRepository.delete(expense);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
