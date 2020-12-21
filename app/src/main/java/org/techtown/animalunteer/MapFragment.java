package org.techtown.animalunteer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    View rootView;
    MapView mapView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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

        // 지도 시작위치
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(35.84686, 127.12928), 10);
        googleMap.animateCamera(cameraUpdate);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.84686, 127.12928)).title("전북대"));

        // 보호소 마커
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.248249149175464, 126.87892031351352)).title("광주 동물보호소")
                .snippet("062-571-2808\n" +
                        "http://www.kcanimal.or.kr/default.asp\n" +
                        "광주 북구 본촌마을길 27 (본촌동 378-6)"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.93675756279481, 127.00240979763991)).title("익산 유기동물보호소")
                .snippet("010-3659-2380\n" +
                        "전라북도 익산시 서동로42길 77 (용제동) 16통 1반\n" +
                        "https://band.us/@dogshelter"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.960714650804206, 126.81577296139993)).title("군산 유기동물보호센터")
                .snippet("010-3675-9330\n" +
                        "전라북도 군산시 대야면 보덕안정길 108-20 (대야면) 군산도그랜드\n" +
                        "https://www.facebook.com/groups/2291246801097054/\n" +
                        "instagram@gunsan_dogcat"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(34.85372948216843, 126.43027889760849)).title("목포시 유기동물보호소")
                .snippet("061-274-3570\n" +
                        "010-9678-9966\n" +
                        "전라남도 무안군 삼향읍 석매길 21-5 (삼향읍)"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(34.74855690548188, 126.4859461571284)).title("유기동물 삼호 보호소")
                .snippet("010-9599-5400\n" +
                        "전라남도 영암군 삼호읍 녹색로 1117-49 (삼호읍) 영암유기동물 삼호보호소"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(36.02332725365387, 126.98921944437555)).title("하얀강아지")
                .snippet("010-5247-0440\n" +
                        "cafe.naver.com/kkkk4428"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.15567471475577, 126.8354954424672)).title("광주동물보호협회 위드")
                .snippet("062-531-6341\n" +
                        "cafe.naver.com/lovedog1253")); //광주
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.008368335584976, 127.03245337255996)).title("화순동물보호협회 위드")
                .snippet("010-4345-5580\n" +
                        "전라남도 화순군 한천면 덕음로 115 (한천면)\n" +
                        "cafe.naver.com/lovedog1253")); //화순
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.80363099809347, 126.88053702599807)).title("동행세상")
                .snippet("instagram@lcfkd\n" +
                        "https://m.cafe.daum.net/LineageStory/_rec"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.01600720920167, 126.71082508179154)).title("나주 천사의 집")
                .snippet("010-8620-2222\n" +
                        "https://cafe.naver.com/angelshousa/30923\n" +
                        "instagram@naju_1004s\n" +
                        "facebook@najuangelshouse"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.0160752774857, 127.37918695480633)).title("순천 유기동물 보호소")
                .snippet("061-749-8793\n" +
                        "전라남도 순천시 승주읍 승주로 628 (승주읍, 농업기술센터)\n" +
                        "https://cafe.naver.com/dogsfamliy (여기서 봉사신청, 후원)"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(34.761940865406906, 127.66178693838108)).title("여수 여미지 보호소")
                .snippet("instagram@yeomiji_shelter\n" +
                        "https://cafe.naver.com/943400"));

        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getActivity();



                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                Linkify.addLinks(snippet, Linkify.ALL);
                snippet.setMovementMethod(LinkMovementMethod.getInstance());

                return info;
            }
        });



    }


}