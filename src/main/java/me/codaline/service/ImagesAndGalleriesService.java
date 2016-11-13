package me.codaline.service;

import me.codaline.dao.ImagesAndGalleriesDao;
import me.codaline.model.ImagesAndGalleries;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by igor on 13.11.16.
 */
@Service
public class ImagesAndGalleriesService {
    @Autowired
    ImagesAndGalleriesDao imagesAndGalleriesDao;

    public JSONObject getImagesAndGalleries() {

        JSONArray idImageArray = new JSONArray();
        JSONObject idGalleryImages = new JSONObject();
        JSONArray idGalleries = new JSONArray();
        JSONObject mainObj = new JSONObject();

        List<ImagesAndGalleries> list = imagesAndGalleriesDao.getImagesAndGalleries();

        list.forEach(action -> {

            try {

                if (idGalleries.length() == 0) {


                    idGalleries.put(action.getIdGallery());
                } else if ((Integer) idGalleries.get(idGalleries.length() - 1) != action.getIdGallery()) {
                    idGalleries.put(action.getIdGallery());
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


        });
        for (int i = 0; i < idGalleries.length(); i++) {


            idImageArray = new JSONArray();
            for (ImagesAndGalleries item : list) {
                try {
                    if (item.getIdGallery() == (Integer) idGalleries.get(i))
                        idImageArray.put(item.getIdImage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            try {
                idGalleryImages.put(String.valueOf(idGalleries.get(i)), idImageArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        JSONArray jsonArrayData = new JSONArray();

        jsonArrayData.put(idImageArray);

        try {
            mainObj.put("idGalleries", idGalleries);
            mainObj.put("Data", idGalleryImages);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return mainObj;
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
