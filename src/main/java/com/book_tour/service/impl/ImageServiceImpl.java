package com.book_tour.service.impl;

import com.book_tour.model.Image;
import com.book_tour.repository.IImageRepository;
import com.book_tour.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements IImageService {
    @Autowired
    IImageRepository iImageRepository;
    @Override
    public List<Image> getAll() {
        return null;
    }

    @Override
    public Image getById(long id) {
        return null;
    }

    @Override
    public Image create(Image image) {
        return null;
    }

    @Override
    public Image edit(Image image) {
        return null;
    }

    @Override
    public void deleteById(long id) {
    }

    @Override
    public List<Image> getImageByTour(long idTour) {
        List<Image> imageList = iImageRepository.getImageByTour(idTour);
        return imageList;
    }
}
