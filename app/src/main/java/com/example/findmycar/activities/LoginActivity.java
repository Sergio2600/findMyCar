package com.example.findmycar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.findmycar.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        //creamos el boton para que nos lleve a la pantalla register
        Button botonRegistrar = findViewById(R.id.botonCrearCuenta);
        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,Register.class);
                startActivity(intent);
            }
        });
    }
    public void login(View view) {
        //creamos dos variables la cual hay que hacer un casting para que devuelva un TextInputEditText
        EditText usuario = (EditText) findViewById(R.id.cajausuario);
        EditText pass = (EditText) findViewById(R.id.cajapass);

        if(usuario.getText().toString().length()==0 || pass.getText().toString().length()==0){
            Toast toast = Toast.makeText(this,"hay algun campo vacio",Toast.LENGTH_LONG);
            toast.show();
        }else {//comparamos el contenido de las cajas

        }


    }
}