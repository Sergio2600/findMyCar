package com.example.findmycar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.findmycar.R;

public class QActivity extends AppCompatActivity {

    private int id_respuestas[] = {
            R.id.respuesta1, R.id.respuesta2, R.id.respuesta3,
            R.id.respuesta4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qactivity);

//Mete los strings en la activity
//La posición 0 del array siempre será la pregunta
        String[] stringPregunta = getResources().getStringArray(R.array.pregunta1);

        TextView Quest = (TextView) findViewById(R.id.Quest);
        Quest.setText(stringPregunta[0]);

//Recorre el array metiendo las stringPregunta
        for (int i = 0; i < id_respuestas.length; i++){
            Button respuesta = (Button) findViewById(id_respuestas[i]);
            respuesta.setText(stringPregunta[i+1]);
        }

    }
}