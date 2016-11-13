package me.codaline.controller;

import me.codaline.model.Gallery;
import me.codaline.model.ImagesAndGalleries;
import me.codaline.service.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by igor on 04.11.16.
 */
@Controller
public class AdminController {
    @Autowired
    ImageService imageService;
    @Autowired
    FeedBackService feedBackService;
    @Autowired
    GalleryService galleryService;
    @Autowired
    PostService postService;
    @Autowired
    ImagesAndGalleriesService imagesAndGalleriesService;

    @RequestMapping(value = "adminUpload", method = RequestMethod.POST)
    String uploadImage(ModelMap modelMap, HttpServletRequest request) {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> files = multipartRequest.getFiles("file");

        files.forEach(item -> {

            try {


                imageService.safeImage((FileInputStream) item.getInputStream(), item.getSize(), item.getOriginalFilename());

            } catch (IOException e) {

                e.printStackTrace();

            }
        });
        modelMap.addAttribute("images", imageService.getImages());
        return "adminPhoto";
    }


    @RequestMapping(value = "/admin")
    String adminPage(ModelMap modelMap) {
        modelMap.addAttribute("images", imageService.getImages());
        modelMap.addAttribute("idImages", imageService.getIdImages());
        return "adminPage";
    }

    @RequestMapping(value = "/adminFeedBack")
    String adminFeedBackPage(ModelMap modelMap) {
        modelMap.addAttribute("feedBacks", feedBackService.getFeedBacks());


        return "adminFeedBack";
    }

    @RequestMapping(value = "/admin/DeleteFeedBack", method = RequestMethod.POST)
    String adminDeleteFeedBack(ModelMap modelMap, int idFeedBack) {
        modelMap.addAttribute("feedBacks", feedBackService.getFeedBacks());

        feedBackService.deleteFeedBack(idFeedBack);

        return "adminFeedBack";
    }

    @RequestMapping(value = "/admin/DeleteAllFeedBacks", method = RequestMethod.POST)
    String adminDeleteAllFeedBacks(ModelMap modelMap) {
        modelMap.addAttribute("feedBacks", feedBackService.getFeedBacks());


        feedBackService.deleteAllFeedBacks();
        return "adminFeedBack";

    }


    @RequestMapping(value = "/adminAddPost", method = RequestMethod.POST)
    String addPost(ModelMap modelMap, String title, String context, int idImage) {

        postService.createPost(title, context, idImage);
        modelMap.addAttribute("images", imageService.getImages());
        modelMap.addAttribute("idImages", imageService.getIdImages());
        modelMap.addAttribute("posts", postService.getPosts());

        return "adminAddNews";
    }


    @RequestMapping(value = "/adminAddPost", method = RequestMethod.GET)
    String addPostView(ModelMap modelMap) {


        modelMap.addAttribute("images", imageService.getImages());
        modelMap.addAttribute("idImages", imageService.getIdImages());
        modelMap.addAttribute("posts", postService.getPosts());

        return "adminAddNews";
    }


    @RequestMapping(value = "/adminGetPosts", method = RequestMethod.GET)
    String getPosts(ModelMap modelMap) {

        modelMap.addAttribute("images", imageService.getImages(postService.getIdImages()));
        modelMap.addAttribute("idImages", imageService.getIdImages());
        modelMap.addAttribute("posts", postService.getPosts());


        return "adminNews";
    }

    @RequestMapping(value = "/adminDeletePost", method = RequestMethod.POST)
    String deletePosts(ModelMap modelMap, int idPost) {

        postService.deletePost(idPost);
        modelMap.addAttribute("images", imageService.getImages());
        modelMap.addAttribute("idImages", imageService.getIdImages());
        modelMap.addAttribute("posts", postService.getPosts());

        return "adminNews";
    }

    @RequestMapping(value = "/adminPhoto", method = RequestMethod.GET)
    String adminPhoto(ModelMap modelMap, HttpServletRequest request) {


        modelMap.addAttribute("images", imageService.getImages());
        modelMap.addAttribute("idImages", imageService.getIdImages());


        return "adminPhoto";
    }

    @RequestMapping(value = "/adminDeletePhoto", method = RequestMethod.POST)
    String adminDeletePhoto(ModelMap modelMap, int idPhoto) {


        imageService.deleteImageById(idPhoto);
        imagesAndGalleriesService.deleteImage(idPhoto);
        modelMap.addAttribute("images", imageService.getImages());
        modelMap.addAttribute("idImages", imageService.getIdImages());


        return "adminPhoto";
    }

    @RequestMapping(value = "/adminDeletePhotos", method = RequestMethod.POST)
    String adminDeletePhotos(ModelMap modelMap, String idPhotos) {


        try {
            JSONArray jsonArray = new JSONArray(idPhotos);
            imageService.deleteImageById(jsonArray);
            imagesAndGalleriesService.deleteImages(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        modelMap.addAttribute("images", imageService.getImages());
        modelMap.addAttribute("idImages", imageService.getIdImages());


        return "adminPhoto";
    }

    @RequestMapping(value = "/adminGallery", method = RequestMethod.GET)
    String getGallery(ModelMap modelMap) {

        modelMap.addAttribute("galleries", galleryService.getGalleries());
        modelMap.addAttribute("images", imageService.getImages());
        modelMap.addAttribute("idImages", imageService.getIdImages());
        modelMap.addAttribute("imagesAndGalleries", imagesAndGalleriesService.getImagesAndGalleries());
//        modelMap.addAttribute("idGalleriesAndImages", galleryService.getIdImagesToGalleries());
        return "adminGallery";
    }

    @RequestMapping(value = "/adminCreateGallery", method = RequestMethod.POST)
    String addGallery(ModelMap modelMap, String title, String context, String idPhotos) {

        Gallery gallery = galleryService.createGallery(title, context);
        imagesAndGalleriesService.addImages(idPhotos, gallery.getId());
        modelMap.addAttribute("galleries", galleryService.getGalleries());
        modelMap.addAttribute("images", imageService.getImages());
        modelMap.addAttribute("idImages", imageService.getIdImages());
        modelMap.addAttribute("imagesAndGalleries", imagesAndGalleriesService.getImagesAndGalleries());
//        modelMap.addAttribute("idGalleriesAndImages", galleryService.getIdImagesToGalleries());

        return "adminGallery";
    }

    @RequestMapping(value = "/DeleteGallery", method = RequestMethod.POST)
    String deleteGallery(ModelMap modelMap, int idGallery) {

        galleryService.deleteGalleryById(idGallery);
        imagesAndGalleriesService.deleteGallery(idGallery);
        modelMap.addAttribute("galleries", galleryService.getGalleries());
        modelMap.addAttribute("images", imageService.getImages());
        modelMap.addAttribute("idImages", imageService.getIdImages());

//        modelMap.addAttribute("idGalleriesAndImages", galleryService.getIdImagesToGalleries());

        return "adminGallery";
    }


}
