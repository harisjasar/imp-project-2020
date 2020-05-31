package com.jashar.whattoeat.model;

import java.util.List;

public class MenuModel {
    List<IngredientsModel> listOfIngredients;
    String name;
    double price;

    public List<IngredientsModel> getListOfIngredients() {
        return listOfIngredients;
    }

    public void setListOfIngredients(List<IngredientsModel> listOfIngredients) {
        this.listOfIngredients = listOfIngredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public MenuModel(List<IngredientsModel> listOfIngredients, String name, double price) {
        this.listOfIngredients = listOfIngredients;
        this.name = name;
        this.price = price;
    }
}
