package com.jashar.whattoeat.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.jashar.whattoeat.R;

public class HomeFragment extends Fragment {

    private EditText textViewCravingOne;
    private EditText textViewCravingTwo;
    private EditText textViewCravingThree;
    private Button buttonCrave;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        textViewCravingOne = root.findViewById(R.id.textViewCravingOne);
        textViewCravingTwo = root.findViewById(R.id.textViewCravingTwo);
        textViewCravingThree = root.findViewById(R.id.textViewCravingThree);
        buttonCrave = root.findViewById(R.id.buttonCrave);

        buttonCrave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(textViewCravingOne.getText().toString());
            }
        });


        return root;
    }

}