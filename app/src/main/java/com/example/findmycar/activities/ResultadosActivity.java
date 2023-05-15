package com.example.findmycar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.findmycar.R;

public class ResultadosActivity extends AppCompatActivity {

    Intent intent = getIntent();
    private String valorPrecio = intent.getStringExtra("precio");
    private String tipoCarroceria = intent.getStringExtra("carroceria");
    private String tipoCombustible = intent.getStringExtra("combustible");
    private String valorPotencia = intent.getStringExtra("potencia");
    private String numeroPlazas = intent.getStringExtra("plazas");
    private String valorMaletero = intent.getStringExtra("maletero");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);




    }
}