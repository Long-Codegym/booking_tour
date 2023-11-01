package com.book_tour.controller;

import com.book_tour.model.Image;
import com.book_tour.model.Tour;
import com.book_tour.model.TourSchedule;
import com.book_tour.model.dto.CreateDTO;
import com.book_tour.model.dto.FilterTour;
import com.book_tour.model.dto.TourDTO;
import com.book_tour.service.IImageService;
import com.book_tour.service.ITourScheduleService;
import com.book_tour.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/tours")
public class TourController {
    @Autowired
    ITourService iTourService;
    @Autowired
    IImageService iImageService;
    @Autowired
    ITourScheduleService iTourScheduleService;

    @GetMapping
    public ResponseEntity<List<Tour>> getTourFeaturedThisMonth() {
        return new ResponseEntity<>(iTourService.findPopularToursInCurrentMonth(), HttpStatus.OK);
    }

    @GetMapping("/getTourByZone/{nameZone}")
    public ResponseEntity<List<TourDTO>> getAllTourByZone(@PathVariable String nameZone) {
        List<TourDTO> tourDTOList = iTourService.getAllTourByZone(nameZone);
        return new ResponseEntity<>(tourDTOList, HttpStatus.OK);
    }

    @GetMapping("/getTourById/{idTour}")
    public ResponseEntity<TourDTO> getTourById(@PathVariable long idTour) {
        TourDTO tourDTO1 = iTourService.getTourById(idTour);
        List<Image> imageList = iImageService.getImageByTour(idTour);
        TourDTO tourDTO = new TourDTO(tourDTO1.getTour(),imageList,tourDTO1.getRate(),tourDTO1.getCountRate());
        return new ResponseEntity<>(tourDTO, HttpStatus.OK);
    }
    @PostMapping("/getAllTourByFilter")
    public ResponseEntity<List<TourDTO>> getAllTourByFilter(@RequestBody FilterTour filterTour){
        return new ResponseEntity<>(iTourService.getAllTourByFilter(filterTour),HttpStatus.OK);
    }


    @GetMapping("/allTour")
    public ResponseEntity<List<Tour>> getAllTour() {
        return new ResponseEntity<>(iTourService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id_Tour}")
    public ResponseEntity<Tour> getTourByID(@PathVariable long id_Tour) {
        return new ResponseEntity<>(iTourService.getById(id_Tour), HttpStatus.OK);
    }
    @PostMapping("/createTour")
    public ResponseEntity<Tour> createTour(@RequestBody CreateDTO createDTO) {
        Tour tour = createDTO.getTour();
        List<TourSchedule> tourSchedules = createDTO.getTourSchedules();
        List<TourSchedule> savedTourSchedules = new ArrayList<>();
        for (TourSchedule schedule : tourSchedules) {
            TourSchedule savedSchedule = iTourScheduleService.create(schedule);
            savedTourSchedules.add(savedSchedule);
        }
        Tour tour1 = new Tour();
        tour1.setAccount(tour.getAccount());
        tour1.setCity(tour.getCity());
        tour1.setName(tour.getName());
        tour1.setPrice(tour.getPrice());
        tour1.setTourTime(tour.getTourTime());
        tour1.setDiscount(tour.getDiscount());
        tour1.setDescribes(tour.getDescribes());
        tour1.setSupplies(tour.getSupplies());
        tour1.setImg(tour.getImg());
        tour1.setConvenientWard(tour.getConvenientWard());
        tour1.setIsActive(tour.getIsActive());
        tour1.setTourSchedule(savedTourSchedules);

        Tour tour2 = iTourService.create(tour1);
        return new ResponseEntity<>(tour2, HttpStatus.OK);
    }


}
