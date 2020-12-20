package org.techtown.animalunteer;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    View rootView;
    MapView mapView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_map, container, false);

        mapView = (MapView)rootView.findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onResume(){
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(this.getActivity());

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(35.84686, 127.12928), 14);
        googleMap.animateCamera(cameraUpdate);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.84686, 127.12928)).title("전북대"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.248249149175464, 126.87892031351352)).title("광주 동물보호소"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.93675756279481, 127.00240979763991)).title("익산 유기동물보호소"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.960714650804206, 126.81577296139993)).title("군산 유기동물보호센터"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(34.85372948216843, 126.43027889760849)).title("목포시 유기동물보호소"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(34.74855690548188, 126.4859461571284)).title("삼호 유기견 보호소"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(36.02332725365387, 126.98921944437555)).title("하얀강아지"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.15567471475577, 126.8354954424672)).title("광주동물보호협회 위드")); //광주
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.008368335584976, 127.03245337255996)).title("화순동물보호협회 위드")); //화순
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.80363099809347, 126.88053702599807)).title("동행세상"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.01600720920167, 126.71082508179154)).title("나주 천사의 집"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.0160752774857, 127.37918695480633)).title("순천 유기동물 보호소"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(34.761940865406906, 127.66178693838108)).title("여수 여미지 보호소"));
    }

}