package com.davidgd.davidgd.tugeografia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {

    Button bjugar, btnInformacion;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Quita las notificaciones, no mover de lugar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //Codigo add
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //Fin de codigo add

        //Id de los botones
        bjugar = (Button) findViewById(R.id.bjugar);
        btnInformacion = (Button) findViewById(R.id.botonInformacion);

        //Eventos de click
        bjugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // iniciamos el cambio de actividad
                Intent i = new Intent(MainActivity.this, juego.class);
                startActivity(i);
            }
        });

        btnInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // iniciamos el cambio de actividad
                Intent i = new Intent(MainActivity.this, informacion.class);
                startActivity(i);
            }
        });

    }
}