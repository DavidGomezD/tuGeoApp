package com.davidgd.davidgd.tugeografia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import com.davidgd.davidgd.tugeografia.utilidades.Utilidades;

import java.util.Random;

public class juego extends AppCompatActivity {

    //Evita el doble clic
    private long mLastClickTime = 0;

    //Sonido
    MediaPlayer mperror, mp;

    TextView Estado1, Estado2, Estado3, Capital1, Capital2, Capital3, SeleccionEstado, SeleccionCapital, Califica, Marcador, TotalVidas;
    Button BE1, BE2, BE3, BC1, BC2, BC3;

    //Sirve para identificar cuando se da el primer y segundo click
    Integer AppInicio = 0;
    //Almacena los puntos
    Integer Puntos = 0;
    //Indica cuantas veces ganamos si el valor es 3 se mandara la alerta no hay datos
    Integer SeGano = 0;
    //Indicara el fin del juego
    Integer FinApp = 0;
    Integer Vidas = 3;
    //Sirve para borrar los Estados y Capitales
    String BorrarEstado = "";
    String BorrarCapital = "";
    //Variable aleatoria
    Random aleatorio = new Random();
    //El Arreglo debe de ser mayor en 1 por que el random redondea el ultimo valor
    //Declaracion de los arreglos
    String [] ArregloEstados = new String[33];
    String [] ArregloCapitales = new String[33];
    //Variables de tipo entero llenados por el aleatorio, NOTA: Los aleatorios se repiten
    Integer ale1 = aleatorio.nextInt(ArregloEstados.length-1);
    Integer ale2 = aleatorio.nextInt(ArregloEstados.length-1);
    Integer ale3 = aleatorio.nextInt(ArregloEstados.length-1);

    //Anuncio
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Quita las notificaciones, no mover de lugar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_juego);

        //Codigo de anuncio
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Conexion a los TextView
        Estado1 = (TextView) findViewById(R.id.textView);
        Estado2 = (TextView) findViewById(R.id.textView2);
        Estado3 = (TextView) findViewById(R.id.textView3);

        Capital1 = (TextView) findViewById(R.id.textView4);
        Capital2 = (TextView) findViewById(R.id.textView5);
        Capital3 = (TextView) findViewById(R.id.textView6);

        Marcador = (TextView) findViewById(R.id.textView10);
        TotalVidas = (TextView) findViewById(R.id.txtVidas);

        SeleccionEstado = (TextView) findViewById(R.id.textView7);
        SeleccionCapital = (TextView) findViewById(R.id.textView8);
        Califica = (TextView) findViewById(R.id.textView9);

        //Conexion a los botones
        BE1 = (Button) findViewById(R.id.button13);
        BE2 = (Button) findViewById(R.id.button14);
        BE3 = (Button) findViewById(R.id.button15);

        BC1 = (Button) findViewById(R.id.button16);
        BC2 = (Button) findViewById(R.id.button17);
        BC3 = (Button) findViewById(R.id.button18);

        //Sonido, nunca poner mayusculas en el nombre del sonido
        mperror = MediaPlayer.create(this, R.raw.error);
        mp = MediaPlayer.create(this, R.raw.clic);

        //--------------------Inicia las vidas del juego--------------------

        IniciaVidas();

        //--------------------Llenado de los arreglos--------------------

        LLenaLosArreglos();

        //--------------------Ordenamiento aleatorio de los Estados y capitales--------------------

        OrdenamientoAleatorio();

        //-----------------Programacion de los botones--------------------

        BE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sonido
                mp.start();
                if (Estado1.getText() == "" || Estado1.getText() == SeleccionEstado.getText()){
                    //Boton sin texto no hacer nada
                }else {
                    //Cambia el color del boton
                    BE1.setBackgroundDrawable(getResources().getDrawable(R.drawable.b_encendido));
                    SeleccionEstado.setText(Estado1.getText().toString());
                    BorrarEstado = SeleccionEstado.getText().toString();
                    calificiar();
                    VerificarTV();
                    FinalizaActivity();
                }
            }
        });

        BE2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sonido
                mp.start();
                if (Estado2.getText() == "" || Estado2.getText() == SeleccionEstado.getText()){
                    //Boton sin texto no hacer nada
                }else {
                    //Cambia el color del boton
                    BE2.setBackgroundDrawable(getResources().getDrawable(R.drawable.b_encendido));
                    SeleccionEstado.setText(Estado2.getText().toString());
                    BorrarEstado = SeleccionEstado.getText().toString();
                    calificiar();
                    VerificarTV();
                    FinalizaActivity();
                }
            }
        });

        BE3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sonido
                mp.start();
                if (Estado3.getText() == "" || Estado3.getText() == SeleccionEstado.getText()){
                    //Boton sin texto no hacer nada
                }else {
                    //Cambia el color del boton
                    BE3.setBackgroundDrawable(getResources().getDrawable(R.drawable.b_encendido));
                    SeleccionEstado.setText(Estado3.getText().toString());
                    BorrarEstado = SeleccionEstado.getText().toString();
                    calificiar();
                    VerificarTV();
                    FinalizaActivity();
                }
            }
        });

        BC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sonido
                mp.start();
                if (Capital1.getText() == "" || Capital1.getText() == SeleccionCapital.getText()){
                    //Boton sin texto no hacer nada
                }else {
                    //Cambia el color del boton
                    BC1.setBackgroundDrawable(getResources().getDrawable(R.drawable.b_encendido));
                    SeleccionCapital.setText(Capital1.getText().toString());
                    BorrarCapital = SeleccionCapital.getText().toString();
                    calificiar();
                    VerificarTV();
                    FinalizaActivity();
                }
            }
        });

        BC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sonido
                mp.start();
                if (Capital2.getText() == "" || Capital2.getText() == SeleccionCapital.getText()){
                    //Boton sin texto no hacer nada
                }else {
                    //Cambia el color del boton
                    BC2.setBackgroundDrawable(getResources().getDrawable(R.drawable.b_encendido));
                    SeleccionCapital.setText(Capital2.getText().toString());
                    BorrarCapital = SeleccionCapital.getText().toString();
                    calificiar();
                    VerificarTV();
                    FinalizaActivity();
                }
            }
        });

        BC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sonido
                mp.start();
                if (Capital3.getText() == "" || Capital3.getText() == SeleccionCapital.getText()){
                    //Boton sin texto no hacer nada
                }else {
                    //Cambia el color del boton
                    BC3.setBackgroundDrawable(getResources().getDrawable(R.drawable.b_encendido));
                    SeleccionCapital.setText(Capital3.getText().toString());
                    BorrarCapital = SeleccionCapital.getText().toString();
                    calificiar();
                    VerificarTV();
                    FinalizaActivity();
                }
            }
        });

        //Fin del OnCreate
    }

    //Metodos del programa

    //Califica
    public void calificiar(){

        //Calificar
        if (AppInicio == 0){
            Califica.setText("");
            AppInicio = 1;
        }else {if (SeleccionEstado.getText().toString() == ArregloEstados[0] && SeleccionCapital.getText().toString()== ArregloCapitales[0]
                || SeleccionEstado.getText().toString() == ArregloEstados[1] && SeleccionCapital.getText().toString()== ArregloCapitales[1]
                || SeleccionEstado.getText().toString() == ArregloEstados[2] && SeleccionCapital.getText().toString()== ArregloCapitales[2]
                || SeleccionEstado.getText().toString() == ArregloEstados[3] && SeleccionCapital.getText().toString()== ArregloCapitales[3]
                || SeleccionEstado.getText().toString() == ArregloEstados[4] && SeleccionCapital.getText().toString()== ArregloCapitales[4]
                || SeleccionEstado.getText().toString() == ArregloEstados[5] && SeleccionCapital.getText().toString()== ArregloCapitales[5]
                || SeleccionEstado.getText().toString() == ArregloEstados[6] && SeleccionCapital.getText().toString()== ArregloCapitales[6]
                || SeleccionEstado.getText().toString() == ArregloEstados[7] && SeleccionCapital.getText().toString()== ArregloCapitales[7]
                || SeleccionEstado.getText().toString() == ArregloEstados[8] && SeleccionCapital.getText().toString()== ArregloCapitales[8]
                || SeleccionEstado.getText().toString() == ArregloEstados[9] && SeleccionCapital.getText().toString()== ArregloCapitales[9]
                || SeleccionEstado.getText().toString() == ArregloEstados[10] && SeleccionCapital.getText().toString()== ArregloCapitales[10]
                || SeleccionEstado.getText().toString() == ArregloEstados[11] && SeleccionCapital.getText().toString()== ArregloCapitales[11]
                || SeleccionEstado.getText().toString() == ArregloEstados[12] && SeleccionCapital.getText().toString()== ArregloCapitales[12]
                || SeleccionEstado.getText().toString() == ArregloEstados[13] && SeleccionCapital.getText().toString()== ArregloCapitales[13]
                || SeleccionEstado.getText().toString() == ArregloEstados[14] && SeleccionCapital.getText().toString()== ArregloCapitales[14]
                || SeleccionEstado.getText().toString() == ArregloEstados[15] && SeleccionCapital.getText().toString()== ArregloCapitales[15]
                || SeleccionEstado.getText().toString() == ArregloEstados[16] && SeleccionCapital.getText().toString()== ArregloCapitales[16]
                || SeleccionEstado.getText().toString() == ArregloEstados[17] && SeleccionCapital.getText().toString()== ArregloCapitales[17]
                || SeleccionEstado.getText().toString() == ArregloEstados[18] && SeleccionCapital.getText().toString()== ArregloCapitales[18]
                || SeleccionEstado.getText().toString() == ArregloEstados[19] && SeleccionCapital.getText().toString()== ArregloCapitales[19]
                || SeleccionEstado.getText().toString() == ArregloEstados[20] && SeleccionCapital.getText().toString()== ArregloCapitales[20]
                || SeleccionEstado.getText().toString() == ArregloEstados[21] && SeleccionCapital.getText().toString()== ArregloCapitales[21]
                || SeleccionEstado.getText().toString() == ArregloEstados[22] && SeleccionCapital.getText().toString()== ArregloCapitales[22]
                || SeleccionEstado.getText().toString() == ArregloEstados[23] && SeleccionCapital.getText().toString()== ArregloCapitales[23]
                || SeleccionEstado.getText().toString() == ArregloEstados[24] && SeleccionCapital.getText().toString()== ArregloCapitales[24]
                || SeleccionEstado.getText().toString() == ArregloEstados[25] && SeleccionCapital.getText().toString()== ArregloCapitales[25]
                || SeleccionEstado.getText().toString() == ArregloEstados[26] && SeleccionCapital.getText().toString()== ArregloCapitales[26]
                || SeleccionEstado.getText().toString() == ArregloEstados[27] && SeleccionCapital.getText().toString()== ArregloCapitales[27]
                || SeleccionEstado.getText().toString() == ArregloEstados[28] && SeleccionCapital.getText().toString()== ArregloCapitales[28]
                || SeleccionEstado.getText().toString() == ArregloEstados[29] && SeleccionCapital.getText().toString()== ArregloCapitales[29]
                || SeleccionEstado.getText().toString() == ArregloEstados[30] && SeleccionCapital.getText().toString()== ArregloCapitales[30]
                || SeleccionEstado.getText().toString() == ArregloEstados[31] && SeleccionCapital.getText().toString()== ArregloCapitales[31]
                || SeleccionEstado.getText().toString() == ArregloEstados[32] && SeleccionCapital.getText().toString()== ArregloCapitales[32]){
            //Si la respuesta es correcta
            Califica.setText("Correcto");
            //cambia el color a verde
            Califica.setBackgroundDrawable(getResources().getDrawable(R.drawable.b_correcto));
            SeleccionEstado.setText("Estado");
            SeleccionCapital.setText("Capital");
            //Borra las respuestas correctas
            BorrarEC();
            //Limpia las variables a borrar
            BorrarEstado = "";
            BorrarCapital = "";
            //Suma 1 punto
            AumentaP();
            //Aumenta se gano
            AumentaSeGano();
            //Reinicia el contador del boton a 0
            AppInicio = 0;
        }else {
            //Si fallaste sonido feo
            mperror.start();
            Califica.setText("Fallaste");
            Califica.setBackgroundDrawable(getResources().getDrawable(R.drawable.b_fallaste));
            SeleccionEstado.setText("Estado");
            SeleccionCapital.setText("Capital");
            //Limpia las variables a borrar
            BorrarEstado = "";
            BorrarCapital = "";
            //Resta un punto
            DecrementaP();
            //Reinicia el contador del boton a 0
            AppInicio = 0;
        }
            //Cambia el color de todos los botones a anaranjado
            BotonesAnaranjados();
        }
    }
    //Borra los Estados y Capitales
    public void BorrarEC(){

        //Borra los estados
        if (BorrarEstado == Estado1.getText().toString()){
            Estado1.setText("");
        }
        if (BorrarEstado == Estado2.getText().toString()){
            Estado2.setText("");
        }
        if (BorrarEstado == Estado3.getText().toString()){
            Estado3.setText("");
        }

        //Borra las capitales
        if (BorrarCapital == Capital1.getText().toString()){
            Capital1.setText("");
        }
        if (BorrarCapital == Capital2.getText().toString()){
            Capital2.setText("");
        }
        if (BorrarCapital == Capital3.getText().toString()){
            Capital3.setText("");
        }
    }
    //Mas 1 punto
    public void AumentaP(){
        Puntos ++;
        Marcador.setText("Puntos: " + Puntos);
    }
    //Menos 1 punto y menos 1 vida
    public void DecrementaP(){
        Puntos --;
        Vidas --;
        Marcador.setText("Puntos: " + Puntos);
        //TotalVidas.setText("Vidas: " + Vidas);
        IniciaVidas();
    }
    //LLena los arreglos
    public void LLenaLosArreglos(){
        //Ingresa los estados
        ArregloEstados[0] = "Aguascalientes";
        ArregloEstados[1] = "Baja California";
        ArregloEstados[2] = "Baja California Sur";
        ArregloEstados[3] = "Campeche";
        ArregloEstados[4] = "Chihuahua";
        ArregloEstados[5] = "Chiapas";
        ArregloEstados[6] = "Coahuila";
        ArregloEstados[7] = "Colima";
        ArregloEstados[8] = "Durango";
        ArregloEstados[9] = "Guanajuato";
        ArregloEstados[10] = "Guerrero";
        ArregloEstados[11] = "Hidalgo";
        ArregloEstados[12] = "Jalisco";
        ArregloEstados[13] = "Estado de México";
        ArregloEstados[14] = "Michoacán";
        ArregloEstados[15] = "Morelos";
        ArregloEstados[16] = "Nayarit";
        ArregloEstados[17] = "Nuevo León";
        ArregloEstados[18] = "Oaxaca";
        ArregloEstados[19] = "Puebla";
        ArregloEstados[20] = "Querétaro";
        ArregloEstados[21] = "Quintana Roo";
        ArregloEstados[22] = "San Luis Potosí";
        ArregloEstados[23] = "Sinaloa";
        ArregloEstados[24] = "Sonora";
        ArregloEstados[25] = "Tabasco";
        ArregloEstados[26] = "Tamaulipas";
        ArregloEstados[27] = "Tlaxcala";
        ArregloEstados[28] = "Veracruz";
        ArregloEstados[29] = "Yucatán";
        ArregloEstados[30] = "Zacatecas";
        ArregloEstados[31] = "CDMX";
        ArregloEstados[32] = "Disminuye a 3 el arreglo";
        //Ingresa las capitales
        ArregloCapitales[0] = "Aguascalientes";
        ArregloCapitales[1] = "Mexicali";
        ArregloCapitales[2] = "La Paz";
        ArregloCapitales[3] = "San Francisco de Campeche";
        ArregloCapitales[4] = "Chihuahua";
        ArregloCapitales[5] = "Tuxtla Gutiérrez";
        ArregloCapitales[6] = "Saltillo";
        ArregloCapitales[7] = "Colima";
        ArregloCapitales[8] = "Victoria Durango";
        ArregloCapitales[9] = "Guanajuato";
        ArregloCapitales[10] = "Chilpancingo de los Bravos";
        ArregloCapitales[11] = "Pachuca de Soto";
        ArregloCapitales[12] = "Guadalajara";
        ArregloCapitales[13] = "Toluca de Lerdo";
        ArregloCapitales[14] = "Morelia";
        ArregloCapitales[15] = "Cuernavaca";
        ArregloCapitales[16] = "Tepic";
        ArregloCapitales[17] = "Monterrey";
        ArregloCapitales[18] = "Oaxaca de Juárez";
        ArregloCapitales[19] = "Puebla de Zaragoza";
        ArregloCapitales[20] = "Santiago de Querétaro";
        ArregloCapitales[21] = "Chetumal";
        ArregloCapitales[22] = "San Luis Potosí";
        ArregloCapitales[23] = "Culiacán Rosales";
        ArregloCapitales[24] = "Hermosillo";
        ArregloCapitales[25] = "Villahermosa";
        ArregloCapitales[26] = "Ciudad Victoria";
        ArregloCapitales[27] = "Tlaxcala de Xicohténcatl";
        ArregloCapitales[28] = "Xalapa-Enríquez";
        ArregloCapitales[29] = "Mérida";
        ArregloCapitales[30] = "Zacatecas";
        ArregloCapitales[31] = "CDMX";
        ArregloCapitales[32] = "Disminuye a 3 el arreglo";

        //Cambia el valor del primer aleatorio y evita que se repita en la siguiente ronda
        ale1 = aleatorio.nextInt(ArregloEstados.length - 1);

        //Evita que los 3 aleatorios se repitan
        do {
            ale2 = aleatorio.nextInt(ArregloEstados.length - 1);
        } while (ale1 == ale2);

        do {
            ale3 = aleatorio.nextInt(ArregloEstados.length - 1);
        } while (ale3 == ale1 || ale3 == ale2);
    }
    //Cambia el orden de los TextView
    public void OrdenamientoAleatorio(){

        //Numero que decide el orden que tomaran (6 ordenamientos distintos)
        Integer ordenamientoA = aleatorio.nextInt(6);
        Integer ordenamientoB = aleatorio.nextInt(6);

        if (ordenamientoA==0){
            Estado1.setText(ArregloEstados[ale1]);
            Estado2.setText(ArregloEstados[ale2]);
            Estado3.setText(ArregloEstados[ale3]);
        }

        if(ordenamientoA==1){
            Estado1.setText(ArregloEstados[ale1]);
            Estado2.setText(ArregloEstados[ale3]);
            Estado3.setText(ArregloEstados[ale2]);
        }

        if(ordenamientoA==2){
            Estado1.setText(ArregloEstados[ale2]);
            Estado2.setText(ArregloEstados[ale1]);
            Estado3.setText(ArregloEstados[ale3]);
        }

        if(ordenamientoA==3){
            Estado1.setText(ArregloEstados[ale2]);
            Estado2.setText(ArregloEstados[ale3]);
            Estado3.setText(ArregloEstados[ale1]);
        }

        if(ordenamientoA==4){
            Estado1.setText(ArregloEstados[ale3]);
            Estado2.setText(ArregloEstados[ale1]);
            Estado3.setText(ArregloEstados[ale2]);
        }

        if(ordenamientoA==5){
            Estado1.setText(ArregloEstados[ale3]);
            Estado2.setText(ArregloEstados[ale2]);
            Estado3.setText(ArregloEstados[ale1]);
        }

        if(ordenamientoA==6){
            Estado1.setText(ArregloEstados[ale1]);
            Estado2.setText(ArregloEstados[ale2]);
            Estado3.setText(ArregloEstados[ale3]);
        }

        //Cambia el Texto por el de una capital y los ordena de la forma que indique el int ordenamientoB

        if (ordenamientoB==0){
            Capital1.setText(ArregloCapitales[ale1]);
            Capital2.setText(ArregloCapitales[ale2]);
            Capital3.setText(ArregloCapitales[ale3]);
        }

        if (ordenamientoB==1){
            Capital1.setText(ArregloCapitales[ale1]);
            Capital2.setText(ArregloCapitales[ale3]);
            Capital3.setText(ArregloCapitales[ale2]);
        }

        if (ordenamientoB==2){
            Capital1.setText(ArregloCapitales[ale2]);
            Capital2.setText(ArregloCapitales[ale1]);
            Capital3.setText(ArregloCapitales[ale3]);
        }

        if (ordenamientoB==3){
            Capital1.setText(ArregloCapitales[ale2]);
            Capital2.setText(ArregloCapitales[ale3]);
            Capital3.setText(ArregloCapitales[ale1]);
        }

        if (ordenamientoB==4){
            Capital1.setText(ArregloCapitales[ale3]);
            Capital2.setText(ArregloCapitales[ale1]);
            Capital3.setText(ArregloCapitales[ale2]);
        }

        if (ordenamientoB==5){
            Capital1.setText(ArregloCapitales[ale3]);
            Capital2.setText(ArregloCapitales[ale2]);
            Capital3.setText(ArregloCapitales[ale1]);
        }

        if (ordenamientoB==6){
            Capital1.setText(ArregloCapitales[ale1]);
            Capital2.setText(ArregloCapitales[ale2]);
            Capital3.setText(ArregloCapitales[ale3]);
        }
    }
    //Aumenta la variable SeGano
    public void AumentaSeGano(){
        SeGano ++;
    }
    //Verifica que los TextView esten vacios
    public  void VerificarTV(){
        //Si SeGano 3 veces los valores estaran vacios
        if (SeGano == 3){
            //Se llenara de nuevo
            LLenaLosArreglos();
            OrdenamientoAleatorio();
            //Reiniciara la varable de SeGano a 0
            SeGano = 0;
        }
    }
    //Finaliza el Activiti principal
    public void FinalizaActivity(){
        if (Vidas == 0){
            //Evita el doble clic al finalizar la actividad
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return; }
            mLastClickTime = SystemClock.elapsedRealtime();

            registrarUsuariosSQL();

            Intent i = new Intent(this, SegundaActividad.class);
            i.putExtra("MandarPuntos", Puntos.toString());
            startActivity(i);
            //termina la actividad para que no se pueda regresar
            finish();
        }
    }
    //Cambia el color de los botones a anaranjado
    public void BotonesAnaranjados() {
        BE1.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_redondo));
        BE2.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_redondo));
        BE3.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_redondo));
        BC1.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_redondo));
        BC2.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_redondo));
        BC3.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_redondo));
    }
    //Inicia las vidas
    public void IniciaVidas() {
        //TotalVidas.setText("Vidas: "+Vidas);
        if (Vidas == 3){
            TotalVidas.setText("\uD83E\uDDE1️  ️ \uD83E\uDDE1️️   \uD83E\uDDE1️");
        }
        if (Vidas == 2){
            TotalVidas.setText("\uD83D\uDDA4   ️\uD83E\uDDE1️   \uD83E\uDDE1️");
        }
        if (Vidas == 1){
            TotalVidas.setText("\uD83D\uDDA4   \uD83D\uDDA4   \uD83E\uDDE1️");
        }

    }
    //Guarda en la base de datos, se usa en el metodo FinalizaActivity
    private void registrarUsuariosSQL() {
        //abre la base de datos para escritura
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        String insert = "INSERT INTO " + Utilidades.TABLA_PUNTOSUSUARIO
                + "("
                + Utilidades.CAMPO_MARCADOR + ")"
                + "VALUES (" + Puntos + ")" ;

        db.execSQL(insert);

        db.close();
    }
}