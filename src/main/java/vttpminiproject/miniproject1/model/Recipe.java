package vttpminiproject.miniproject1.model;

public class Recipe {

    private String q;
    private String diet; //array
    private String mealType; //array

    public Recipe(String q, String diet, String mealType) {
        this.q = q;
        this.diet = diet;
        this.mealType = mealType;
    }
    
    
    public String getQ() {
        return q;
    }
    public void setQ(String q) {
        this.q = q;
    }


    public String getDiet() {
        return diet;
    }
    public void setDiet(String diet) {
        this.diet = diet;
    }


    public String getMealType() {
        return mealType;
    }
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

}
