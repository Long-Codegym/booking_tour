package com.book_tour.controller;

import com.book_tour.model.Image;
import com.book_tour.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    IImageService iImageService;
    @PostMapping("/addImg")
    public ResponseEntity<String> addImg(@RequestBody Image image){
        iImageService.create(image);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.OK);
    }
}
