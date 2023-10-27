package com.book_tour.controller;

import com.book_tour.model.Bill;
import com.book_tour.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    IBillService iBillService;

    @GetMapping("/createBill")
    public ResponseEntity<String> createBill(@RequestBody Bill bill) {
        return new ResponseEntity<>(iBillService.createBill2(bill), HttpStatus.OK);
    }

}
