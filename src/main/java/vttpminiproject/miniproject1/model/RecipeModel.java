package vttpminiproject.miniproject1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RecipeModel {

    private ArrayList<HashMap> hits;
    
    public ArrayList<HashMap> getHits() {
        return hits;
    }
    public void setHits(ArrayList<HashMap> hits) {
        this.hits = hits;
    }
    
    @Override
    public String toString() {
        return "RecipeModel [hits=" + hits + ", label=" + label + ", image=" + image + ", source=" + source + ", url="
                + url + ", shareAs=" + shareAs + ", yield=" + yield + ", dietLabels=" + Arrays.toString(dietLabels)
                + ", healthLabels=" + Arrays.toString(healthLabels) + ", cautions=" + Arrays.toString(cautions)
                + ", ingredientLines=" + Arrays.toString(ingredientLines) + ", calories=" + calories + ", totalWeight="
                + totalWeight + ", totalTime=" + totalTime + ", cuisineType=" + Arrays.toString(cuisineType)
                + ", mealType=" + Arrays.toString(mealType) + ", dishType=" + Arrays.toString(dishType) + "]";
    }

    private String label;
    private String image;
    private String source;
    private String url;
    private String shareAs;
    private double yield;
    private String[] dietLabels;
    private String[] healthLabels;
    private String[] cautions;
    private String[] ingredientLines;
    private double calories;
    private double totalWeight;
    private double totalTime;
    private String[] cuisineType;
    private String[] mealType;
    private String[] dishType;
   /*  private Map<String, Total> totalNutrients;
    private Map<String, Total> totalDaily; */
    
}
