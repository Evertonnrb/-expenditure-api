package com.expenditure.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserExpenditure extends AbstractEntity {
    @NotEmpty
    @Column(unique = true)
    private String userName;
    @NotEmpty
    @JsonIgnore
    private String password;
    @NotEmpty
    private String name;
    @NotEmpty
    private boolean admin;

}
