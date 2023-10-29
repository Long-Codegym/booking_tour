package com.book_tour.service;


import com.book_tour.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IAccountService extends UserDetailsService ,ICrudService<Account>{
    public String register(Account account);
    Optional<Account> login(String username, String password);

}
