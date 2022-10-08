package vttpminiproject.miniproject1.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import vttpminiproject.miniproject1.model.RecipeModel;

@Service
public class reciperedis implements reciperepo {
    private static final Logger logger = LoggerFactory.getLogger(RecipeModel.class);

    @Autowired
    @Qualifier("games")
    RedisTemplate<String, RecipeModel> redisTemplate;

    public void saveRecipe(String username, RecipeModel model){
        redisTemplate.opsForValue().set(username, model);

    }

    public RecipeModel getRecipe(String username){
        RecipeModel recipemodel = redisTemplate.opsForValue().get(username);
        return recipemodel;
    }
    // @Override
    // public int save(final Mastermind ctc) {
    //     logger.info("Save mastermind > " + logger);
    //     redisTemplate.opsForValue().set(ctc.getId(), ctc);
    //     Mastermind result = (Mastermind) redisTemplate.opsForValue().get(ctc.getId());
    //     if (result != null)
    //         return 1;
    //     return 0;
    // }
}