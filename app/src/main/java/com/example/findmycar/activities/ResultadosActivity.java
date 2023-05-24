package com.example.findmycar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.findmycar.R;

public class ResultadosActivity extends AppCompatActivity {

    private String valorPrecio, tipoCarroceria, tipoCombustible, valorPotencia, tipoDistintivo, valorMaletero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        Intent intent = getIntent();
        valorPrecio = intent.getStringExtra("precio");
        tipoCarroceria = intent.getStringExtra("carroceria");
        tipoCombustible = intent.getStringExtra("combustible");
        valorPotencia = intent.getStringExtra("potencia");
        tipoDistintivo = intent.getStringExtra("distintivo");
        valorMaletero = intent.getStringExtra("maletero");

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
