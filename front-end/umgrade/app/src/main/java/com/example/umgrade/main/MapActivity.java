

package com.example.umgrade.main;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umgrade.R;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.User;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.security.MessageDigest;

public class MapActivity extends AppCompatActivity implements MapView.CurrentLocationEventListener, MapView.POIItemEventListener, MapView.MapViewEventListener {

    private static final String TAG = "MapActivity";
    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 0;
    String[] REQUIRED_PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION};
    private MapView mapView;
    double mCurrentLng;
    double mCurrentLat;
    User vo;

    RequestQueue queue;
    StringRequest request;
    String server_url2 = "http://192.168.43.209:8081/myapp";
    TextView mapCardLoc, mapCardUmbCnt, mapCardSeq, mapCardQr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapCardLoc = findViewById(R.id.mapCardLoc); // ????????????
        mapCardUmbCnt = findViewById(R.id.mapCardUmbCnt); // ?????? ??????
        mapCardSeq = findViewById(R.id.mapCardSeq); // ????????? ??????
        mapCardQr = findViewById(R.id.mapCardQr); // QR??????
// ???????????? ??????
        // ???????????? ????????? QR?????? ??????
//        mapCardQr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MapActivity.this, QrActivity.class);
//                startActivity(intent);
//            }
//        });

        queue = Volley.newRequestQueue(MapActivity.this);

        vo = UserInfo.info;

        int method = Request.Method.POST;
        String server_url = server_url2+"/Android/Login";

        request = new StringRequest(
                method,
                server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        getAppKeyHash();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            initView();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MapActivity.this,
                                "" + error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
        queue.add(request);
    }

    //????????? ?????? API ?????????????????? ????????? ?????? ??? ??????
    private void getAppKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.d("Hash Key", something);
            }
        } catch (Exception e) {
            Log.e("name not found", e.toString());
        }
    }

   //?????? ????????? ?????????
   public void initView() {

        mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_View);
        mapViewContainer.addView(mapView);

        mapView.setMapViewEventListener(this); // this??? MapView.MapViewEventListener ??????.

        if (!checkLocationServiceStatus()){
            showDialogForLocationServiceSetting();}
        else{
            checkRunTimePermission();
        }

        //setCurrentLocationTrackingMode (????????? ???????????? ?????? ???????????? ???????????????.)
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
        mapView.setCurrentLocationEventListener(MapActivity.this);
        mapView.setPOIItemEventListener(this);



    }

    // ????????? ?????? ???????????? ?????? ???????????? ???????????? ?????????
    public boolean checkLocationServiceStatus(){
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    // ?????? ?????? ???????????? setCurrentLocationEventListener
    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint mapPoint, float accuracyInMeters) {
        MapPoint.GeoCoordinate mapPointGeo = mapPoint.getMapPointGeoCoord();
        Log.i(TAG, String.format("MapView onCurrentLocationUpdate (%f,%f) accuracy (%f)", mapPointGeo.latitude, mapPointGeo.longitude, accuracyInMeters));
        MapPoint currentMapPoint = MapPoint.mapPointWithGeoCoord(mapPointGeo.latitude, mapPointGeo.longitude);
        //??? ????????? ?????? ?????? ??????
        mapView.setMapCenterPoint(currentMapPoint, true);
        //?????? ?????? ??????
        mCurrentLat = mapPointGeo.latitude; //??????
        mCurrentLng = mapPointGeo.longitude; //??????
        Log.d(TAG, "???????????? => " + mCurrentLat + "  " + mCurrentLng);

        MapPOIItem marker = new MapPOIItem();
        //??? ????????? ???????????? ??????
        mapPoint = MapPoint.mapPointWithGeoCoord(mCurrentLat, mCurrentLng);

        marker.setItemName("Ubox1");

        marker.setTag(0);
        marker.setMapPoint(mapPoint);

        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // ???????????? ???????????? BluePin ?????? ??????.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // ????????? ???????????????, ???????????? ???????????? RedPin ?????? ??????.
        mapView.addPOIItem(marker);


        MapPOIItem marker1 = new MapPOIItem();

        MapPoint mapPoint1 = MapPoint.mapPointWithGeoCoord(35.14953, 126.91937);

        marker1.setItemName("Ubox2");

        marker1.setTag(0);
        marker1.setMapPoint(mapPoint1);

        marker1.setMarkerType(MapPOIItem.MarkerType.BluePin); // ???????????? ???????????? BluePin ?????? ??????.
        marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // ????????? ???????????????, ???????????? ???????????? RedPin ?????? ??????.
        mapView.addPOIItem(marker1);

        //????????? ????????? ?????? ?????? ???????????? ??????????????? ??????, ????????? ?????? ?????????????????? ???????????? ??????????????? ?????? ??????
        boolean isTrackingMode = false;
        if (!isTrackingMode) {
            mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOff);
        }
    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {

    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {
        Log.i(TAG, "onCurrentLocationUpdateFailed");
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {
        Log.i(TAG, "onCurrentLocationUpdateCancelled");
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
    }

    //????????? ?????? ?????????
    void checkRunTimePermission() {
        int hasFineLocationPermission = ContextCompat.checkSelfPermission(MapActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED){
            mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
        }else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(MapActivity.this,REQUIRED_PERMISSIONS[0])){
                Toast.makeText(MapActivity.this,
                        "??? ?????? ??????????????? ?????? ?????? ????????? ???????????????.",
                        Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(MapActivity.this,REQUIRED_PERMISSIONS,PERMISSIONS_REQUEST_CODE);
            }else{
                ActivityCompat.requestPermissions(MapActivity.this,REQUIRED_PERMISSIONS,PERMISSIONS_REQUEST_CODE);
            }
        }
    }
    //gps????????? ?????? ?????? ???????????? ?????? ????????? ?????? ?????????
    private void showDialogForLocationServiceSetting(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MapActivity.this);
        builder.setTitle("?????? ????????? ????????????");
        builder.setMessage("?????? ???????????? ?????? ?????? ???????????? ???????????????.");
        builder.setCancelable(true);
        builder.setPositiveButton("??????",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent callGPSSettingIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(callGPSSettingIntent,GPS_ENABLE_REQUEST_CODE);
            }
        });
        builder.create().show();
    }

    @Override
    public void onMapViewInitialized(MapView mapView) {

    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

}