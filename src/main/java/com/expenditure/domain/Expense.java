package com.expenditure.domain;

import com.expenditure.domain.enuns.Category;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expense")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Expense extends AbstractEntity {

    @NotEmpty
    private String description;
    @NotNull
    private LocalDate date;
    @NotNull
    private BigDecimal value;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;
}
