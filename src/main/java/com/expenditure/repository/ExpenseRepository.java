package com.expenditure.repository;

import com.expenditure.domain.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense,Long> {
}
