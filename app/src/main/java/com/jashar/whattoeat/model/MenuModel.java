package com.jashar.whattoeat.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class MenuModel implements Parcelable {

    int mRestaurantId;
    String mRestaurantName;
    String mMenuName;
    double mPrice;
    String mIngredient;

    protected MenuModel(Parcel in) {
        mRestaurantId = in.readInt();
        mRestaurantName = in.readString();
        mMenuName = in.readString();
        mPrice = in.readDouble();
        mIngredient = in.readString();
    }

    public static final Creator<MenuModel> CREATOR = new Creator<MenuModel>() {
        @Override
        public MenuModel createFromParcel(Parcel in) {
            return new MenuModel(in);
        }

        @Override
        public MenuModel[] newArray(int size) {
            return new MenuModel[size];
        }
    };

    public int getmRestaurantId() {
        return mRestaurantId;
    }

    public void setmRestaurantId(int mRestaurantId) {
        this.mRestaurantId = mRestaurantId;
    }

    public String getmRestaurantName() {
        return mRestaurantName;
    }

    public void setmRestaurantName(String mRestaurantName) {
        this.mRestaurantName = mRestaurantName;
    }

    public String getmMenuName() {
        return mMenuName;
    }

    public void setmMenuName(String mMenuName) {
        this.mMenuName = mMenuName;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public String getmIngredient() {
        return mIngredient;
    }

    public void setmIngredient(String mIngredient) {
        this.mIngredient = mIngredient;
    }

    public MenuModel() {
    }

    public MenuModel(int mRestaurantId, String mRestaurantName, String mMenuName, double mPrice, String mIngredient) {
        this.mRestaurantId = mRestaurantId;
        this.mRestaurantName = mRestaurantName;
        this.mMenuName = mMenuName;
        this.mPrice = mPrice;
        this.mIngredient = mIngredient;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mRestaurantId);
        dest.writeString(mRestaurantName);
        dest.writeString(mMenuName);
        dest.writeDouble(mPrice);
        dest.writeString(mIngredient);
    }
}

//public class MenuModel {
//    List<IngredientsModel> listOfIngredients;
//    String name;
//    double price;
//
//    public List<IngredientsModel> getListOfIngredients() {
//        return listOfIngredients;
//    }
//
//    public void setListOfIngredients(List<IngredientsModel> listOfIngredients) {
//        this.listOfIngredients = listOfIngredients;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//
//
//    public MenuModel(List<IngredientsModel> listOfIngredients, String name, double price) {
//        this.listOfIngredients = listOfIngredients;
//        this.name = name;
//        this.price = price;
//    }
//}
