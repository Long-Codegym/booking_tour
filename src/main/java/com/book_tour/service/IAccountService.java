package com.book_tour.service;


import com.book_tour.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IAccountService extends UserDetailsService, ICrudService<Account> {
    public String register(Account account);

    Optional<Account> login(String username, String password);

    public String editAccByAdmin(Account account, long id);

    public String deleteAccByAdmin(Account account, long id);

    public String editAccBySelf(Account account);

    public Optional<Account> findAccByUserName(String name);
    public String setNewPass(String nPassword,Account account,String oPassword);

    public String upRole(long id);

}
