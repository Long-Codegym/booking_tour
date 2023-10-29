package com.book_tour.controller;

import com.book_tour.model.dto.ZoneDTO;
import com.book_tour.service.IZoneService;
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
@RequestMapping("/zone")
public class ZoneController {
    @Autowired
    IZoneService iZoneService;
    @GetMapping
    public ResponseEntity<List<ZoneDTO>> findZonesAndTourCount(){
        return new ResponseEntity<>(iZoneService.findZonesAndTourCount(), HttpStatus.OK);
    }
}
