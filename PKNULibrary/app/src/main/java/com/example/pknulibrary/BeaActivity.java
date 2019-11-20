package com.example.pknulibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;

import java.util.List;
import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BeaActivity extends Activity {
    private BeaconManager beaconManager;
    private Region region;
    private TextView tvId;
    private boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bea);

        //버튼
        Button button = findViewById(R.id.button);

        tvId = (TextView) findViewById(R.id.tvId);

        beaconManager = new BeaconManager(this);

        // 비콘의 수신 범위를 갱신 받음
        beaconManager.setRangingListener(new BeaconManager.RangingListener() {

            @Override
            public void onBeaconsDiscovered(Region region, List<Beacon> list) {
                if (!list.isEmpty()) {
                    Beacon nearestBeacon = list.get(0);
                    Log.d("Airport", "Nearest places: " + nearestBeacon.getRssi());

                    // nearestBeacon.getRssi() : 비콘의 수신 강도
                    tvId.setText(nearestBeacon.getRssi() + "");

                    if ( !isConnected && nearestBeacon.getRssi() > -70 ) {
                        isConnected = true;

                        AlertDialog.Builder dialog = new AlertDialog.Builder(BeaActivity.this);
                        dialog  .setTitle("비콘 연결")
                                .setMessage("비콘 범위 내 위치가 확인되었습니다. 좌석 예약을 진행해 주십시오.")
                                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).create().show();
                    }
                    else if ( nearestBeacon.getRssi() < -70 ){
                        Toast.makeText(BeaActivity.this, "연결 종료", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        region = new Region("ranged region",
                UUID.fromString("CCE99BED-E080-04C4-1A91-1A1A29B64111"),580, 34067); // 본인이 연결할 Beacon의 ID와 Major / Minor Code를 알아야 한다.
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 블루투스 권한 승낙 및 블루투스 활성화
        SystemRequirementsChecker.checkWithDefaultDialogs(this);

        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startRanging(region);
            }
        });
    }

    @Override
    protected void onPause() {
        //beaconManager.stopRanging(region);

        super.onPause();
    }
}