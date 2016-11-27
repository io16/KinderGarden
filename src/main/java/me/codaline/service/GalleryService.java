package me.codaline.service;

import me.codaline.dao.GalleryDao;
import me.codaline.model.Gallery;
import me.codaline.dao.GalleryDao;
import me.codaline.model.Gallery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        gallery.setDate(String.valueOf(LocalDate.now()));
        galleryDao.createGallery(gallery);
        return gallery;


    }

    public void deleteGalleryById(int idGallery) {

        Gallery gallery = galleryDao.getFeedbackById(idGallery);
        galleryDao.deleteGallery(gallery);
    }

    public JSONObject getGalleries() {

        JSONObject mainObject = new JSONObject();
        JSONObject galleryData = new JSONObject();

        JSONArray jsonArrayIds = new JSONArray();
        JSONArray jsonArrayData;
        List<Gallery> galleries = galleryDao.getGalleries();


        for (Gallery gallery : galleries) {
            jsonArrayData = new JSONArray();

            jsonArrayIds.put(gallery.getId());



            jsonArrayData.put(gallery.getTitle());
            jsonArrayData.put(gallery.getContext());
            jsonArrayData.put(gallery.getDate());


            try {
                galleryData.put(String.valueOf(gallery.getId()), jsonArrayData);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try {

            mainObject.put("galleryData", galleryData);
            mainObject.put("idGalleries", jsonArrayIds);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mainObject;

    }


}
