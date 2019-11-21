package com.example.pknulibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.format.DateFormat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static android.graphics.BlendMode.COLOR;

public class three extends AppCompatActivity {

    TextView display, text;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13,
            btn14, btn15, btn16, btn17, btn18,btn19,btn20,btn21,btn22,btn23,btn24;

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        display = (TextView) findViewById(R.id.tv1);
        text = (TextView) findViewById(R.id.tv2);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn10 = (Button) findViewById(R.id.btn10);
        btn11= (Button) findViewById(R.id.btn11);
        btn12= (Button) findViewById(R.id.btn12);
        btn13= (Button) findViewById(R.id.btn13);
        btn14 = (Button) findViewById(R.id.btn14);
        btn15 = (Button) findViewById(R.id.btn15);
        btn16= (Button) findViewById(R.id.btn16);
        btn17= (Button) findViewById(R.id.btn17);
        btn18= (Button) findViewById(R.id.btn18);
        btn19= (Button) findViewById(R.id.btn19);
        btn20= (Button) findViewById(R.id.btn20);
        btn21= (Button) findViewById(R.id.btn21);
        btn22 = (Button) findViewById(R.id.btn22);
        btn23= (Button) findViewById(R.id.btn23);
        btn24 = (Button) findViewById(R.id.btn24);

        final String btn2text = btn2.getText().toString();

        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn1.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn1.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });


        btn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn2.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn2.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn3.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn3.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn4.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn4.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn5.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn5.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn6.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn6.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn7.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn7.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn8.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn8.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn9.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn9.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn10.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn10.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn11.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn11.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn11.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn12.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn12.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn12.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn13.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn13.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn13.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn14.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn14.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn14.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn15.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn15.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn15.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn16.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn16.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn16.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn17.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn17.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn17.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn18.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn18.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn18.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn19.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn19.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn19.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn20.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn20.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn20.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn21.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn21.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn21.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn22.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn22.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn22.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn23.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn23.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn23.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });

        btn24.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn24.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(three.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경
                btn24.setBackgroundColor(Color.RED);

                // 알림
                createNotification();

                return true;
            }


        });


    }

    @Override
    protected  void onPause(){
        super.onPause();
        saveState();
    }

    @Override
    protected void onResume(){
        super.onResume();
        restoreSatate();
    }

    protected void saveState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name",display.getText().toString());
        editor.putString("text1",text.getText().toString());
        editor.commit();
    }

    protected void restoreSatate(){
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        if((pref!=null)&&(pref.contains("name"))&&(pref.contains(("text1")))){
            String name = pref.getString("name","");
            String text1 = pref.getString("text1","");
            display.setText(name);
            text.setText(text1);

        }
    }
    private void createNotification () {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Beacon PKNU 도서관");
        builder.setContentText("6시간 남았습니다");

        builder.setColor(Color.RED);
        // 사용자가 탭을 클릭하면 자동 제거
        builder.setAutoCancel(true);

        // 알림 표시
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel("default", "기본 채널", NotificationManager.IMPORTANCE_DEFAULT));
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(2000);
        }

        // id값은
        // 정의해야하는 각 알림의 고유한 int값
        notificationManager.notify(1, builder.build());
    }


}