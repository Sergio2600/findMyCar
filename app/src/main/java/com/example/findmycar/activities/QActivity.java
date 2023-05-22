package com.example.findmycar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.findmycar.R;

public class QActivity extends AppCompatActivity {

    private int id_respuestas[] = {
            R.id.respuesta1, R.id.respuesta2, R.id.respuesta3,
            R.id.respuesta4, R.id.respuesta5, R.id.respuesta6
    };
    private int preguntaActual;
    private String p0;
    private String[] preguntas, partes;
    private  Button btn1,btn2,btn3,btn4, btn5, btn6;
    private String valorPrecio, tipoCarroceria, tipoCombustible, valorPotencia, tipoDistintivo, valorMaletero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
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
        btn5 = (Button) findViewById(R.id.respuesta5);
        btn6 = (Button) findViewById(R.id.respuesta6);

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
                        tipoDistintivo = partes[1];
                        break;
                    case 5:
                        valorMaletero = partes[1];
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
                    intent.putExtra("distintivo", tipoDistintivo);
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
                        tipoDistintivo = partes[2];
                        break;
                    case 5:
                        valorMaletero = partes[2];
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
                    intent.putExtra("distintivo", tipoDistintivo);
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
                        tipoDistintivo = partes[3];
                        break;
                    case 5:
                        valorMaletero = partes[3];
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
                    intent.putExtra("distintivo", tipoDistintivo);
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
                        tipoDistintivo = partes[4];
                        break;
                    case 5:
                        valorMaletero = partes[4];
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
                    intent.putExtra("distintivo", tipoDistintivo);
                    intent.putExtra("maletero", valorMaletero);
                    startActivity(intent);
                }
            }

        });
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (preguntaActual) {
                    case 0:
                        valorPrecio = partes[5];
                        break;
                    case 1:
                        tipoCarroceria = partes[5];
                        break;
                    case 2:
                        tipoCombustible = partes[5];
                        break;
                    case 3:
                        valorPotencia = partes[5];
                        break;
                    case 4:
                        tipoDistintivo = partes[5];
                        break;
                    case 5:
                        valorMaletero = partes[5];
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
                    intent.putExtra("distintivo", tipoDistintivo);
                    intent.putExtra("maletero", valorMaletero);
                    startActivity(intent);
                }
            }

        });
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (preguntaActual) {
                    case 0:
                        valorPrecio = partes[6];
                        break;
                    case 1:
                        tipoCarroceria = partes[6];
                        break;
                    case 2:
                        tipoCombustible = partes[6];
                        break;
                    case 3:
                        valorPotencia = partes[6];
                        break;
                    case 4:
                        tipoDistintivo = partes[6];
                        break;
                    case 5:
                        valorMaletero = partes[6];
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
                    intent.putExtra("distintivo", tipoDistintivo);
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

// Ocultar las preguntas no utilizadas
        int numRespuestas = partes.length - 1;

        switch (numRespuestas) {
            case 2: // 2 respuestas
                btn3.setVisibility(View.GONE);
                btn4.setVisibility(View.GONE);
                btn5.setVisibility(View.GONE);
                btn6.setVisibility(View.GONE);
                break;
            case 3: // 3 respuestas
                btn4.setVisibility(View.GONE);
                btn5.setVisibility(View.GONE);
                btn6.setVisibility(View.GONE);
                break;
            case 5: //4 respuestas
                //btn5.setVisibility(View.GONE);
                //btn6.setVisibility(View.GONE);
            case 4: // 4 respuestas
                btn5.setVisibility(View.GONE);
                btn6.setVisibility(View.GONE);
                break;
           // case 5: // 5 respuestas
              //  btn6.setVisibility(View.GONE);
               // break;
            case 6: // 6 respuestas
                // No es necesario ocultar ningún botón
                break;
        }

//el partes[0] siempre será la pregunta
        TextView Quest = (TextView) findViewById(R.id.Quest);
        Quest.setText(partes[0]);

//Recorre el array metiendo las respuestas
        for (int i = 0; i < numRespuestas; i++){
            Button respuesta = (Button) findViewById(id_respuestas[i]);
            respuesta.setText(partes[i+1]);
        }
    }
}