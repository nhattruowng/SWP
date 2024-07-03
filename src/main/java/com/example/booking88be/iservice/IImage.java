package com.example.booking88be.iservice;

import com.example.booking88be.entity.Image;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface IImage {

    /**
     * add a new image
     *
     * @param image Image
     * @return Image
     */
    Image addImage(Image image);

    /**
     * get the image by id
     *
     * @param id long
     * @return Image
     */
    Image getImageById(Long id);

    /**
     * get all images
     *
     * @return List<Image>
     */
    List<Image> getAllImage();

    /**
     * update image
     *
     * @param id    long
     * @param image Image
     * @return Image updated
     */
    Image updateImage(Long id, Image image);

    /**
     * delete image
     *
     * @param id long
     */
    void deleteImage(Long id);
}
