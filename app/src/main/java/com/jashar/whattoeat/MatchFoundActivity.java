package com.jashar.whattoeat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jashar.whattoeat.model.MenuModel;

import java.util.ArrayList;

public class MatchFoundActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_found);

        ArrayList<ExampleMenuItem> exampleList = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ArrayList<MenuModel> value = extras.getParcelableArrayList("SomeValue");
            for(MenuModel a : value){
                ExampleMenuItem b = new ExampleMenuItem(a.getmMenuName(), a.getmPrice(), a.getmRestaurantName());
                exampleList.add(b);
            }

        }

/*
        exampleList.add(new ExampleMenuItem("Hamburger", 32.5, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Not Hamburger", 52, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Hot Hamburger", 34, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Hamburger", 32.5, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Not Hamburger", 52, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Hot Hamburger", 34, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Hamburger", 32.5, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Not Hamburger", 52, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Hot Hamburger", 34, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Hamburger", 32.5, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Not Hamburger", 52, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Hot Hamburger", 34, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Hamburger", 32.5, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Not Hamburger", 52, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Hot Hamburger", 34, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Hamburger", 32.5, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Not Hamburger", 52, "Kod Bate"));
        exampleList.add(new ExampleMenuItem("Hot Hamburger", 34, "Kod Bate"));
*/
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleMenuAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
}
