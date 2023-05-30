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

        String[] respuestas = {valorPrecio,tipoCarroceria,tipoCombustible,valorPotencia,tipoDistintivo,valorMaletero};
        if (respuestas != null && respuestas.length > 0 && controladorDB.buscar(respuestas) != null) {
                ListView listView = findViewById(R.id.listViewOpciones);
                ResultadoAdapter adapter = new ResultadoAdapter(this, controladorDB.buscar(respuestas));
                listView.setAdapter(adapter);
        } else {
            TextView textViewError = findViewById(R.id.textViewError);
            textViewError.setVisibility(View.VISIBLE);
            textViewError.setText("No se han encontrado coches con esos filtros, intente con otros filtros");
        }


//TODO Por ahora no funciona, revisar conexión con bbdd conociendola
        /*
//Consulta para comparar los datos que tenía con los de las base de datos para ver qué coche coger
        String tableName = "coches";
        String[] projection = {"nombre", "imagen"};
        String selection = "precio = ? AND carroceria = ? AND combustible = ? AND potencia = ? AND distintivo = ? AND maletero = ?";
        String[] selectionArgs = {valorPrecio, tipoCarroceria, tipoCombustible, valorPotencia, tipoDistintivo, valorMaletero};

        Cursor cursor = db.query(tableName, projection, selection, selectionArgs, null, null, null);


//Meter datos de la consulta en una lista

        List<String> nombresCoches = new ArrayList<>();
        List<Integer> imagenesCoches = new ArrayList<>();

        while (cursor.moveToNext()) {
            String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
            int imagen = cursor.getInt(cursor.getColumnIndexOrThrow("imagen"));

            nombresCoches.add(nombre);
            imagenesCoches.add(imagen);
        }

//Utilizar los datos obtenidos para mostrarlos en el layout

        TextView textView1 = findViewById(R.id.textView1);
        ImageView imageView1 = findViewById(R.id.imageView1);
        textView1.setText(nombresCoches.get(0));
        imageView1.setImageResource(imagenesCoches.get(0));

        TextView textView2 = findViewById(R.id.textView2);
        ImageView imageView2 = findViewById(R.id.imageView2);
        textView2.setText(nombresCoches.get(1));
        imageView2.setImageResource(imagenesCoches.get(1));

        TextView textView3 = findViewById(R.id.textView3);
        ImageView imageView3 = findViewById(R.id.imageView3);
        textView3.setText(nombresCoches.get(2));
        imageView3.setImageResource(imagenesCoches.get(2));


*/

    }
}
