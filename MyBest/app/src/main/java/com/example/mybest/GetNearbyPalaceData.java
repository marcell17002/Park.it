package com.example.mybest;

import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GetNearbyPalaceData extends AsyncTask<Object,String,String> {

    String goolePlacesData;
    GoogleMap nmap;
    String url;
    int i =0;

    @Override
    protected  String doInBackground(Object... objects){
        nmap = (GoogleMap)objects[0];
        url = (String)objects[1];

        DownloadUrl downloadUrl = new DownloadUrl();
        try{
            goolePlacesData = downloadUrl.readurl(url);
        } catch (IOException e){
            e.printStackTrace();
        }

        return goolePlacesData;
    }
    @Override
    protected  void onPostExecute(String s){
//        super.onPostExecute(s);
        List<HashMap<String,String >> nearbyPlaceList = null;
        DataParser parser = new DataParser();
        nearbyPlaceList = parser.parse(s);
        showNearbyPlaces(nearbyPlaceList);
    }

    private void  showNearbyPlaces (List<HashMap<String,String>> nearbyPlaceList){
        for(int i=0; i< nearbyPlaceList.size();i++){
            MarkerOptions markerOptions = new MarkerOptions();
            HashMap<String,String > googlePlace = nearbyPlaceList.get(i);

            String placeName =  googlePlace.get("place_name");
            String vicinity = googlePlace.get("vicinity");
            double lat  = Double.parseDouble(googlePlace.get("lat"));
            double lng  = Double.parseDouble(googlePlace.get("lng"));

            LatLng latLng= new LatLng(lat,lng);
            markerOptions.position(latLng);
            markerOptions.title(placeName +" : "+ vicinity);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

            nmap.addMarker(markerOptions);
            nmap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            nmap.animateCamera(CameraUpdateFactory.zoomTo(10));
        }
    }
}
