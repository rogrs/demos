package br.com.rogrs.demos.controllers;


import br.com.rogrs.demos.domain.Product;
import br.com.rogrs.demos.dto.BreadcrumbItem;
import br.com.rogrs.demos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    public static final String ENDPOINT = "/products";

    @Autowired
    private ProductRepository mainRepository;


    @GetMapping(ENDPOINT)
    public String listProducts(Model model) {
        List<Product> products = mainRepository.findAll();


        List<BreadcrumbItem> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbItem("Home", "/"));
        breadcrumb.add(new BreadcrumbItem("Products", ENDPOINT));
        model.addAttribute("pageTitle", "Products");

        model.addAttribute("breadcrumbs", breadcrumb);
        model.addAttribute("products", products);
        return ENDPOINT+"/list";
    }

    @GetMapping(ENDPOINT+"/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return ENDPOINT+"/form";
    }

    @PostMapping(ENDPOINT+"/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        mainRepository.save(product);
        return "redirect:"+ENDPOINT;
    }

    @GetMapping(ENDPOINT+"/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Product product = mainRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));
        model.addAttribute("product", product);
        return ENDPOINT+"/form";
    }

    @GetMapping(ENDPOINT+"/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        mainRepository.deleteById(id);
        return "redirect:"+ENDPOINT;
    }

}
