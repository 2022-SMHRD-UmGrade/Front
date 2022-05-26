package com.example.umgrade.main;

import static com.google.common.collect.ComparisonChain.start;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.umgrade.FareActivity;
import com.example.umgrade.MoreActivity;
import com.example.umgrade.R;
import com.example.umgrade.community.CommuActivity;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.notice.NoticeActivity;
import com.example.umgrade.service.ServiceActivity;
import com.example.umgrade.service.SupportActivity;
import com.example.umgrade.userActivity.MypageActivity;
import com.example.umgrade.vo.User;
//import com.example.umgrade.weather.OpenWeather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ImageView imgMypageProfile, imgWeather;
    Button btnFare, btnServiceCard, btnNoticeEvent, btnMapCard, btnQrCard, btnSupportCard;
    Button navMain, navCommu, navMypage, navMore;
    TextView tvNickMypageCard, tvRatingMypageCard, tvPointMypageCard, tvWeather, tvCity, tvTemp, tvWind;
    View myPageLayout;

<<<<<<< HEAD


    Retrofit retrofit;
    WeatherApi weatherApi;
    private final String TAG = "OpenWeatherRepository";
    public static final String BASE_URL = "https://api.openweathermap.org/";
    //OpenWeather opw;
    private final static String appKey = "0ce6acbe268f9a28e74c30c6825ec6c6";


=======
>>>>>>> e8589384e3cf8b036c03530fb1bf112bdf486e5e
    View btnFareLayout;
    User vo;

    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vo = UserInfo.info;

        tvNickMypageCard = findViewById(R.id.tvNickMypageCard);
        tvRatingMypageCard = findViewById(R.id.tvRatingMypageCard);
        tvPointMypageCard = findViewById(R.id.tvPointMypageCard);
        tvWeather = findViewById(R.id.tvWeather);
        tvCity = findViewById(R.id.tvCity);
        tvWind = findViewById(R.id.tvWind);
        tvTemp = findViewById(R.id.tvTemp);

        imgWeather = findViewById(R.id.imgWeather);

        tvNickMypageCard.setText(vo.getUser_nick());
        tvRatingMypageCard.setText(vo.getUser_type());
        tvPointMypageCard.setText(vo.getUser_point());

        queue = Volley.newRequestQueue(MainActivity.this);

<<<<<<< HEAD

        Intent intent = getIntent();


=======
        Intent intent = getIntent();

>>>>>>> e8589384e3cf8b036c03530fb1bf112bdf486e5e
        int method = Request.Method.GET;
        String url = "http://api.openweathermap.org/data/2.5/weather?q=Gwangju&appid=d8cff0a3fa05c7e4447804bb9b4cb398";

        request = new StringRequest(
                method,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String city ="";
                            JSONObject obj = new JSONObject(response);
                            //Log.d("rrrrrrr", obj.getString("coord"));
                            System.out.println("obj.getString(\"coord\")"+obj.getString("coord"));
                            if(obj.getString("name").equals("Gwangju")){
                                city = "광주";
                            }else{
                                city = "한국";
                            };

                            JSONArray weatherJson = obj.getJSONArray("weather");
                            JSONObject weatherObj = weatherJson.getJSONObject(0);
                            String weather = "";
                            if(weatherObj.getString("main").equals("Thunderstorm")){
                                weather = "번개";
                                imgWeather.setImageResource(R.drawable.weather_thunder);
                            }else if(weatherObj.getString("main").equals("Drizzle")){
                                weather ="이슬비";
                                imgWeather.setImageResource(R.drawable.weather_drizzle);
                            }else if(weatherObj.getString("main").equals("Rain")){
                                weather = "비";
                                imgWeather.setImageResource(R.drawable.weather_rainy);
                            }else if(weatherObj.getString("main").equals("Snow")){
                                weather = "눈";
                                imgWeather.setImageResource(R.drawable.weather_snowy);
                            }else if(weatherObj.getString("main").equals("Atmosphere")){
                                weather = "안개";
                                imgWeather.setImageResource(R.drawable.weather_fog);
                            }else if(weatherObj.getString("main").equals("Clear")){
                                weather = "맑음";
                                imgWeather.setImageResource(R.drawable.weather_sunshine);
                            }else if(weatherObj.getString("main").equals("Clouds")){
                                weather = "구름";
                                imgWeather.setImageResource(R.drawable.weather_cloud);
                            }


                            JSONObject tempk = new JSONObject(obj.getString("main"));
                            double tempDo = (Math.round((tempk.getDouble("temp")-273.15)*100)/100.0);

                            JSONObject wind = new JSONObject(obj.getString("wind"));
                            double windSpeed = wind.getDouble("speed");

                            tvCity.setText(city);
                            tvWeather.setText(weather);
                            tvTemp.setText(tempDo+"°C");
                            tvWind.setText(windSpeed+"㎧");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,
                                "실패",
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
        queue.add(request);

<<<<<<< HEAD

=======
>>>>>>> e8589384e3cf8b036c03530fb1bf112bdf486e5e
        // 마이페이지 카드 클릭 시 mypage로 이동
        myPageLayout = findViewById(R.id.myPageLayout);


        myPageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MypageActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                // Log.v("tetetetetet","teteltetet");
                //((MainActivity)getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.container, MainActivity.frag_mypage).commit();
                //MypageFragment frag_mypage = new MypageFragment();
                //((MainActivity)getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_mypage).commit();
            }
        });

        btnServiceCard = findViewById(R.id.btnServiceCard);
        // 서비스안내 클릭 시 화면전환
        btnServiceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

        btnNoticeEvent = findViewById(R.id.btnNoticeEvent);
        // 공지&이벤트 클릭 시 화면전환
        btnNoticeEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });

        btnMapCard = findViewById(R.id.btnMapCard);
        // 보관함 찾기 클릭 시 화면전환
        btnMapCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        btnSupportCard = findViewById(R.id.btnSupportCard);
        // 고객센터 클릭 시 화면전환
        btnSupportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SupportActivity.class);
                startActivity(intent);
            }
        });

        btnQrCard = findViewById(R.id.btnQrCard);
        // QR스캔 클릭 시 화면전환

        if (vo.getUser_type().equals("P")) {
            btnQrCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, QrActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        } else {
            Toast.makeText(this,
                    "결재정보를 입력해주세요",
                    Toast.LENGTH_SHORT).show();
        }


        imgMypageProfile = (ImageView) findViewById(R.id.imgMypageProfile);
        Glide.with(this).load(R.drawable.logoumbrella).circleCrop().into(imgMypageProfile);

        btnFare = findViewById(R.id.btnFare);
        // 로그인 시 btnFare에 "오늘까지의 UM-CYCLE 이용 요금은 n,nnn원 입니다." 출력
        btnFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 요금 안내 페이지로 이동
                Intent intent = new Intent(MainActivity.this, FareActivity.class);
                startActivity(intent);
            }
        });
        // 페이지 전환
        navMain = findViewById(R.id.navMain);
        navCommu = findViewById(R.id.navCommu);
        navMypage = findViewById(R.id.navMypage);
        navMore = findViewById(R.id.navMore);

        navCommu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CommuActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        navMypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MypageActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        navMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MoreActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }
}




