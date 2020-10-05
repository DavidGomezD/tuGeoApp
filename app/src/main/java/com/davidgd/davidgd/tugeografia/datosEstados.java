package com.davidgd.davidgd.tugeografia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class datosEstados extends AppCompatActivity {

    TextView Estado, Capital;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31;

    //Sonido
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Quita las notificaciones, no mover de lugar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_datos_estados);

        //Conexion a la imagen
        final ImageView map = (ImageView) findViewById(R.id.imageMapa) ;

        //Conexion a los tv
        Estado = (TextView) findViewById(R.id.tvEstado);
        Capital = (TextView) findViewById(R.id.tvCapital);

        //Conexion a los botones
        b0 = (Button) findViewById(R.id.button0);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        b10 = (Button) findViewById(R.id.button10);
        b11 = (Button) findViewById(R.id.button11);
        b12 = (Button) findViewById(R.id.button12);
        b13 = (Button) findViewById(R.id.button13);
        b14 = (Button) findViewById(R.id.button14);
        b15 = (Button) findViewById(R.id.button15);
        b16 = (Button) findViewById(R.id.button16);
        b17 = (Button) findViewById(R.id.button17);
        b18 = (Button) findViewById(R.id.button18);
        b19 = (Button) findViewById(R.id.button19);
        b20 = (Button) findViewById(R.id.button20);
        b21 = (Button) findViewById(R.id.button21);
        b22 = (Button) findViewById(R.id.button22);
        b23 = (Button) findViewById(R.id.button23);
        b24 = (Button) findViewById(R.id.button24);
        b25 = (Button) findViewById(R.id.button25);
        b26 = (Button) findViewById(R.id.button26);
        b27 = (Button) findViewById(R.id.button27);
        b28 = (Button) findViewById(R.id.button28);
        b29 = (Button) findViewById(R.id.button29);
        b30 = (Button) findViewById(R.id.button30);
        b31 = (Button) findViewById(R.id.button31);

        //Sonido, nunca poner mayusculas en el nombre del sonido
        mp = MediaPlayer.create(this, R.raw.clic);


        //Acciones de los botones
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e0);
                Capital.setText(R.string.c0);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx0);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e1);
                Capital.setText(R.string.c1);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx1);
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e2);
                Capital.setText(R.string.c2);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx2);
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e3);
                Capital.setText(R.string.c3);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx3);
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e4);
                Capital.setText(R.string.c4);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx4);
            }
        });


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e5);
                Capital.setText(R.string.c5);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx5);
            }
        });


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e6);
                Capital.setText(R.string.c6);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx6);
            }
        });


        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e7);
                Capital.setText(R.string.c7);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx7);
            }
        });


        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e8);
                Capital.setText(R.string.c8);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx8);
            }
        });


        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e9);
                Capital.setText(R.string.c9);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx9);
            }
        });


        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e10);
                Capital.setText(R.string.c10);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx10);
            }
        });


        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e11);
                Capital.setText(R.string.c11);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx11);
            }
        });


        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e12);
                Capital.setText(R.string.c12);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx12);
            }
        });


        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e13);
                Capital.setText(R.string.c13);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx13);
            }
        });


        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e14);
                Capital.setText(R.string.c14);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx14);
            }
        });


        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e15);
                Capital.setText(R.string.c15);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx15);
            }
        });


        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e16);
                Capital.setText(R.string.c16);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx16);
            }
        });


        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e17);
                Capital.setText(R.string.c17);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx17);
            }
        });


        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e18);
                Capital.setText(R.string.c18);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx18);
            }
        });


        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e19);
                Capital.setText(R.string.c19);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx19);
            }
        });


        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e20);
                Capital.setText(R.string.c20);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx20);
            }
        });


        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e21);
                Capital.setText(R.string.c21);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx21);
            }
        });


        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e22);
                Capital.setText(R.string.c22);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx22);
            }
        });


        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e23);
                Capital.setText(R.string.c23);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx23);
            }
        });


        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e24);
                Capital.setText(R.string.c24);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx24);
            }
        });


        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e25);
                Capital.setText(R.string.c25);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx25);
            }
        });


        b26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e26);
                Capital.setText(R.string.c26);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx26);
            }
        });


        b27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e27);
                Capital.setText(R.string.c27);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx27);
            }
        });


        b28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e28);
                Capital.setText(R.string.c28);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx28);
            }
        });


        b29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e29);
                Capital.setText(R.string.c29);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx29);
            }
        });


        b30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e30);
                Capital.setText(R.string.c30);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx30);
            }
        });


        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sonido
                mp.start();

                Estado.setText(R.string.e31);
                Capital.setText(R.string.c31);

                //Cambia la imagen del mapa
                map.setImageResource(R.drawable.mapamx31);
            }
        });
    }
}