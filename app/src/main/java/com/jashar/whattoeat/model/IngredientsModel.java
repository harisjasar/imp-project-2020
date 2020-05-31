package com.jashar.whattoeat.model;

import java.util.List;

public class IngredientsModel {
    List<String> ingredients;

    public IngredientsModel(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(String ingredient){
        this.ingredients.add(ingredient);
    }
}
