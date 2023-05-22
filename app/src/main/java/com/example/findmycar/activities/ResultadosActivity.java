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
    }
}
