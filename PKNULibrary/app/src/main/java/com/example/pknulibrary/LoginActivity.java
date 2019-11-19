package com.example.pknulibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity {

    public static final int REQUEST_CODE_MENU = 101;

    EditText etid, etpw;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MENU) {
            Toast.makeText(getApplicationContext(),
                    "onActivityResult 메서드 호출됨. 요청코드 : " + requestCode + ", 결과코드 " + resultCode, Toast.LENGTH_LONG).show();

            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(getApplicationContext(), "응답으로 전달된 name : " + name, Toast.LENGTH_LONG).show();

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Button
        Button button = (Button) findViewById(R.id.button); // sign in button

        // 버튼 실행
        button.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {

                etid = findViewById(R.id.editText3);
                etpw = findViewById(R.id.editText4);

                String inputid = etid.getText().toString();
                String inputpw = etpw.getText().toString();

                if (inputid.equals("201712059") && (inputpw.equals("201712059"))) {
                    Toast.makeText(getApplicationContext(), "로그인성공", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                    finish();
                    return true;

                }
                else if(inputid.equals("201712021") && (inputpw.equals("201712021"))){
                    Toast.makeText(getApplicationContext(), "로그인성공", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                    finish();
                    return true;
                }
                else if(inputid.equals("201410007") && (inputpw.equals("201410007"))){
                    Toast.makeText(getApplicationContext(), "로그인성공", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                    finish();
                    return true;
                }
                else if(inputid.equals("201512132") && (inputpw.equals("201512132"))){
                    Toast.makeText(getApplicationContext(), "로그인성공", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                    finish();
                    return true;
                }else {
                    Toast.makeText(getApplicationContext(), "로그인실패", Toast.LENGTH_SHORT).show();
                    return false;
                }

            }



        });

    }
}