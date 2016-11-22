package me.codaline.service;

import me.codaline.dao.GalleryDao;
import me.codaline.model.Gallery;
import me.codaline.dao.GalleryDao;
import me.codaline.model.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by igor on 05.11.16.
 */
@Service
public class GalleryService {
    @Autowired
    GalleryDao galleryDao;

    public Gallery createGallery(String title, String context) {

        Gallery gallery = new Gallery();
        gallery.setContext(context);
        gallery.setTitle(title);
        galleryDao.createGallery(gallery);
        return gallery;


    }

    public void deleteGalleryById(int idGallery) {

        Gallery gallery = galleryDao.getFeedbackById(idGallery);
        galleryDao.deleteGallery(gallery);
    }

    public List<Gallery> getGalleries() {

        return galleryDao.getGalleries();

    }


}
