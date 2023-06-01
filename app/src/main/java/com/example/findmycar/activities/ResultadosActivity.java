package com.example.findmycar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


import com.example.findmycar.R;
import com.example.findmycar.activities.db.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ResultadosActivity extends AppCompatActivity {

    MyDatabaseHelper controladorDB = new MyDatabaseHelper(this);
    private String valorPrecio, tipoCarroceria, tipoCombustible, valorPotencia, tipoDistintivo, valorMaletero;

    //Esto da problemas, no está bien hehco
    //MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
    //SQLiteDatabase db = dbHelper.getReadableDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        valorPrecio = intent.getStringExtra("precio");
        tipoCarroceria = intent.getStringExtra("carroceria");
        tipoCombustible = intent.getStringExtra("combustible");
        valorPotencia = intent.getStringExtra("potencia");
        tipoDistintivo = intent.getStringExtra("distintivo");
        valorMaletero = intent.getStringExtra("maletero");

        //ponemos las respuestas en un array
        String[] respuestas = {valorPrecio,tipoCarroceria,tipoCombustible,valorPotencia,tipoDistintivo,valorMaletero};
        // comprobamos que el array de respuestas no esté vacio y que la consulta devuelva algun resultado
        if (respuestas != null && respuestas.length > 0 && controladorDB.buscar(respuestas) != null) {
                /* cargamos los datos obtenidos en la pantalla en un listview
                 usando la clase auxiliar ResultadoAdapter */
                ListView listView = findViewById(R.id.listViewOpciones);
                ResultadoAdapter adapter = new ResultadoAdapter(this, controladorDB.buscar(respuestas));
                listView.setAdapter(adapter);
             // mostramos un texto si se han encontrado coches
            TextView textViewError = findViewById(R.id.textViewError);
            textViewError.setVisibility(View.VISIBLE);
            textViewError.setText("Estos son los vehiculos que hemos encontrado con tus filtros:");
        } else {
            // si no hay resultados ponemos otro texto
            TextView textViewError = findViewById(R.id.textViewError);
            textViewError.setVisibility(View.VISIBLE);
            textViewError.setText("No se han encontrado coches con esos filtros, intente con otros filtros");
        }
    }
}
