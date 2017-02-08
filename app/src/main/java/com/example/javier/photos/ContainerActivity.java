package com.example.javier.photos;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.javier.photos.fragment.HomeFragment;
import com.example.javier.photos.fragment.ProfileFragment;
import com.example.javier.photos.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        bottomBar.setDefaultTab(R.id.home);

        //inicializamos el SELECT LISTENER para el bottom bar
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.home:
                        // creamos un objeto de fragment
                        HomeFragment homeFragment = new HomeFragment();
                        // añadimos transaccion al iniciar
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                        break;
                    case R.id.search:
                        // creamos un objeto de fragment
                        SearchFragment searchFragment= new SearchFragment();
                        // añadimos transaccion al iniciar
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.profile:
                        // creamos un objeto de fragment
                        ProfileFragment profileFragment= new ProfileFragment();
                        // añadimos transaccion al iniciar
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                }
            }
        });
    }


}
