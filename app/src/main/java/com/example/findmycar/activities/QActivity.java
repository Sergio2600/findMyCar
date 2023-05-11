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
    private String[] preguntas;
    private  Button btn1,btn2,btn3,btn4;

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
//TODO la idea es que esto haga que al llegar a la última pregunta pase a la activity "Resultados" pero no va....
                if(preguntaActual+1 < preguntas.length) {
                    preguntaActual++;
                    ensenarPreguntas();
                }else {
                    Intent intent = new Intent(QActivity.this, ResultadosActivity.class);
                    startActivity(intent);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(preguntaActual+1 < preguntas.length) {
                    preguntaActual++;
                    ensenarPreguntas();
                }else {
                    Intent intent = new Intent(QActivity.this, ResultadosActivity.class);
                    startActivity(intent);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(preguntaActual+1 < preguntas.length) {
                    preguntaActual++;
                    ensenarPreguntas();
                }else {
                    Intent intent = new Intent(QActivity.this, ResultadosActivity.class);
                    startActivity(intent);
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(preguntaActual+1 < preguntas.length) {
                    preguntaActual++;
                    ensenarPreguntas();
                }else {
                    Intent intent = new Intent(QActivity.this, ResultadosActivity.class);
                    startActivity(intent);
                }
            }
        });



    }







    private void ensenarPreguntas() {
//Partir el strign en trozos
        String p0 = preguntas[preguntaActual];
        String[] partes = p0.split(";");
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