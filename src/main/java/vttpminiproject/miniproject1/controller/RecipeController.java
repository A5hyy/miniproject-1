package vttpminiproject.miniproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecipeController {

    @GetMapping("/home")
    public String getHome(){

        return "home";
    }

    @PostMapping("/result")
    public String getResult(){

        return "result";
    }

}
