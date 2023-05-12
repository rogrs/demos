package br.com.rogrs.demos.controllers;

import br.com.rogrs.demos.dto.BreadcrumbItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home(Model model) {
        List<BreadcrumbItem> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbItem("Home", "/"));
        model.addAttribute("breadcrumb", breadcrumb);
        return "index";
    }




}
