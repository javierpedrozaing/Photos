package com.example.javier.photos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;


/**
 * Created by javier on 1/27/17.
 */

public class RegisterActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        showToolbar(getResources().getString(R.string.toolbar_title_register), true);
    }


    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
