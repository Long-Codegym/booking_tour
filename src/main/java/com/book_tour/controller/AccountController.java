package com.book_tour.controller;

import com.book_tour.model.Account;
import com.book_tour.model.Bill;
import com.book_tour.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ResponseEntity<String> editAccount(@RequestParam long id, @RequestBody Account account) {
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

    @GetMapping("/setNewPass")
    public ResponseEntity<String> setNewPass(@RequestParam String NewPassword, @RequestParam String OldPassword) {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Account account = iAccountService.findAccByUserName(userDetails.getUsername()).orElse(null);
            if (account != null) {
                return new ResponseEntity<>(iAccountService.setNewPass(NewPassword, account,OldPassword), HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }
}

