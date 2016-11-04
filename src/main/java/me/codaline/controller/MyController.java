package me.codaline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/login")
    String login() {
        return "login";
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
    String gallery() {return "gallery";}

    @RequestMapping("/blog.html")
    String blogPage() {
        return "blog";
    }

    @RequestMapping("/contact.html")
    String adminPage() {
        return "contact";
    }
    @RequestMapping("/admin")
    String adminPagee() {
        return "adminPage";
    }

}

