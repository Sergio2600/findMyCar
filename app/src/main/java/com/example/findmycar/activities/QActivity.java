package com.example.findmycar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.findmycar.R;

public class QActivity extends AppCompatActivity {

    private int id_respuestas[] = {
            R.id.respuesta1, R.id.respuesta2, R.id.respuesta3,
            R.id.respuesta4
    };
    private int preguntaActual;
    private String[] preguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qactivity);


        preguntas = getResources().getStringArray(R.array.preguntas);
        preguntaActual = 0;

//Mete los strings en la activity
        enseñarPreguntas();


//Controles de los botones
//TODO Que vaya enviando los datos a algún lado y que al acabar pase a la pestaña de resultados
        Button btn1,btn2,btn3,btn4;

        btn1 = (Button) findViewById(R.id.respuesta1);
        btn2 = (Button) findViewById(R.id.respuesta2);
        btn3 = (Button) findViewById(R.id.respuesta3);
        btn4 = (Button) findViewById(R.id.respuesta4);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                preguntaActual++;
                enseñarPreguntas();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                preguntaActual++;
                enseñarPreguntas();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                preguntaActual++;
                enseñarPreguntas();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                preguntaActual++;
                enseñarPreguntas();
            }
        });



    }







    private void enseñarPreguntas() {
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