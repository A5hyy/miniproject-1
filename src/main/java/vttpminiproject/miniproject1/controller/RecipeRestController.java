package vttpminiproject.miniproject1.controller;



import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.PathContainer.Options;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import vttpminiproject.miniproject1.model.RecipeModel;
import vttpminiproject.miniproject1.service.redisservice;


@RestController

public class RecipeRestController {


    @Autowired
    redisservice service;

    @GetMapping(path="/REST/{username}", produces="application/json")
    public ResponseEntity<String> getRecipe(@PathVariable String username, @ModelAttribute RecipeModel model) {
        try {
            ArrayList<String> keys = service.getKeys();
            for (String user : keys) {
                if(username.toLowerCase().equals((user).toLowerCase())){
                    username = user;
                }
            }

            model = service.getRecipe(username);
            if(model == null) {
                throw new Exception();
            }
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(model.toString());
        } catch (Exception e) {
            JsonObjectBuilder builder = Json.createObjectBuilder();
            builder.add("Error: Username not found, OR Redis connection interrupted.", "Cannot find user: " + username);
            JsonObject body = builder.build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body.toString());
        }
        
    }
}