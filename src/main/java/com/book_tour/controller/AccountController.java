package com.book_tour.controller;

import com.book_tour.model.Account;
import com.book_tour.model.Bill;
import com.book_tour.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    IAccountService iAccountService;
    @PostMapping("/createAccount")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        return new ResponseEntity<>(iAccountService.register(account), HttpStatus.OK);
    }
}

