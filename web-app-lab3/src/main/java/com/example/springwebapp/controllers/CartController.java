package com.example.springwebapp.controllers;

import com.example.springwebapp.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    private final ProductService productService;
    public CartController(ProductService productService) {
        this.productService = productService;
    }

//    @RequestMapping("/cart")
//    public String homeWithSession(Model model, HttpSession session) {
//        return "index";
//    }

}
