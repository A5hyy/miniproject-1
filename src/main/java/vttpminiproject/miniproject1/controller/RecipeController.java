package vttpminiproject.miniproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttpminiproject.miniproject1.model.Recipe;

/* @Controller
public class ProjectController {
    @GetMapping("/")
    public String getLogin(@ModelAttribute Recipe rec){

        return "login";
    }

    @PostMapping("/showResults")
    public String getResults(@ModelAttribute Recipe rec, Model model){
        model.addAttribute("q", rec.getQ());
        model.addAttribute("diet", rec.getDiet());
        model.addAttribute("mealType", rec.getMealType());
        return "result";
    }


} */

@Controller
@RequestMapping(path="/")
public class RecipeController {
    public String getLogin(){

        return "login";
        
    }
} 