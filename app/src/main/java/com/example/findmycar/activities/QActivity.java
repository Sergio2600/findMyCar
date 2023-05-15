package com.example.findmycar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.findmycar.R;

public class QActivity extends AppCompatActivity {

    private int id_respuestas[] = {
            R.id.respuesta1, R.id.respuesta2, R.id.respuesta3,
            R.id.respuesta4
    };
    private int preguntaActual;
    private String p0;
    private String[] preguntas, partes;
    private  Button btn1,btn2,btn3,btn4;
    private String valorPrecio, tipoCarroceria, tipoCombustible, valorPotencia, numeroPlazas, valorMaletero, nada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qactivity);


        preguntas = getResources().getStringArray(R.array.preguntas);
        preguntaActual = 0;

//Mete los strings en la activity
        ensenarPreguntas();

//Controles de los botones
        btn1 = (Button) findViewById(R.id.respuesta1);
        btn2 = (Button) findViewById(R.id.respuesta2);
        btn3 = (Button) findViewById(R.id.respuesta3);
        btn4 = (Button) findViewById(R.id.respuesta4);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//TODO SIN COMPROBAR he hecho que el pulsar cada botón, lo primero que haga es  meter lo que has respondido en una variable-->
//-->(Con el switch compara el valor de la pregunta actual, para saber en qué variable tiene que meter el dato respondido)-->
//--> para luego en el intent pasar la información a la siguiente activity.
//Me preocupa que pueda acceder a "partes[]" porque se hace en un método abajo, pero por eso lo he creado ahí arriba  con un private.....
//HABRIA QUE CONVERTIR LOS NUMEROS A INT???
                switch (preguntaActual) {
                    case 0:
                        valorPrecio = partes[1];
                        break;
                    case 1:
                        tipoCarroceria = partes[1];
                        break;
                    case 2:
                        tipoCombustible = partes[1];
                        break;
                    case 3:
                        valorPotencia = partes[1];
                        break;
                    case 4:
                        numeroPlazas = partes[1];
                        break;
                    case 5:
                        valorMaletero = partes[1];
                        break;
                    case 6:
                        nada = partes[4];
                        break;
                }
                if(preguntaActual+1 < preguntas.length) {
                    preguntaActual++;
                    ensenarPreguntas();
                }else {
                    Intent intent = new Intent(QActivity.this, ResultadosActivity.class);
                    intent.putExtra("precio", valorPrecio);
                    intent.putExtra("carroceria", tipoCarroceria);
                    intent.putExtra("combustible", tipoCombustible);
                    intent.putExtra("potencia", valorPotencia);
                    intent.putExtra("plazas", numeroPlazas);
                    intent.putExtra("maletero", valorMaletero);
                    startActivity(intent);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (preguntaActual) {
                    case 0:
                        valorPrecio = partes[2];
                        break;
                    case 1:
                        tipoCarroceria = partes[2];
                        break;
                    case 2:
                        tipoCombustible = partes[2];
                        break;
                    case 3:
                        valorPotencia = partes[2];
                        break;
                    case 4:
                        numeroPlazas = partes[2];
                        break;
                    case 5:
                        valorMaletero = partes[2];
                        break;
                    case 6:
                        nada = partes[4];
                        break;
                }
                if(preguntaActual+1 < preguntas.length) {
                    preguntaActual++;
                    ensenarPreguntas();
                }else {
                    Intent intent = new Intent(QActivity.this, ResultadosActivity.class);
                    intent.putExtra("precio", valorPrecio);
                    intent.putExtra("carroceria", tipoCarroceria);
                    intent.putExtra("combustible", tipoCombustible);
                    intent.putExtra("potencia", valorPotencia);
                    intent.putExtra("plazas", numeroPlazas);
                    intent.putExtra("maletero", valorMaletero);
                    startActivity(intent);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                switch (preguntaActual) {
                    case 0:
                        valorPrecio = partes[3];
                        break;
                    case 1:
                        tipoCarroceria = partes[3];
                        break;
                    case 2:
                        tipoCombustible = partes[3];
                        break;
                    case 3:
                        valorPotencia = partes[3];
                        break;
                    case 4:
                        numeroPlazas = partes[3];
                        break;
                    case 5:
                        valorMaletero = partes[3];
                        break;
                    case 6:
                        nada = partes[4];
                        break;
                }
                if(preguntaActual+1 < preguntas.length) {
                    preguntaActual++;
                    ensenarPreguntas();
                }else {
                    Intent intent = new Intent(QActivity.this, ResultadosActivity.class);
                    intent.putExtra("precio", valorPrecio);
                    intent.putExtra("carroceria", tipoCarroceria);
                    intent.putExtra("combustible", tipoCombustible);
                    intent.putExtra("potencia", valorPotencia);
                    intent.putExtra("plazas", numeroPlazas);
                    intent.putExtra("maletero", valorMaletero);
                    startActivity(intent);
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (preguntaActual) {
                    case 0:
                        valorPrecio = partes[4];
                        break;
                    case 1:
                        tipoCarroceria = partes[4];
                        break;
                    case 2:
                        tipoCombustible = partes[4];
                        break;
                    case 3:
                        valorPotencia = partes[4];
                        break;
                    case 4:
                        numeroPlazas = partes[4];
                        break;
                    case 5:
                        valorMaletero = partes[4];
                        break;
                    case 6:
                        nada = partes[4];
                        break;
                }
                if(preguntaActual+1 < preguntas.length) {
                    preguntaActual++;
                    ensenarPreguntas();
                }else {
                    Intent intent = new Intent(QActivity.this, ResultadosActivity.class);
                    intent.putExtra("precio", valorPrecio);
                    intent.putExtra("carroceria", tipoCarroceria);
                    intent.putExtra("combustible", tipoCombustible);
                    intent.putExtra("potencia", valorPotencia);
                    intent.putExtra("plazas", numeroPlazas);
                    intent.putExtra("maletero", valorMaletero);
                    startActivity(intent);
                }
            }
        });



    }


    private void ensenarPreguntas() {
//Partir el strign en trozos
        p0 = preguntas[preguntaActual];
        partes = p0.split(";");
//el partes 0 siempre será la pregunta
        TextView Quest = (TextView) findViewById(R.id.Quest);
        Quest.setText(partes[0]);

//Recorre el array metiendo las preguntas
        for (int i = 0; i < id_respuestas.length; i++){
            Button respuesta = (Button) findViewById(id_respuestas[i]);
            respuesta.setText(partes[i+1]);
        }
    }
}