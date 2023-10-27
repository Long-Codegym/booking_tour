package com.book_tour.service;


import com.book_tour.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IAccountService extends UserDetailsService {
    Optional<Account> login(String username, String password);
}
