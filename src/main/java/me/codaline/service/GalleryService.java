package me.codaline.service;

import me.codaline.dao.GalleryDao;
import me.codaline.model.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 05.11.16.
 */
@Service
public class GalleryService {
    @Autowired
    GalleryDao galleryDao;

    public void createGallery(String title, String context, String imagesId) {

        Gallery gallery = new Gallery();
        gallery.setContext(context);
        gallery.setTitle(title);
        gallery.setImagesId(imagesId);
        galleryDao.createGallery(gallery);


    }

    public void deleteGalleryById(int idGallery) {

        Gallery gallery = galleryDao.getFeedbackById(idGallery);
        galleryDao.deleteGallery(gallery);
    }

    public List<Gallery> getGalleries() {

        return galleryDao.getGalleries();

    }

    public List<List> getIdImagesToGalleries() {

        List<Gallery> galleries = galleryDao.getGalleries();

        List<List> list = new ArrayList();


        galleries.forEach(item -> {
            String ids = item.getImagesId();
            List<Integer> idImages = new ArrayList();
            while (ids.length() != 0) {
                String newIds = ids.substring(0, ids.indexOf(","));
                idImages.add(Integer.valueOf(newIds));
                ids = ids.substring(ids.indexOf(",") + 1, ids.length());


            }
            list.add(idImages);
        });


        return list;
    }
}
