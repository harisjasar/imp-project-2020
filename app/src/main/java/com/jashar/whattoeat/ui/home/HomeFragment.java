package com.jashar.whattoeat.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jashar.whattoeat.ApiService;
import com.jashar.whattoeat.MatchFoundActivity;
import com.jashar.whattoeat.R;
import com.jashar.whattoeat.model.MenuModel;
import com.jashar.whattoeat.model.RestaurantModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private EditText textViewCravingOne;
    private Button buttonCrave;
    private RequestQueue requestQueue;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        textViewCravingOne = root.findViewById(R.id.textViewCravingOne);
        buttonCrave = root.findViewById(R.id.buttonCrave);

        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());


        buttonCrave.setOnClickListener(v -> {

            ArrayList<MenuModel> menusList = (ArrayList<MenuModel>) ApiService.getAllMenus(requestQueue, textViewCravingOne.getText().toString());

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(menusList.isEmpty()){
                        Toast.makeText(getContext(), "No meals found for desired craving! Try craving something else!", Toast.LENGTH_LONG).show();
                    }else{
                        System.out.println(textViewCravingOne.getText().toString());
                        Intent activity2Intent = new Intent(getContext(), MatchFoundActivity.class);

                        activity2Intent.putParcelableArrayListExtra("SomeValue", menusList);
                        startActivity(activity2Intent);
                    }
                }
            }, 300);
        });


        return root;
    }
}