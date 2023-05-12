package br.com.rogrs.demos.controllers;


import br.com.rogrs.demos.domain.Order;
import br.com.rogrs.demos.dto.BreadcrumbItem;
import br.com.rogrs.demos.repository.OrderRepository;
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
public class OrderController {

    public static final String ENDPOINT = "/orders";

    @Autowired
    private OrderRepository mainRepository;

    @GetMapping(ENDPOINT)
    public String listAll(Model model) {
        List<Order> orders = mainRepository.findAll();


        List<BreadcrumbItem> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbItem("Home", "/"));
        breadcrumb.add(new BreadcrumbItem("Orders", ENDPOINT));
        model.addAttribute("pageTitle", "Orders");

        model.addAttribute("breadcrumbs", breadcrumb);
        model.addAttribute("orders", orders);
        return ENDPOINT+"/list";
    }

    @GetMapping(ENDPOINT+"/new")
    public String showProductForm(Model model) {
        model.addAttribute("order", new Order());
        return ENDPOINT+"/form";
    }

    @PostMapping(ENDPOINT+"/save")
    public String saveProduct(@ModelAttribute("order") Order order) {
        mainRepository.save(order);
        return "redirect:"+ENDPOINT;
    }

    @GetMapping(ENDPOINT+"/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Order obj = mainRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order Id: " + id));
        model.addAttribute("order", obj);
        return ENDPOINT+"/form";
    }

    @GetMapping(ENDPOINT+"/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        mainRepository.deleteById(id);
        return "redirect:"+ENDPOINT;
    }

}
