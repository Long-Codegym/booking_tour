package com.book_tour.controller;

import com.book_tour.model.Account;
import com.book_tour.model.Bill;
import com.book_tour.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/editAccount")
    public ResponseEntity<String> editAccount(@RequestBody Account account, @RequestParam long id) {
        if (id <= 0) {
            return new ResponseEntity<>(iAccountService.editAccBySelf(account), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(iAccountService.editAccByAdmin(account, id), HttpStatus.OK);
        }
    }

    @PostMapping("/deleteAccount")
    public ResponseEntity<String> deleteAccount(@RequestBody Account account, @RequestParam long id) {
        return new ResponseEntity<>(iAccountService.deleteAccByAdmin(account, id), HttpStatus.OK);
    }

    @GetMapping("/allAccount")
    public ResponseEntity<List<Account>> allAccount(@RequestParam long id) {
        if (iAccountService.getById(id).getRole().getName().equals("ROLE_ADMIN")) {
            return new ResponseEntity<>(iAccountService.getAll(), HttpStatus.OK);
        } else return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}

