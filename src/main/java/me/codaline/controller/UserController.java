package me.codaline.controller;

import me.codaline.model.User;
import me.codaline.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    String createUser() {
        return "createUser";
    }

//    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
//         ModelAndView saveUser(
//                    String firstName,
//                    String lastName,
//                    String email
//            ) {
//        ModelAndView modelAndView = new ModelAndView("success");
//        User user = service.createUser(firstName, lastName, email);
//        modelAndView.addObject("user", user);
//        return modelAndView;
//    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    @ResponseBody
    String saveUser(
            ModelMap modelMap,
            @RequestParam(value = "fName", required = true) String firstName,
            @RequestParam(value = "lName", required = false) String lastName,
            @RequestParam(value = "e", required = true) String email
    ) throws JSONException {
        User user = service.createUser(firstName, lastName, email);
        modelMap.addAttribute("user", user);
        JSONObject jsonObject = new JSONObject();
        if (user == null) {
            jsonObject.put("status", false);
        } else {
            jsonObject.put("status", true);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    String getUsers(ModelMap modelMap) {
        List<User> users = service.getUsers();
        modelMap.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String getUser(ModelMap modelMap, String email) {
        User user = service.getUser(email);
        modelMap.addAttribute("user", user);
        return "user";
    }


}
