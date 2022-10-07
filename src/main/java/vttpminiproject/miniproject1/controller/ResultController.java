package vttpminiproject.miniproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResultController {

    @GetMapping("/result")
    public String getResult(){

        return "result";
    }

}
