package com.launchacademy.reviews.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
<<<<<<< HEAD
  @GetMapping(value = {"/trails", "/trails/{id}", "/trails/{id}/edit"})
=======
  @GetMapping(value = {"/trails", "/trails/{id}", "/trails/new"})
>>>>>>> 05973341e7e8c10dc32b75d99d19323925c1fea9
  public String forward() {
    return "forward:/";
  }
}