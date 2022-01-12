package com.example.springwebapp.controllers;

import com.example.springwebapp.models.Category;
import com.example.springwebapp.services.CategoryService;
import com.example.springwebapp.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class SortController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public SortController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @GetMapping("/sortPrice/{order}")
    public String sort(Model model, @PathVariable ("order") String order) {
        if ("asc".equals(order)) {
            model.addAttribute("products", productService.getBySortLowToHigh());
        }
        else {
            model.addAttribute("products", productService.getBySortHighToLow());
        }
        return "index :: #productsContainer";
    }

    @GetMapping("/filter")
    public String filter(Model model, @RequestParam("categ") String categ) {
        Set<Category> categories = new HashSet<>();
        String[] resultArray = categ.split(",");
        for (String string : resultArray) {
            categories.add(categoryService.getByName(string));
            System.out.println(string);
        }
        model.addAttribute("products", productService.getByCategory(categories));
        return "index :: #productsContainer";
    }
}
