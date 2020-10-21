package com.davidgd.davidgd.tugeografia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.davidgd.davidgd.tugeografia.utilidades.Utilidades;



public class SegundaActividad extends AppCompatActivity {

    MediaPlayer mp;

    TextView TusPuntos, TuRecord;
    Button bFin;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Quita la barra de notificaciones
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_segunda_actividad);

        //Animacion fondo
        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios", null, 1);

        TusPuntos = (TextView) findViewById(R.id.TuPuntuacion);
        TuRecord = (TextView) findViewById(R.id.TuRecord);

        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("MandarPuntos");

        TusPuntos.setText("Puntuación: "+dato);

        bFin = (Button) findViewById(R.id.bFin);

        //Sonido, nunca poner mayusculas en el nombre del sonido
        mp = MediaPlayer.create(this, R.raw.clic);

        //Consulta de la puntuacion mas alta en la base de datos
        consultar();

        bFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Activa el sonido
                mp.start();
                //termina la actividad para que no se pueda regresar
                finish();
            }
        });

    }
    //Fin del onCreate

    //Metodos del programa

    //Realiza la consulta en la bd para imprimir el record
    private void consultar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] campos = {"max(marcador)"};

        try {

            Cursor cursor = db.query(Utilidades.TABLA_PUNTOSUSUARIO, campos, null, null, null,null,null);
            cursor.moveToFirst();

            TuRecord.setText("Record: "+(cursor.getString(0)));

            cursor.close();

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"El documento no existe", Toast.LENGTH_SHORT).show();

        }
    }

}
