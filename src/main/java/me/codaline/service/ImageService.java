package me.codaline.service;

import me.codaline.model.Image;
import me.codaline.dao.ImageDao;

import me.codaline.model.Image;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;


/**
 * Created by igor on 04.11.16.
 */
@Service
public class ImageService {
    @Autowired
    ImageDao imageDao;
    private LocalDateTime today;

    public void safeImage(byte[] bytes, HttpServletRequest request) {

        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        Image image = new Image();
        LocalDate date =  LocalDate.now();

        image.setDate(String.valueOf(date));

        try {

            //"/home/igor/IdeaProjects/KinderGarten/src/main/webapp/resources/images/"
            ServletContext context = request.getSession().getServletContext();
            int idImage = today.hashCode();
            if (context.getRealPath("").indexOf("/") >= 0) {
                String saveDirectory = context.getRealPath("") + "/resources/images/new/";


                String path = saveDirectory + idImage + ".png";
                FileUtils.writeByteArrayToFile(new File(path), bytes);
                path = "resources/images/new/" + idImage + ".png";
                image.setPath(path);
            } else {
                String saveDirectory = context.getRealPath("") + "\\resources\\images\\new\\";
                String path = saveDirectory + idImage + ".png";
                FileUtils.writeByteArrayToFile(new File(path), bytes);
                path = "resources\\images\\new\\" + idImage + ".png";
                image.setPath(path);
            }
            imageDao.saveImage(image);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int hashCode() {
        int result = 17;


        result = 37 * result + (today == null ? 0 : today.hashCode());

        return result;
    }


    public void deleteImageById(int imageId) {

        Image image = imageDao.getImageById(imageId);
        File file = new File(image.getPath());
        file.delete();

        imageDao.deleteImage(image);
    }

    public void deleteImageById(JSONArray imageIds) {

        File file;
        Image image;
        try {


            for (int i = 0; i < imageIds.length(); i++) {
                image = imageDao.getImageById((Integer) imageIds.get(i));
                file = new File(image.getPath());
                file.delete();
                imageDao.deleteImage(image);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public JSONObject getImages(List<Integer> idList) {
        JSONObject mainObj = new JSONObject();
        JSONObject imagesDate = new JSONObject();
        JSONObject imagesPath = new JSONObject();
        JSONArray jsonArrayIds = new JSONArray();
        List<Image> list = imageDao.getImages();
        try {
            list.forEach(image -> {
                try {
                    if (idList != null) {

                        if (idList.indexOf(image.getId()) != -1) {

                            imagesDate.put(String.valueOf(image.getId()), image.getDate());
                            imagesPath.put(String.valueOf(image.getId()), image.getPath());
                            jsonArrayIds.put(image.getId());


                        }
                    } else {

                        imagesDate.put(String.valueOf(image.getId()), image.getDate());
                        imagesPath.put(String.valueOf(image.getId()), image.getPath());

                        jsonArrayIds.put(image.getId());

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            });


            JSONArray jsonArrayData = new JSONArray();

            jsonArrayData.put(imagesDate);
            jsonArrayData.put(imagesPath);

            mainObj.put("id", jsonArrayIds);
            mainObj.put("images", jsonArrayData);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return mainObj;
    }


    public List<Integer> getIdImages() {

        ArrayList<Integer> idList = new ArrayList<>();

        imageDao.getImages().forEach(item -> {
            idList.add(item.getId());
        });
        return idList;

    }
}
