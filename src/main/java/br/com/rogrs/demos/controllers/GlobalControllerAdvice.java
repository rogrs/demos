package br.com.rogrs.demos.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("menu")
    public String getMenu() {
        return "menu";
    }

    @ModelAttribute("breadcrumb")
    public String getBreadcrumb() {
        return "breadcrumb";
    }


}