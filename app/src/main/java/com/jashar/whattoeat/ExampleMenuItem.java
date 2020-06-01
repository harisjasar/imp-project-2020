package com.jashar.whattoeat;

public class ExampleMenuItem {
    private String menuName;
    private double price;
    private String restaurantName;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public ExampleMenuItem() {
    }



    public ExampleMenuItem(String menuName, double price, String restaurantName) {
        this.menuName = menuName;
        this.price = price;
        this.restaurantName = restaurantName;
    }


}
