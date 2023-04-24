package com.example.findmycar.activities.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ControladorDB extends SQLiteOpenHelper {

    public ControladorDB(@Nullable Context context) {
        super(context, "com.example.findmycar.activities.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USUARIOS (ID INTEGER PRIMARY KEY AUTOINCREMENT, USUARIO TEXT NOT NULL, PASSWORD TEXT NOT NULL);");
        //db.execSQL("CREATE TABLE TAREAS (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT NOT NULL, IDUSUARIO INTEGER NOT NULL ,FOREIGN KEY (ID) REFERENCES USUARIOS(ID));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    // comprobamos usuario y contraseña en bbdd
    public boolean comprobarContraseña(String usuario, String contraseña){

        // abrimos base de datos
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("Select * FROM  USUARIOS  WHERE  USUARIO  = ? AND password  = ?",new String[]{usuario,contraseña});
        int regs = cursor.getCount();

        if(regs == 0){
            cursor.close();
            return false;
        }
        else{
            cursor.close();
            return true;
        }
    }

    public String obtenerId(String usuario){

        // abrimos base de datos
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("Select ID FROM  USUARIOS  WHERE  USUARIO=?",new String[]{String.valueOf(usuario)});
        cursor.moveToFirst();

        return cursor.getString(0);
    }

    public boolean existeUsuario(String usuario){
        // abrimos base de datos
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("Select * FROM  USUARIOS  WHERE  USUARIO = ?",new String[]{String.valueOf(usuario)});
        int regs = cursor.getCount();


        if(regs == 0){
            cursor.close();
            return false;
        }
        else{
            cursor.close();
            return true;
        }
    }

    public void registrarUsuario(String usuario, String pass){
        //para rellenar el campo que queremos
        ContentValues registro = new ContentValues();
        registro.put("USUARIO",usuario);
        registro.put("PASSWORD",pass);

        //abrimos la basa de datos para lectura y escritura
        SQLiteDatabase db = this.getWritableDatabase();
        //añadimos un registro a la tabla
        db.insert("USUARIOS",null,registro);

        db.close();
    }
}

