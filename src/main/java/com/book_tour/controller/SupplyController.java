package com.book_tour.controller;

import com.book_tour.model.Supply;
import com.book_tour.service.ISupplyService;
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
@RequestMapping("/supplies")
public class SupplyController {
    @Autowired
    ISupplyService iSupplyService;
    @GetMapping()
    public ResponseEntity<List<Supply>> getAllSupplies(){
        return new ResponseEntity<>(iSupplyService.getAll(), HttpStatus.OK);
    }
}
