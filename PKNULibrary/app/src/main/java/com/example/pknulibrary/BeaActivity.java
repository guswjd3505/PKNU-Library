package com.example.pknulibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BeaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bea);

        //버튼
        Button button = findViewById(R.id.button);

//        //버튼실행
//        button.setOnClickListener(new OnClickListener()) {
//            @Override
//            public void onClick (View view){
//                Intent intent = new Intent(BeaActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }
    }
}
