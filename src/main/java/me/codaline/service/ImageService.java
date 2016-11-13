package me.codaline.service;

import com.fasterxml.jackson.core.JsonGenerator;
import me.codaline.dao.ImageDao;

import me.codaline.model.Image;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


/**
 * Created by igor on 04.11.16.
 */
@Service
public class ImageService {
    @Autowired
    ImageDao imageDao;

    public void safeImage(FileInputStream fileInputStream, long size, String formatFile) {

        Image image = new Image();
        byte[] bFile = new byte[(int) size];

        try {

            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        formatFile = formatFile.substring(formatFile.lastIndexOf(".") + 1);
        image.setImage(bFile);
        image.setFormatFile(formatFile);

        imageDao.saveImage(image);
    }

    public void deleteImageById(int imageId) {

        Image image = imageDao.getImageById(imageId);
        imageDao.deleteImage(image);
    }

    public void deleteImageById(JSONArray imageIds) {

        Image image = null;
        try {


            for (int i = 0; i < imageIds.length(); i++) {
                image = imageDao.getImageById((Integer) imageIds.get(i));
                imageDao.deleteImage(image);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public JSONObject getImages() {

        JSONObject formatFile = new JSONObject();
        JSONObject byteCode = new JSONObject();
        JSONObject mainObj = new JSONObject();
        List<Image> list = imageDao.getImages();
        try {
            list.forEach(image -> {
                try {
                    formatFile.put(String.valueOf(image.getId()), image.getFormatFile());
                    byteCode.put(String.valueOf(image.getId()), Base64.getEncoder().encodeToString(image.getImage()));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            });


            JSONArray jsonArrayIds = new JSONArray();
            JSONArray jsonArrayData = new JSONArray();
            list.forEach(image -> {

                jsonArrayIds.put(image.getId());


            });
            jsonArrayData.put(formatFile);
            jsonArrayData.put(byteCode);

            mainObj.put("id", jsonArrayIds);
            mainObj.put("formats", jsonArrayData);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return mainObj;
    }

    public JSONObject getImages(List<Integer> idList) {


        JSONObject formatFile = new JSONObject();
        JSONObject byteCode = new JSONObject();
        JSONObject mainObj = new JSONObject();
        List<Image> list = imageDao.getImages();
        try {
            list.forEach(image -> {
                if (idList.indexOf(image.getId()) != -1) {
                    try {
                        formatFile.put(String.valueOf(image.getId()), image.getFormatFile());
                        byteCode.put(String.valueOf(image.getId()), Base64.getEncoder().encodeToString(image.getImage()));


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });


            JSONArray jsonArrayIds = new JSONArray();
            JSONArray jsonArrayData = new JSONArray();
            list.forEach(image -> {
                if (idList.indexOf(image.getId()) != -1) {

                    jsonArrayIds.put(image.getId());


                }
            });
            jsonArrayData.put(formatFile);
            jsonArrayData.put(byteCode);

            mainObj.put("id", jsonArrayIds);
            mainObj.put("formats", jsonArrayData);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return mainObj;
    }


    public List getIdImages() {

        ArrayList<Integer> idList = new ArrayList<>();

        imageDao.getImages().forEach(item -> {
            idList.add(item.getId());
        });
        return idList;

    }
}
