package me.codaline.service;

import me.codaline.dao.ImageDao;

import me.codaline.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
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


        formatFile = formatFile.substring(formatFile.lastIndexOf("."));
        image.setImage(bFile);
        image.setFormatFile(formatFile);

        imageDao.saveImage(image);
    }

    public void deleteImageById(int imageId) {

        Image image = imageDao.getImageById(imageId);
        imageDao.deleteImage(image);
    }

    public String[] getImages(HttpServletRequest request) {

        List<Image> list = imageDao.getImages();

        java.awt.List imageList = new java.awt.List();

        ServletContext context = request.getSession().getServletContext();
        list.forEach(item -> {

            try {
                //FileOutputStream fos = new FileOutputStream("images\\output.jpg");  //windows

                String saveDirectory = context.getRealPath("") + File.separator + "resources/images/new/";
                FileOutputStream fos = new FileOutputStream(saveDirectory + item.getId() + item.getFormatFile());
                fos.write(item.getImage());
                fos.close();

                imageList.add("resources/images/new/" + item.getId() + item.getFormatFile());
            } catch (Exception e) {

                e.printStackTrace();
            }
        });


        return imageList.getItems();
    }


    public List getIdImages() {

        ArrayList<Integer> idList = new ArrayList<>();

        imageDao.getImages().forEach(item -> {
            idList.add(item.getId());
        });
        return idList;

    }
}
