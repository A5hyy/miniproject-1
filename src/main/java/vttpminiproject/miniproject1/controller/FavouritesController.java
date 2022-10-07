package vttpminiproject.miniproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FavouritesController {
    @GetMapping("/favourites")
    public String getFavourites(){
        return "favourites";
    }
    
}
