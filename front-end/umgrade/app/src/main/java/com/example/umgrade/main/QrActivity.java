package com.example.umgrade.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.example.umgrade.R;
import com.example.umgrade.vo.User;
import com.google.zxing.ResultPoint;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import java.util.List;

public class QrActivity extends AppCompatActivity {

//    private IntentIntegrator qrScan;
    private CaptureManager capture;
    private DecoratedBarcodeView customBarcodeView;
    User vo;
    RequestQueue queue;
    StringRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        customBarcodeView = (DecoratedBarcodeView) findViewById(R.id.customBarcodeView);
        capture = new CaptureManager(this, customBarcodeView);

        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.decode();
        customBarcodeView.decodeContinuous(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult result) {
                readBarcode(result.toString());
            }
            @Override
            public void possibleResultPoints(List<ResultPoint> resultPoints){

            }
        });

//        qrScan = new IntentIntegrator(this);
//
//        // default : 세로 / 휴대폰 방향에 따라 가로, 세로로 자동 변경
//        qrScan.setOrientationLocked(false);
//        // 문구 변경
//        qrScan.setPrompt("사각 테두리 안에 QR코드를 인식해 주세요.");
//        // 커스텀 불러오기
//        qrScan.setCaptureActivity(CustomScannerActivity.class);
//        qrScan.initiateScan();


    }
    @Override
    protected  void onResume(){
        super.onResume();
        capture.onResume();
    }
    @Override
    protected void onPause(){
        super.onPause();
        capture.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        capture.onDestroy();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        capture.onSaveInstanceState(outState);
    }

    public void readBarcode(String barcode){
        Toast.makeText(getApplicationContext(), barcode, Toast.LENGTH_LONG).show();
    }


}