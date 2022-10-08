package vttpminiproject.miniproject1.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import vttpminiproject.miniproject1.model.RecipeModel;
import vttpminiproject.miniproject1.service.reciperedis;

@Controller
public class RecipeController {

    public String userName;
    public String itemName;

    @Autowired
    reciperedis service;

    @GetMapping("/home")
    public String getHome(Model model, @RequestParam("username") String name){
        model.addAttribute("username", name);
        
        this.userName=name;
        

        return "home";
    }

    @PostMapping("/result")
    public String getResult(Model model, @RequestParam("search") String name){
        this.itemName=name;
        System.out.println(userName);
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
            ArrayList test1 = (ArrayList) recipemodel.get(i)
            System.out.println(test1.get("label"));
        }
        model.addAttribute("label", test.get("label"));
        model.addAttribute("calories", test.get("calories"));
        model.addAttribute("image", test.get("image"));
        model.addAttribute("allrecipe", recipemodel);
        model.addAttribute("username", userName);
        return "result";
    
    }

    @GetMapping("/favourites")
    public String getFavourites(Model model, @RequestParam("save") List<String> list){
        model.addAttribute("username", userName);
        System.out.println(list);

        RestTemplate template = new RestTemplate();
        String url = "https://api.edamam.com/api/recipes/v2?q=" + itemName + "&app_key=f3495b22e93d5be6f76d8a3b60ef233d&type=public&app_id=5d214e8b";

        ResponseEntity<RecipeModel> responseEntity = template.getForEntity(url, RecipeModel.class);
        ArrayList<HashMap> recipemodel = new ArrayList<HashMap>();
        recipemodel = responseEntity.getBody().getHits();
        HashMap test = (HashMap) recipemodel.get(0).get("recipe");
        RecipeModel model1 = new RecipeModel();
        ArrayList<RecipeModel> recipeArray = new ArrayList<RecipeModel>();
        List<RecipeModel> array = new LinkedList<RecipeModel>();

        for (int i = 0; i < list.size(); i++) {
            for (int index = 0; index < recipemodel.size(); index++) {
                HashMap temp = (HashMap) recipemodel.get(index).get("recipe");
                String temp2 = (String) temp.get("label");
                if (list.get(i).trim().equals(temp2.trim())) {
                    HashMap temp3 = (HashMap) recipemodel.get(index).get("recipe");
                    String temp4 = (String) temp3.get("label");
                    model1.setLabel((String)temp3.get("label"));
                    model1.setCalories((Double) temp3.get("calories"));
                    model1.setImage((String) temp3.get("image"));
                    System.out.println(model1.getLabel());
                    array.add(new RecipeModel((String) temp3.get("label"), (String) temp3.get("image"), (double)temp3.get("calories")));
                    for (RecipeModel recipeModel2 : array) {
                        System.out.println(recipeModel2.getLabel());
                    }
                    
                }
            }
        }
        
        // for (int i = 0; i < model1.getRecipelist().size(); i++) {
        //     System.out.println(recipeArray.get(i).getLabel());
        // }
        // service.saveRecipe(userName, model1);
        RecipeModel recipeModel2 = service.getRecipe(userName);
        //System.out.println(model1.recipelist.get(0).getLabel());
        model.addAttribute("recipe", array);
       
        return "favourites";
    }


    @GetMapping("/result")
    public String getResult(Model model){
        model.addAttribute("username", userName);
        return "result";
    }

    @GetMapping("/")
    public String getLogin(){
    
        return "login";
        
    }



}
