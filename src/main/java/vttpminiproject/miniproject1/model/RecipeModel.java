package vttpminiproject.miniproject1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeModel {

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
    public List<RecipeModel> recipelist;

    private ArrayList<HashMap> hits;
    public RecipeModel(String label, String image, double calories){
    this.label=label;
    this.image=image;
    this.calories=calories;
    }
    public RecipeModel(){
        
    }
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

    
   /*  private Map<String, Total> totalNutrients;
    private Map<String, Total> totalDaily; */

    public List<RecipeModel> getRecipelist() {
        return recipelist;
    }
    public void setRecipelist(List<RecipeModel> recipelist) {
        this.recipelist = recipelist;
    }
    // public ArrayList<RecipeModel> getRecipelist() {
    //     return recipelist;
    // }
    // public void setRecipelist(ArrayList<RecipeModel> recipelist) {
    //     this.recipelist = recipelist;
    // }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public double getCalories() {
        return calories;
    }
    public void setCalories(double calories) {
        this.calories = calories;
    }
    public Object toJson() {
        return null;
    }
    public static Object create(String result) {
        return null;
    }
    
}