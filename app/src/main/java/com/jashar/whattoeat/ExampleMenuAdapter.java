package com.jashar.whattoeat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ExampleMenuAdapter extends RecyclerView.Adapter<ExampleMenuAdapter.ExampleViewHolder> {

    private ArrayList<ExampleMenuItem> mExampleList;
    public ExampleMenuAdapter(ArrayList<ExampleMenuItem> exampleList){
        mExampleList = exampleList;
    }


    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_menu_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);

        return  evh;

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleMenuItem currentItem = mExampleList.get(position);

        holder.mTextViewMealName.setText(currentItem.getMenuName());
        holder.mTextViewPrice.setText(currentItem.getPrice() + "");
        holder.mTextViewRestaurantName.setText(currentItem.getRestaurantName());


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public static  class ExampleViewHolder extends  RecyclerView.ViewHolder{

        public TextView mTextViewMealName;
        public TextView mTextViewPrice;
        public TextView mTextViewRestaurantName;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewMealName = itemView.findViewById(R.id.textViewMealName);
            mTextViewPrice = itemView.findViewById(R.id.textViewPrice);
            mTextViewRestaurantName = itemView.findViewById(R.id.textViewRestaurantName);


        }
    }
}
