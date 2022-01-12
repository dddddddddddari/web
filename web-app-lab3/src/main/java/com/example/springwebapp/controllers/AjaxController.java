package com.example.springwebapp.controllers;


import com.example.springwebapp.models.Item;
import com.example.springwebapp.services.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@RestController
public class AjaxController {

    private static int count;
    private final ProductService productService;

    public AjaxController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addToCart")
    public int addToCart(HttpSession session, @RequestParam("id") int id) {
        if (session.getAttribute("cart") == null)
        {
            List<Item> cartList = new ArrayList<>();
            cartList.add(new Item(productService.find(id), 1));
            session.setAttribute("cart", cartList);
        }
        else {
            List<Item> cartList = (List<Item>) session.getAttribute("cart");
            int index = isExists(id, cartList);
            if (index == -1) {
                cartList.add(new Item(productService.find(id), 1));
            }
            else {
                int count1 = cartList.get(index).getCount() + 1; //добавляем в сессию товар повторно
                cartList.get(index).setCount(count1);
            }
            session.setAttribute("cart", cartList);
        }
        return count++;
    }

    private int isExists(int id, List<Item> cartList) {
        for (int i = 0; i < cartList.size(); i++) {
            if(cartList.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
