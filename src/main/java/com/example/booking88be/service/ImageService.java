package com.example.booking88be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.booking88be.entity.*;
import com.example.booking88be.iservice.*;
import com.example.booking88be.repository.*;

import java.util.List;
import java.util.Optional;

@Component
public class ImageService implements IImage {

    @Autowired
    private IImageRepository iImageRepository;


    @Override
    public Image addImage(Image image) {
        return image!=null ? iImageRepository.save(image) : null;
    }

    @Override
    public Image getImageById(Long id) {
        return iImageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Image> getAllImage() {
        return iImageRepository.findAll();
    }

    @Override
    @Transactional
    public Image updateImage(Long id, Image image) {
        return iImageRepository.findById(id).map(
                i ->{
                    i.setImage(image.getImage());
                    i.setLocation(image.getLocation());
                    return iImageRepository.save(i);
                }
        ).orElse(null);
    }

    @Override
    @Transactional
    public void deleteImage(Long id) {
            iImageRepository.deleteById(id);
    }
}
