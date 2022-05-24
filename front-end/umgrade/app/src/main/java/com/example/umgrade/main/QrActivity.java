package com.example.umgrade.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umgrade.R;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.User;
import com.google.zxing.ResultPoint;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QrActivity extends AppCompatActivity {

//    private IntentIntegrator qrScan;
    private CaptureManager capture;
    private DecoratedBarcodeView customBarcodeView;
    User vo;
    RequestQueue queue;
    StringRequest request;
    String server_url2 = "http://172.30.1.24:8081/myapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        vo = UserInfo.info;

        queue = Volley.newRequestQueue(QrActivity.this);

        customBarcodeView = (DecoratedBarcodeView) findViewById(R.id.customBarcodeView);
        capture = new CaptureManager(this, customBarcodeView);

        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.decode();
        customBarcodeView.decodeContinuous(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult result) {
                readBarcode(result.toString());
                Intent intent = new Intent(QrActivity.this, MainActivity.class);
//                intent.putExtra("uboxId",result.toString());
//                intent.putExtra("userId", vo.getUser_id());
                startActivity(intent);
                Log.d("result", result.toString());
                finish();
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
//
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
        vo = UserInfo.info;
        //Toast.makeText(getApplicationContext(), barcode, Toast.LENGTH_LONG).show();
        Log.d("barcode", barcode);
        int method = Request.Method.POST;
        String server_url = server_url2+"/Android/Rent";
        request = new StringRequest(
                method,
                server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response1", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(QrActivity.this,
                                "실패!"+error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("uboxSeq", barcode);
                param.put("userId", vo.getUser_id());
                return param;
            }
        };

        queue.add(request);

    }


}