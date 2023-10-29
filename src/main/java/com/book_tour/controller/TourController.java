package com.book_tour.controller;

import com.book_tour.model.Image;
import com.book_tour.model.Tour;
import com.book_tour.model.dto.TourDTO;
import com.book_tour.service.IImageService;
import com.book_tour.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/tours")
public class TourController {
    @Autowired
    ITourService iTourService;
    @Autowired
    IImageService iImageService;

    @GetMapping
    public ResponseEntity<List<Tour>> getTourFeaturedThisMonth() {
        return new ResponseEntity<>(iTourService.findPopularToursInCurrentMonth(), HttpStatus.OK);
    }

    @GetMapping("/getTourByZone/{nameZone}")
    public ResponseEntity<List<Tour>> getAllTourByZone(@PathVariable String nameZone) {
        return new ResponseEntity<>(iTourService.getAllTourByZone(nameZone), HttpStatus.OK);
    }

    @GetMapping("/getTourById/{idTour}")
    public ResponseEntity<TourDTO> getTourById(@PathVariable long idTour) {
        Tour tour = iTourService.getTourById(idTour);
        List<Image> imageList = iImageService.getImageByTour(idTour);
        TourDTO tourDTO = new TourDTO(tour,imageList);
        return new ResponseEntity<>(tourDTO, HttpStatus.OK);
    }


    @GetMapping("/allTour")
    public ResponseEntity<List<Tour>> getAllTour() {
        return new ResponseEntity<>(iTourService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id_Tour}")
    public ResponseEntity<Tour> getTourByID(@PathVariable long id_Tour) {
        return new ResponseEntity<>(iTourService.getById(id_Tour), HttpStatus.OK);
    }
}
