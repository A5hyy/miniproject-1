package vttpminiproject.miniproject1.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import vttpminiproject.miniproject1.model.RecipeModel;

@Controller
public class RecipeController {

    @GetMapping("/home")
    public String getHome(Model model, @RequestParam("username") String name){
        model.addAttribute("username", name);
        

        return "home";
    }

    @PostMapping("/result")
    public String getResult(Model model, @RequestParam("search") String name){
        RestTemplate template = new RestTemplate();
        String url = "https://api.edamam.com/api/recipes/v2?q=" + name + "&app_key=f3495b22e93d5be6f76d8a3b60ef233d&type=public&app_id=5d214e8b";

        ResponseEntity<RecipeModel> responseEntity = template.getForEntity(url, RecipeModel.class);
        ArrayList<HashMap> recipemodel = new ArrayList<HashMap>();
        recipemodel = responseEntity.getBody().getHits();
        HashMap test = (HashMap) recipemodel.get(0).get("recipe");
        System.out.println(test.size());
        System.out.println(test.get("label"));

        for (int i = 0; i < recipemodel.size(); i++) {
            HashMap test1 = (HashMap) recipemodel.get(i).get("recipe");
            System.out.println(test1.get("label"));
        }
        model.addAttribute("label", test.get("label"));
        model.addAttribute("calories", test.get("calories"));
        model.addAttribute("image", test.get("image"));
        model.addAttribute("allrecipe", recipemodel);
        return "result";
    
    }

}
