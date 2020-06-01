package com.jashar.whattoeat;

import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.jashar.whattoeat.model.MenuModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ApiService {

    private static String api_service_url = "http://192.168.0.12:8080/api/v1";
    //private static final String api_service_url = "localhost:8080/api/v1";


    public static List<MenuModel> getAllMenus(RequestQueue requestQueue, String ingredient) {

        String url =  String.format("%s/menus/%s", api_service_url, ingredient);
        final List<MenuModel> menuModels = new ArrayList<>();
        JsonArrayRequest request =  new JsonArrayRequest(Request.Method.GET, url,null, response -> {

            try {
                for(int i = 0; i < response.length(); i++){
                    JSONObject a = response.getJSONObject(i);
                    System.out.println(a);
                    MenuModel invoice = new MenuModel(a.getInt("mRestaurantId"), a.getString("mRestaurantName"), a.getString("mMenuName"), a.getDouble("mPrice"), a.getString("mIngredient"));
                    menuModels.add(invoice);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> {
            Log.e("getAllMenus", error.toString());
        });

        request.setRetryPolicy(new DefaultRetryPolicy( 50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(request);

        return menuModels;

    }
}
