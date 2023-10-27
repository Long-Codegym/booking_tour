package com.book_tour.service.impl;

import com.book_tour.model.Account;
import com.book_tour.model.Role;
import com.book_tour.repository.IAccountRepository;
import com.book_tour.repository.IRoleRepository;
import com.book_tour.repository.IStatusRepository;
import com.book_tour.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository iAccountRepository;
    @Autowired
    IRoleRepository iRoleRepository;
    @Autowired
    IStatusRepository iStatusRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepository.findByUsername(username).orElse(null);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getUsername(), account.getPassword(), roles);
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Account getById(long id) {
        return null;
    }

    @Override
    public Account create(Account account) {
        return iAccountRepository.save(account);
    }

    @Override
    public Account edit(Account account) {
        return iAccountRepository.save(account);
    }

    @Override
    public void deleteById(long id) {

    }


    @Override
    public String register(Account account) {
        if (iAccountRepository.findAccountByEmail(account.getEmail()).isPresent()) {
            return "Email";
        } else if (iAccountRepository.findByUsername(account.getUsername()).isPresent()) {
            return "Username";
        }
        account.setRole(iRoleRepository.getReferenceById(3L));
        account.setIsActive(true);
        account.setIsGoogle(true);
        account.setStatus(iStatusRepository.getReferenceById(2L));
        create(account);
        return "Done";
    }

}
