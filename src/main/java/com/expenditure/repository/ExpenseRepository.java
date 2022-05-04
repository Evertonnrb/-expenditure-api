package com.expenditure.repository;

import com.expenditure.domain.Expense;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense,Long> {
    List<Expense> findByDescriptionIgnoreCaseContaining(String description);
}
