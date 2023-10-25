package com.book_tour.service;


import com.book_tour.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAccountService extends UserDetailsService ,ICrudService<Account>{
    public String register(Account account);
}
