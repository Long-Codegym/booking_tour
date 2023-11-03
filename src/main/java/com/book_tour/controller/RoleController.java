package com.book_tour.controller;

import com.book_tour.model.Account;
import com.book_tour.model.Role;
import com.book_tour.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    IRoleService iRoleService;
    @GetMapping("/allRole")
    public ResponseEntity<List<Role>> allRole() {
        return new ResponseEntity<>(iRoleService.getAll(), HttpStatus.OK);
    }



}
