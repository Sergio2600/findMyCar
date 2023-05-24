package com.example.findmycar.activities.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "coches";
    private static final int DATABASE_VERSION = 1;
    private Context context;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        executeSqlFromFile(db, "coches");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }

    private void executeSqlFromFile(SQLiteDatabase db, String fileName) {
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                if (line.endsWith(";")) {
                    db.execSQL(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // comprobamos usuario y contraseña en bbdd
    public boolean comprobarContraseña(String usuario, String contraseña){

        // abrimos base de datos
        SQLiteDatabase db = getReadableDatabase();

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

    public void buscar(){
        //
        String sql = "SELECT * FROM COCHES WHERE (PRECIO >= 20000 AND PRECIO <= 40000) AND ";
        sql = sql + "(TIPO_CARROCERIA = '1') AND (COMBUSTIBLE = '1') AND (POTENCIA >= 180 AND POTENCIA <= 300) ";
        sql = sql + "AND (CAPACIDAD_MALETERO >= 240) order by precio";
    }
}