package me.codaline.controller;

import me.codaline.service.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

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

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping(value = "/sccss")
    public ModelAndView defaul() {
//        String date = new Date(System.currentTimeMillis()).toString();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = null;
//        if (!(auth instanceof AnonymousAuthenticationToken)) {
//            userDetail = (UserDetails) auth.getPrincipal();
//            service.setAction(userDetail.getUsername(), "login in ", null, date);
//            userService.upActivity(userDetail.getUsername());
//            if(service.getPosts(userDetail.getUsername()).size()<1)
//            {
//                service.createPost("Your  post ","Edit this post or add new","","\\resources\\images\\kitchen_adventurer_cheesecake_brownie.jpg ",userDetail.getUsername());
//
//            }
//        }
        return new ModelAndView("redirect:/adminFeedBack");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return model;

    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }

        return error;
    }

    @RequestMapping("/index.html")
    String indexHtml() {
        return "index";
    }

    @RequestMapping("/index")
    String indexH() {
        return "index";
    }

    @RequestMapping("/about.html")
    String about() {
        return "about";
    }

    @RequestMapping("/gallery.html")
    String gallery(ModelMap modelMap) {
        JSONObject mainObject = new JSONObject();

        try {
            mainObject.put("images", imageService.getImages(imagesAndGalleriesService.getIdImages()));
            mainObject.put("galleries", galleryService.getGalleries());
            mainObject.put("galleryAndImageIds", imagesAndGalleriesService.getImagesAndGalleries());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        modelMap.addAttribute("galleries", mainObject);
        return "gallery";
    }

    @RequestMapping("/blog.html")
    String blogPage(ModelMap modelMap) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("images", imageService.getImages(postService.getIdImages()));
            jsonObject.put("posts", postService.getPosts());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        modelMap.addAttribute("posts", jsonObject);
        return "blog";
    }

    @RequestMapping("/contact.html")
    String adminPage() {
        return "contact";
    }

    @RequestMapping("/registration")
    String registration() {
        return "registration";
    }

//






}

