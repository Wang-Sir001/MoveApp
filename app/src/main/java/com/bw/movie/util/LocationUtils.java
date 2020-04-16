package com.bw.movie.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.util.List;

import static android.content.Context.LOCATION_SERVICE;

/**
 * date:2020/3/28 0028
 * function:位置获取
 */
public class LocationUtils {
    private Location location;
    private StringBuilder builder;
    private double latitude;
    private double longitude;
    private LocationUtils() {
    }

    private static final class Holder {
        private static final LocationUtils LOCATION_UTILS = new LocationUtils();
    }

    public static LocationUtils getInstance() {

        return Holder.LOCATION_UTILS;
    }


    //得到城市的方法  参数为传递过来的上下文
    public String getCity(Context context){
        //获取地理信息管理者
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        LocationManager locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        // Criteria是一组筛选条件
        Criteria criteria = new Criteria();
        //设置定位精准度
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        //是否要求海拔
        criteria.setAltitudeRequired(false);
        //是否要求方向
        criteria.setBearingRequired(true);
        //是否要求收费
        criteria.setCostAllowed(true);
        //是否要求速度
        criteria.setSpeedRequired(true);
        //设置电池耗电要求
        criteria.setPowerRequirement(Criteria.NO_REQUIREMENT);
        //设置方向精确度
        criteria.setBearingAccuracy(Criteria.ACCURACY_HIGH);
        //设置速度精确度
        criteria.setSpeedAccuracy(Criteria.ACCURACY_HIGH);
        //设置水平方向精确度
        criteria.setHorizontalAccuracy(Criteria.ACCURACY_HIGH);
        //设置垂直方向精确度
        criteria.setVerticalAccuracy(Criteria.ACCURACY_HIGH);
        //满足条件的当前provider
        String currentProvider = locationManager.getBestProvider(criteria, true);
        if (currentProvider!=null){
            //结果就是passive，gps，network；
            Log.d("location", "currentProvider: "+ currentProvider);
        }
        //根据当前provider对象获取最后一次位置信息
        Location currentLocation = getLastKnownLocation(context);
        //如果位置信息为null，则请求更新位置信息
        if(currentLocation ==null){
            locationManager.requestLocationUpdates(currentProvider, 20000, 0, locationListener);
        }
        //直到获得最后一次位置信息为止，如果未获得最后一次位置信息，则显示默认经纬度
        //调用监听方法
        //解析地址并显示
        String latLongString = null;
        //获取经纬度
        if (currentLocation != null) {
            double lat = currentLocation.getLatitude();
            double lng = currentLocation.getLongitude();
           /* DecimalFormat decimalFormat = new DecimalFormat("0.00");
            latitude = Double.parseDouble(decimalFormat.format(lat));
            longitude = Double.parseDouble(decimalFormat.format(lng));*/
            latLongString=lat+","+lng;

        } else {
            latLongString = "无法获取地理信息";
        }



        return latLongString;
    }
    private LocationListener locationListener =new LocationListener(){

        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };
    private Location getLastKnownLocation(Context context) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        LocationManager locationManager = (LocationManager)context.getSystemService(LOCATION_SERVICE);
        List<String> providers = locationManager.getAllProviders();
        Location bestLocation = null;
        for (String provider : providers) {

            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }

}
