package vttpminiproject.miniproject1.service;

import vttpminiproject.miniproject1.model.RecipeModel;

public interface reciperepo {
    //public int save(final Mastermind ctc);
    public void saveRecipe(String username, RecipeModel model);
        

    
}