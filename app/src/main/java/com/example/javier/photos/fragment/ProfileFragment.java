package com.example.javier.photos.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javier.photos.R;
import com.example.javier.photos.adapter.PictureAdapterRecyclerView;
import com.example.javier.photos.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("", false, view);

        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureProfileRecycler );

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(builcPicutres(), R.layout.cardview_picture, getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    public ArrayList<Picture> builcPicutres(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg", "Javier Pedroza", "4 dias", "3 Me gusta"));
        pictures.add(new Picture("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg", "Juan Pablo", "2 dias", "1 Me gusta"));
        pictures.add(new Picture("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg", "Uriel", "1 dias", "2 Me gusta"));
        return pictures;
    }

    public void showToolbar(String title, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar); // caputro la actividad (activityCOntainer)  y añadimos soporte al toolbar
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
