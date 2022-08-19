package br.com.ucs.MusicHarmony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(HttpServletRequest request) {

//        HttpSession session = request.getSession();
//        if (session.getAttribute(session.getId()) == null ||
//                session.getAttribute(session.getId()).equals("")) {
//            return "login";
//        } else{
//            System.out.println("Estou no homeController");
//            return "home";
//        }

        System.out.println("Estou no homeController");
        return "home";
    }
}
