package com.example.javier.photos.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javier.photos.PictureDetailActivity;
import com.example.javier.photos.R;
import com.example.javier.photos.model.Picture;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by javier on 1/31/17.
 */

public class PictureAdapterRecyclerView extends RecyclerView.Adapter <PictureAdapterRecyclerView.PictureViewHolder>{

    private ArrayList <Picture> pictures;
    private int resource; // el layout que vamos a utilizar
    private Activity activity; // desde donde se llama esta clase

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    // inicializamos la clase PictureViewHolder estos metodos se generan
    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // convertimos el xml a java por medio del inflate
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    // aqui se recorre la lista y se pasa al cardview
    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Picture picture = pictures.get(position); // va poniendo objetos en el cardview
        holder.usernameCard.setText(picture.getUsername());
        holder.timeCard.setText(picture.getTime());
        holder.likenumberCard.setText(picture.getLikeNumberCard());
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);


        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(activity, v, activity.getString(R.string.transition_name_picture)).toBundle());


                }else{
                    activity.startActivity(intent);
                }

            }
        });
    }

    // cuantas veces tiene que recorrer el objeto picture
    @Override
    public int getItemCount() {
        return pictures.size();
    }

    // view holder que caputa los elementos del layout
    public class PictureViewHolder extends RecyclerView.ViewHolder {

        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likenumberCard;

        public PictureViewHolder(View itemView) {
            super(itemView);

            pictureCard     = (ImageView) itemView.findViewById(R.id.pictureCard);
            usernameCard    = (TextView) itemView.findViewById(R.id.userNameCard);
            timeCard        = (TextView) itemView.findViewById(R.id.timeCard);
            likenumberCard  = (TextView) itemView.findViewById(R.id.likeNumerCard);


        }
    }


}
