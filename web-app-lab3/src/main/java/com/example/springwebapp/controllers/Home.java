package com.example.springwebapp.controllers;
import com.example.springwebapp.models.Item;
import com.example.springwebapp.models.Product;
import com.example.springwebapp.services.CityService;
import com.example.springwebapp.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Home {

    private final ProductService productService;

    private final CityService cityService;

    public Home(ProductService productService, CityService cityService) {
        this.productService = productService;
        this.cityService = cityService;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/home-with-session")
    public String homeWithSession(Model model, HttpSession session) {
        String sid = session.getId();
        model.addAttribute("sid", sid);
        model.addAttribute("products", productService.getAll());
        model.addAttribute("cities", cityService.getAll());
        return "index";
    }

    @GetMapping("/cart")
    public String cartList(HttpSession session, Model model) {
        List<Item> cartList = (List<Item>) session.getAttribute("cart");
        for (int i = 0; i < cartList.size(); i++) {
            long id = cartList.get(i).getProduct().getId();
            Product product = productService.find(id);
            cartList.get(i).setProduct(product);
        }
        model.addAttribute("cart", cartList);
        return "cart";
    }

//    @GetMapping("/cart")
//    public String cartList(@SessionAttribute("cart") List<Item> cartList, Model model) {
//        System.out.println("ВОТ ТУТ " + cartList.size());
////        System.out.println(cartList);
//        System.out.println("ВОТ ТУТ" + cartList.get(1).getProduct().getDescription());
//        model.addAttribute("cart", cartList);
//        return "cart";
//    }

}
