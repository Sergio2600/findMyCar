package com.example.findmycar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.findmycar.R;

public class FichaCoche extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_coche);
        Intent intent = getIntent();
        String marca = intent.getStringExtra("marca");
        String modelo = intent.getStringExtra("modelo");
        String precio = intent.getStringExtra("precio");
        String cilindrada = intent.getStringExtra("cilindrada");
        String combustible = intent.getStringExtra("combustible");
        String potencia = intent.getStringExtra("potencia");
        String traccion = intent.getStringExtra("traccion");
        String consumo = intent.getStringExtra("consumo");
        String etiqueta = intent.getStringExtra("etiqueta");
        String cambio = intent.getStringExtra("cambio");
        String carroceria = intent.getStringExtra("carroceria");
        String maletero = intent.getStringExtra("maletero");
        int imagen = intent.getIntExtra("imagen",0);

        ImageView imageView = findViewById(R.id.imagenFichaCoche);
        imageView.setImageResource(imagen);
        TextView textViewMarca = findViewById(R.id.marcaFicha);
        textViewMarca.setText(marca);
        TextView textViewModelo = findViewById(R.id.modeloFicha);
        textViewModelo.setText(modelo);
        TextView textViewPrecio = findViewById(R.id.precioFicha);
        textViewPrecio.setText(precio + "€");
        TextView textViewCilindrada = findViewById(R.id.textoCilindrada);
        textViewCilindrada.setText(cilindrada);
        TextView textViewCombustible = findViewById(R.id.textoCombustible);
        textViewCombustible.setText(combustible);
        TextView textViewPotencia = findViewById(R.id.textoPotencia);
        textViewPotencia.setText(potencia + " cv");
        TextView textViewTraccion = findViewById(R.id.textoTraccion);
        textViewTraccion.setText(traccion);
        TextView textViewConsumo = findViewById(R.id.textoConsumo);
        textViewConsumo.setText(consumo + " l/100");
        ImageView imagenEtiqueta = findViewById(R.id.imagenEtiqueta);
        switch (etiqueta){
            case "1":
                imagenEtiqueta.setImageResource(R.mipmap.pegatina_eco);
                break;
            case "2":
                imagenEtiqueta.setImageResource(R.mipmap.pegatina_0);
                break;
            case "3":
                imagenEtiqueta.setImageResource(R.mipmap.pegatina_b);
                break;
            case "4":
                imagenEtiqueta.setImageResource(R.mipmap.pegatina_c);
                break;
        }
        TextView textViewCambio = findViewById(R.id.textoTipoCambio);
        textViewCambio.setText(cambio);
        TextView textViewCarroceria = findViewById(R.id.textoTipoCarroceria);
        textViewCarroceria.setText(carroceria);
        TextView textViewMaletero = findViewById(R.id.textoCapacidadMaletero);
        textViewMaletero.setText(maletero + " l");
    }
}
