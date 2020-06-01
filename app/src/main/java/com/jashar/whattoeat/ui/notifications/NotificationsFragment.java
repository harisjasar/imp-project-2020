package com.jashar.whattoeat.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jashar.whattoeat.ApiService;
import com.jashar.whattoeat.MatchFoundActivity;
import com.jashar.whattoeat.R;
import com.jashar.whattoeat.model.MenuModel;
import com.jashar.whattoeat.model.RestaurantNameLatLngModel;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mGoogleMap;
    private MapView mMapView;
    private View mView;
    private RequestQueue requestQueue;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_notifications, container, false);

        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());




        return mView;
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        mMapView = (MapView) mView.findViewById(R.id.mapView);
        if(mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);


        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        ArrayList<RestaurantNameLatLngModel> restaurantList = (ArrayList<RestaurantNameLatLngModel>) ApiService.getAllRestaurantsMetaData(requestQueue);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(restaurantList.isEmpty()){
                    Toast.makeText(getContext(), "No restaurants found!", Toast.LENGTH_LONG).show();
                }else{
                    MapsInitializer.initialize(getContext());
                    mGoogleMap = googleMap;
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                    for(RestaurantNameLatLngModel model : restaurantList){
                        googleMap.addMarker(new MarkerOptions().position(new LatLng(model.getmLat(), model.getmLng())).title(model.getmName()).snippet(model.getmTag()));
                    }

                    CameraPosition Liberty = CameraPosition.builder().target(new LatLng(restaurantList.get(0).getmLat(), restaurantList.get(0).getmLng())).zoom(16).bearing(0).tilt(45).build();
                    googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

                }
            }
        }, 500);
    }
}