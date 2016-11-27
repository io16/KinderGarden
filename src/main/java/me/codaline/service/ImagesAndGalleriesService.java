package me.codaline.service;

import me.codaline.dao.ImagesAndGalleriesDao;
import me.codaline.model.ImagesAndGalleries;
import me.codaline.dao.ImagesAndGalleriesDao;
import me.codaline.model.ImagesAndGalleries;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 13.11.16.
 */
@Service
public class ImagesAndGalleriesService {
    @Autowired
    ImagesAndGalleriesDao imagesAndGalleriesDao;

    public JSONObject getImagesAndGalleries() {

        JSONObject mainObject = new JSONObject();
        JSONObject idGalleryAndImages = new JSONObject();

        JSONArray arrayImages = new JSONArray();
        JSONArray arrayGalleries = new JSONArray();

        List<ImagesAndGalleries> iag = imagesAndGalleriesDao.getImagesAndGalleries();


        int idGallery = 0;
        try {
            for (ImagesAndGalleries gallery : iag) {

                if (arrayGalleries.length() == 0) {  //set first id
                    arrayGalleries.put(gallery.getIdGallery());
                    idGallery = gallery.getIdGallery();
                }


                if (idGallery != gallery.getIdGallery()) {

                    idGalleryAndImages.put(String.valueOf(idGallery), arrayImages);
                    idGallery = gallery.getIdGallery();
                    arrayGalleries.put(gallery.getIdGallery());

                    arrayImages = new JSONArray();

                }
                arrayImages.put(gallery.getIdImage());
            }

            idGalleryAndImages.put(String.valueOf(idGallery), arrayImages);


            mainObject.put("galleryIds", arrayGalleries);
            mainObject.put("data", idGalleryAndImages);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mainObject;
    }

    public List<Integer> getIdImages() {
        ArrayList<Integer> imageIds = new ArrayList<>();
        imagesAndGalleriesDao.getImagesAndGalleries().forEach(item -> {
            imageIds.add(item.getIdImage());
        });

        return imageIds;
    }

    public void deleteImages(JSONArray imageIds) {

        try {


            for (int i = 0; i < imageIds.length(); i++) {
                imagesAndGalleriesDao.deleteImage((Integer) imageIds.get(i));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void deleteImage(int idImage) {
        imagesAndGalleriesDao.deleteImage(idImage);
    }

    public void deleteGallery(int idGallery) {

        imagesAndGalleriesDao.deleteGallery(idGallery);
    }

    public void addImages(String idImages, int idGallery) {

        ImagesAndGalleries image = new ImagesAndGalleries();

        try {
            JSONArray jsonArray = new JSONArray(idImages);
            image.setIdGallery(idGallery);
            for (int i = 0; i < jsonArray.length(); i++) {

                image.setIdImage((Integer) jsonArray.get(i));
                imagesAndGalleriesDao.addImage(image);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
