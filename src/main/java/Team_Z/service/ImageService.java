package Team_Z.service;

import Team_Z.dao.ImageDao;

import Team_Z.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;


/**
 * Created by igor on 04.11.16.
 */
@Service
public class ImageService {
    @Autowired
    ImageDao imageDao;

    public void safeImage(File file) {

        Image image = new Image();
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        image.setImage(bFile);

        imageDao.saveImage(image);
    }

    public void deleteImageById(int imageId) {
        Image image = imageDao.getImageById(imageId);
        imageDao.deleteImage(image);
    }

    public List<Image> getImages() {

        return imageDao.getImages();
    }
}
