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
import java.util.Optional;

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
    public Optional<Account> login(String username, String password) {
        return iAccountRepository.getAccountByUsernameAndPassword(username, password);
    }

    @Override

    public String editAccByAdmin(Account account, long id) {
        Account accountAdmin = iAccountRepository.findById(id).get();
        if (account.getRole().getName().equals("ROLE_ADMIN")) {
            return "Vào mục khác để sửa nhé ";
        }
        if (accountAdmin.getRole().getName().equals("ROLE_ADMIN")) {
            iAccountRepository.save(account);
            return "Done";
        } else {
            return "405 Đây là quyền sửa của Admin";
        }
    }

    @Override
    public String deleteAccByAdmin(Account account, long id) {
        Account accountEdit = iAccountRepository.findById(id).get();
        if (accountEdit.getRole().equals("ROEL_ADMIN")) {
            iAccountRepository.save(account);
            return "Done";
        } else {
            return "405 Đây là quyền sửa của Admin";
        }
    }

    @Override
    public String editAccBySelf(Account account) {
        if (!account.getIsActive()) {
            return "Account bị khóa quyền";
        }
        Account accdb = iAccountRepository.findById(account.getId()).get();
        accdb.setEmail(account.getEmail());
        accdb.setAddress(account.getAddress());
        accdb.setFullName(account.getFullName());
        accdb.setAvatar(account.getAvatar());
        iAccountRepository.save(accdb);
        return "Done";
    }

    @Override
    public Optional<Account> findAccByUserName(String name) {
        return iAccountRepository.findByUsername(name);
    }

    @Override
    public String setNewPass(String nPassword, Account account, String oPassword) {
        if (account.getPassword().equals(oPassword)) {
            account.setPassword(nPassword);
            iAccountRepository.save(account);
            return "Done";
        }
        return "Mật Khẩu Cũ Ko Đúng";
    }

    @Override
    public String upRole(long id) {
        Account account = iAccountRepository.findById(id).get();
        if (account.getBalance() < 1000000) {
            return "Tài khoản ko đủ số dư";
        } else if (!account.getIsActive()) {
            return "Tài khoản bị khóa";
        }
        account.setBalance(account.getBalance()-1000000);
        account.setRole(iRoleRepository.getReferenceById(2L));
        iAccountRepository.save(account);
        return "Done";
    }


    @Override
    public List<Account> getAll() {
        return iAccountRepository.findAll();
    }

    @Override
    public Account getById(long id) {
        return iAccountRepository.findById(id).get();
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
        iAccountRepository.deleteById(id);
    }


    @Override
    public String register(Account account) {
        if (iAccountRepository.findAccountByEmail(account.getEmail()).isPresent()) {
            return "Email";
        } else if (iAccountRepository.findByUsername(account.getUsername()).isPresent()) {
            return "Username";
        }
        account.setBalance(0L);
        account.setRole(iRoleRepository.getReferenceById(3L));
        account.setIsActive(true);
        account.setIsGoogle(true);
        account.setStatus(iStatusRepository.getReferenceById(2L));
        create(account);
        return "Done";
    }


}
