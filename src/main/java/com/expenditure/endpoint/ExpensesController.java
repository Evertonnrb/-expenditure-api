package com.expenditure.endpoint;

import com.expenditure.domain.Expense;
import com.expenditure.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<Expense> getAll() {
        return StreamSupport.stream(expenseRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/expenses/{id}")
    public Expense findById(@PathVariable("id") Long id) {
        return expenseRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/expenses")
    public Expense save(@Valid @RequestBody Expense expense){
        return expenseRepository.save(expense);
    }

    @PutMapping("/expenses/{id}")
    public Expense update(@Valid @RequestBody Expense expense,@PathVariable("id") Long id){
        findById(id);
        expense.setId(id);
        return expenseRepository.save(expense);
    }

    @DeleteMapping("/expenses/{id}")
    public void delete(@PathVariable Long id){
        Expense expense = expenseRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        expenseRepository.delete(expense);
    }
}
