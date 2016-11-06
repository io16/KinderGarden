package me.codaline.controller;

import me.codaline.service.FeedBackService;
import me.codaline.service.GalleryService;
import me.codaline.service.ImageService;
import me.codaline.service.PostService;
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
        modelMap.addAttribute("images", imageService.getImages(request));
        return "adminPhoto";
    }

    @RequestMapping(value = "safe")
    String safe(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAttribute("images", imageService.getImages(request));

        return "safe";
    }

    @RequestMapping(value = "/admin")
    String adminPage(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAttribute("images", imageService.getImages(request));
        modelMap.addAttribute("idImages", imageService.getIdImages());
        return "adminPage";
    }

    @RequestMapping(value = "/adminFeedBack")
    String adminFeedBackPage(ModelMap modelMap) {
        modelMap.addAttribute("feedBacks", feedBackService.getFeedBacks());
        modelMap.addAttribute("feedBacksSize", feedBackService.getFeedBacks().size());

        return "adminFeedBack";
    }

    @RequestMapping(value = "/admin/DeleteFeedBack", method = RequestMethod.POST)
    String adminDeleteFeedBack(ModelMap modelMap, int idFeedBack) {
        modelMap.addAttribute("feedBacks", feedBackService.getFeedBacks());
        modelMap.addAttribute("feedBacksSize", feedBackService.getFeedBacks().size());
        feedBackService.deleteFeedBack(idFeedBack);

        return "adminFeedBack";
    }

    @RequestMapping(value = "/admin/DeleteAllFeedBacks", method = RequestMethod.POST)
    String adminDeleteAllFeedBacks(ModelMap modelMap) {
        modelMap.addAttribute("feedBacks", feedBackService.getFeedBacks());
        modelMap.addAttribute("feedBacksSize", feedBackService.getFeedBacks().size());


        feedBackService.deleteAllFeedBacks();
        return "adminFeedBack";

    }


    @RequestMapping(value = "/adminAddPost", method = RequestMethod.POST)
    String addPost(ModelMap modelMap, HttpServletRequest request, String title, String context, int idImage) {

        postService.createPost(title, context, idImage);
        modelMap.addAttribute("images", imageService.getImages(request));
        modelMap.addAttribute("idImages", imageService.getIdImages());
        modelMap.addAttribute("posts", postService.getPosts());

        return "adminNews";
    }


    @RequestMapping(value = "/adminAddPost", method = RequestMethod.GET)
    String addPostView(ModelMap modelMap, HttpServletRequest request) {


        modelMap.addAttribute("images", imageService.getImages(request));
        modelMap.addAttribute("idImages", imageService.getIdImages());
        modelMap.addAttribute("posts", postService.getPosts());

        return "adminAddNews";
    }


    @RequestMapping(value = "/adminGetPosts", method = RequestMethod.GET)
    String getPosts(ModelMap modelMap, HttpServletRequest request) {

        modelMap.addAttribute("images", imageService.getImages(request));
        modelMap.addAttribute("idImages", imageService.getIdImages());
        modelMap.addAttribute("posts", postService.getPosts());

        return "adminNews";
    }

    @RequestMapping(value = "/adminDeletePost", method = RequestMethod.POST)
    String deletePosts(ModelMap modelMap, HttpServletRequest request, int idPost) {

        postService.deletePost(idPost);
        modelMap.addAttribute("images", imageService.getImages(request));
        modelMap.addAttribute("idImages", imageService.getIdImages());
        modelMap.addAttribute("posts", postService.getPosts());

        return "adminNews";
    }

    @RequestMapping(value = "/adminPhoto", method = RequestMethod.GET)
    String adminPhoto(ModelMap modelMap, HttpServletRequest request) {


        modelMap.addAttribute("images", imageService.getImages(request));
        modelMap.addAttribute("idImages", imageService.getIdImages());


        return "adminPhoto";
    }

    @RequestMapping(value = "/adminDeletePhoto", method = RequestMethod.POST)
    String adminDeletePhoto(ModelMap modelMap, HttpServletRequest request, int idPhoto) {


        imageService.deleteImageById(idPhoto);
        modelMap.addAttribute("images", imageService.getImages(request));
        modelMap.addAttribute("idImages", imageService.getIdImages());


        return "adminPhoto";
    }

    @RequestMapping(value = "/adminGallery", method = RequestMethod.GET)
    String getGallery(ModelMap modelMap, HttpServletRequest request) {

        modelMap.addAttribute("galleries", galleryService.getGalleries());
        modelMap.addAttribute("galleriesSize", galleryService.getGalleries().size());
        modelMap.addAttribute("images", imageService.getImages(request));
        modelMap.addAttribute("idImages", imageService.getIdImages());
        modelMap.addAttribute("idGalleriesAndImages", galleryService.getIdImagesToGalleries());
        return "adminGallery";
    }


}
