package com.expenditure.repository;

import com.expenditure.domain.UserExpenditure;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRespository extends PagingAndSortingRepository<UserExpenditure,Long> {

    UserExpenditure findByUserName(String userName);
}
