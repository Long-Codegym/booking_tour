package com.book_tour.service;

import com.book_tour.model.Image;

import java.util.List;

public interface IImageService extends ICrudService<Image>{
    List<Image> getImageByTour(long idTour);
}
