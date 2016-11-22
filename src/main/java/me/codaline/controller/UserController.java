package me.codaline.controller;

import me.codaline.model.User;
import me.codaline.service.FeedBackService;
import me.codaline.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    FeedBackService feedBackService;



    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    ModelAndView saveUser(ModelMap modelMap, String firstName, String userName, String email, String pass
    ) {
        userService.createUser(userName, pass, email, firstName);


        return new ModelAndView("redirect:/welldone");
    }

    @RequestMapping(value = "/addFeedBack", method = RequestMethod.POST)
    String addFeedBack(ModelMap modelMap, String text, String email, String name) {

        feedBackService.createFeedBack(name, email, text);


        modelMap.addAttribute("feedBacks", feedBackService.getFeedBacks());
        return "contact";
    }



}
