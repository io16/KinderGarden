package me.codaline.controller;

import me.codaline.service.FeedBackService;
import me.codaline.service.ImageService;
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

    @RequestMapping(value = "upload", method = RequestMethod.POST)
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
        return "safe";
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

    @RequestMapping(value = "/admin/DeleteFeedBack")
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


}
