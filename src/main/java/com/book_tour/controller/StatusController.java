package com.book_tour.controller;

import com.book_tour.model.Status;
import com.book_tour.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    IStatusService iStatusService;
    @GetMapping("/allStatus")
    public ResponseEntity<List<Status>> allStatus() {
        return new ResponseEntity<>(iStatusService.getAll(), HttpStatus.OK);
    }
}
