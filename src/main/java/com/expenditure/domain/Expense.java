package com.expenditure.domain;

import com.expenditure.domain.enuns.Category;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Expense {
    @Id
    private Long id;
    @NotEmpty
    private String description;
    @NotNull
    private LocalDate date;
    @NotNull
    private BigDecimal value;
    @NotNull
    private Category category;
}
