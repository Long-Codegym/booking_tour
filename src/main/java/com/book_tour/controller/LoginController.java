package com.book_tour.controller;

import com.book_tour.model.Account;
import com.book_tour.model.dto.AccountDTO;
import com.book_tour.service.IAccountService;
import com.book_tour.service.IRoleService;
import com.book_tour.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;
    @Autowired
    IAccountService iAccountService;
    @Autowired
    IRoleService iRoleService;
    @PostMapping
    public ResponseEntity<?> getLogin(@RequestBody Account account) {
        Optional<Account> optionalAccount = iAccountService.login(account.getUsername(), account.getPassword());
        if (!optionalAccount.isPresent()) {
            return new ResponseEntity<>("tài khoản hoặc mật khẩu sai", HttpStatus.BAD_REQUEST);
        } else {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtService.createToken(authentication);
            return new ResponseEntity<>(new AccountDTO(
                    optionalAccount.get().getId(),
                    optionalAccount.get().getUsername(),
                    optionalAccount.get().getFullName(),
                    optionalAccount.get().getAvatar(),
                    optionalAccount.get().getEmail(),
                    optionalAccount.get().getAddress(),
                    optionalAccount.get().getBalance(),
                    token,
                    optionalAccount.get().getRole(),
                    optionalAccount.get().getStatus(),
                    optionalAccount.get().getIsActive()
                    ), HttpStatus.OK);
        }
    }
}
