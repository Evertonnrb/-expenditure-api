package com.expenditure.endpoint.service;

import com.expenditure.domain.UserExpenditure;
import com.expenditure.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserExpenditureDetailService implements UserDetailsService {
    @Autowired
    private UserRespository userRespository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserExpenditure user = Optional.ofNullable(userRespository.findByUserName(username)).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_USER");
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),user.isAdmin() ? authorityListAdmin : authorityListUser);
    }
}
