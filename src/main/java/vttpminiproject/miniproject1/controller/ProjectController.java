package vttpminiproject.miniproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectController {
    @GetMapping("/")
    public String getIndex(){

        return "index";
    }

    @PostMapping("/showResults")
    public String getResults(){

        return "result";
    }


}
