package com.example.pknulibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyPageActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        textView=findViewById(R.id.date);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        textView.setText(name);
    }

}