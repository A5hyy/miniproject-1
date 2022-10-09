package vttpminiproject.miniproject1.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttpminiproject.miniproject1.model.RecipeModel;
import vttpminiproject.miniproject1.service.redisservice;


@RestController
@RequestMapping(path = {"/result"} , produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipeRestController {


    @Autowired
    private redisservice searchService;

    @GetMapping(value = "{id}")
    public ResponseEntity<String> getSearch(@PathVariable String id){

        Optional<RecipeModel> opt = searchService.saveRecipe(id, null);
        if(opt.isEmpty()){
            JsonObject error = Json.createObjectBuilder()
                                .add("error", "Cannot find food ID %s".formatted(id)).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.toString());
        }

        SearchRecipe search = opt.get();
        return ResponseEntity.ok(search.toJson().toString());

    }
    
    
}