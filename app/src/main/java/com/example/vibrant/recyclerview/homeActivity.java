package com.example.vibrant.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class homeActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView = findViewById(R.id.textView2);

        ArrayList<String> list = (ArrayList<String>) getIntent().getSerializableExtra("data");

        String s = "";

        for (int i = 0; i < list.size(); i++) {

            s += list.get(i) + "\n";
        }

        textView.setText(s);


    }
}
