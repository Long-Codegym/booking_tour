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

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@Transactional
@RequestMapping("/tours")
public class TourController {
    @Autowired
    ITourService iTourService;
    @Autowired
    IImageService iImageService;
    @Autowired
    ITourScheduleService iTourScheduleService;
    @PersistenceContext
    EntityManager entityManager;
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

    @GetMapping("/detail/{id}")
    public ResponseEntity<Tour> getTourByID(@PathVariable long id) {
        return new ResponseEntity<>(iTourService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/createTour")
    public ResponseEntity<String> createTour(@RequestBody CreateDTO createDTO) {
        Tour tour = iTourService.create(createDTO.getTour());
        List<TourSchedule> tourSchedules=iTourScheduleService.saveAll(createDTO.getTourSchedules());
        for(int i=0;i<tourSchedules.size();i++) {
            entityManager.createNativeQuery("INSERT INTO tour_tour_schedule (tour_id, tour_schedule_id) VALUES (?, ?)")
                    .setParameter(1, tour.getId())
                    .setParameter(2, tourSchedules.get(i).getId())
                    .executeUpdate();
        }
        return new ResponseEntity<>("done", HttpStatus.OK);
    }
    @GetMapping("/listTourById/{id}")
    public ResponseEntity<List<TourDTO>> listTourById(@PathVariable long id){
        return new ResponseEntity<>(iTourService.getAllTourByIdAcc(id),HttpStatus.OK);
    }
}
