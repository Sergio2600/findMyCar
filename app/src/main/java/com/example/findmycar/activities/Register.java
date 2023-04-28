package com.example.findmycar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.findmycar.R;
import com.example.findmycar.activities.db.ControladorDB;
import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {
    //objeto controladorDB
    ControladorDB controladorDB = new ControladorDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

    }

    //para crear un usuario nuevo
    public void crearCuentaUsuario(View view){
        TextInputEditText usuario = (TextInputEditText) findViewById(R.id.cajaUsuarioRegistro);
        TextInputEditText pass = (TextInputEditText) findViewById(R.id.cajaPassRegistro);

        controladorDB.registrarUsuario(usuario.getText().toString(),pass.getText().toString());
        Toast toast = Toast.makeText(this,"Usuario registrado correctamente",Toast.LENGTH_LONG);
        toast.show();


    }
}