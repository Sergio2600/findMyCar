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
    public boolean comprobarContraseña(String usuario, String contraseña) {

        // abrimos base de datos
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("Select * FROM  USUARIOS  WHERE  USUARIO  = ? AND password  = ?", new String[]{usuario, contraseña});
        int regs = cursor.getCount();

        if (regs == 0) {
            cursor.close();
            return false;
        } else {
            cursor.close();
            return true;
        }
    }

    public String obtenerId(String usuario) {

        // abrimos base de datos
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("Select ID FROM  USUARIOS  WHERE  USUARIO=?", new String[]{String.valueOf(usuario)});
        cursor.moveToFirst();

        return cursor.getString(0);
    }

    public boolean existeUsuario(String usuario) {
        // abrimos base de datos
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("Select * FROM  USUARIOS  WHERE  USUARIO = ?", new String[]{String.valueOf(usuario)});
        int regs = cursor.getCount();


        if (regs == 0) {
            cursor.close();
            return false;
        } else {
            cursor.close();
            return true;
        }
    }

    public void registrarUsuario(String usuario, String pass) {
        //para rellenar el campo que queremos
        ContentValues registro = new ContentValues();
        registro.put("USUARIO", usuario);
        registro.put("PASSWORD", pass);

        //abrimos la basa de datos para lectura y escritura
        SQLiteDatabase db = this.getWritableDatabase();
        //añadimos un registro a la tabla
        db.insert("USUARIOS", null, registro);

        db.close();
    }

    public String[][] buscar(String respuestas[]) {
        //abrimos la basa de datos para lectura y escritura
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM COCHES WHERE ";
        switch (respuestas[0]) {
            case "7.000€-20.000€":
                sql = sql + " (PRECIO >= '7000' AND PRECIO <= '20000') ";
                break;
            case "20.000€-45.000€":
                sql = sql + " (PRECIO > '20000' AND PRECIO <= '45000') ";
                break;
            case "45.000€-70.000€":
                sql = sql + " (PRECIO > '45000' AND PRECIO <= '70000') ";
                break;
            case "70.000€-100.000€":
                sql = sql + " (PRECIO > '70000' AND PRECIO <= '100000') ";
                break;
            case "100.000€-150.000€":
                sql = sql + " (PRECIO > '100000' AND PRECIO <= '150000') ";
                break;
            case "+150.000€":
                sql = sql + " (PRECIO > '150000') ";
        }
        switch (respuestas[1]) {
            case "Berlina":
                sql = sql + " AND (TIPO_CARROCERIA = '1') ";
                break;
            case "Cabrio":
                sql = sql + " AND (TIPO_CARROCERIA = '2') ";
                break;
            case "Coupe":
                sql = sql + " AND (TIPO_CARROCERIA = '3') ";
                break;
            case "Familiar":
                sql = sql + " AND (TIPO_CARROCERIA = '4') ";
                break;
            case "Monovolumen":
                sql = sql + " AND (TIPO_CARROCERIA = '5') ";
                break;
            case "SUV/4x4":
                sql = sql + " AND (TIPO_CARROCERIA = '6') ";
                break;
        }
        switch (respuestas[2]) {
            case "Gasolina":
                sql = sql + " AND (COMBUSTIBLE = '1') ";
                break;
            case "Diesel":
                sql = sql + " AND (COMBUSTIBLE = '2') ";
                break;
            case "Híbrido":
                sql = sql + " AND (COMBUSTIBLE = '3') ";
                break;
            case "Eléctrico":
                sql = sql + " AND (COMBUSTIBLE = '4') ";
                break;
        }
        switch (respuestas[3]) {
            case "Menos de 90cv":
                sql = sql + " AND (POTENCIA AND POTENCIA < '90') ";
                break;
            case "90cv-130cv":
                sql = sql + " AND (POTENCIA >= '90' AND POTENCIA <= '130') ";
                break;
            case "130cv-200cv":
                sql = sql + " AND (POTENCIA > '130' AND POTENCIA <= '200') ";
                break;
            case "200cv-300cv":
                sql = sql + " AND (POTENCIA > '200' AND POTENCIA <= '300') ";
                break;
            case "300cv-450cv":
                sql = sql + " AND (POTENCIA > '300' AND POTENCIA <= '450') ";
                break;
            case "Más de 450cv":
                sql = sql + " AND (POTENCIA > '450') ";
                break;
        }
        switch (respuestas[4]) {
            case "ECO":
                sql = sql + " AND (ETIQUETA = '1') ";
                break;
            case "0":
                sql = sql + " AND (ETIQUETA = '2') ";
                break;
            case "B":
                sql = sql + " AND (ETIQUETA = '3') ";
                break;
            case "C":
                sql = sql + " AND (ETIQUETA = '4') ";
                break;
        }
        switch (respuestas[5]) {
            case "Cualquiera":
                break;
            case "1 maleta (120 litros)":
                sql = sql + " AND (CAPACIDAD_MALETERO >= '120') ";
                break;
            case "2 maletas (240 litros)":
                sql = sql + " AND (CAPACIDAD_MALETERO >= '240') ";
                break;
            case "4 maletas (480 litros)":
                sql = sql + " AND (CAPACIDAD_MALETERO >= '480') ";
                break;
            case "Más de 5 maletas (600 litros)":
                sql = sql + " AND (CAPACIDAD_MALETERO >= '600') ";
                break;
        }
        sql = sql + " order by precio ";
        System.out.println(sql);
        //y creamos la clase cursor por el select que es un conjunto de registros
        Cursor cursor = db.rawQuery(sql, null);

        //para saber cuantos registros hay en la tabla
        int regs = cursor.getCount();
        //si el numero de registros es cero cerramos la base de datos sino es 0 recorremos los registros
        if (regs == 0) {
            db.close();
            return null;
        } else {
            int totalFilas = cursor.getCount();
            int totalColumnas = cursor.getColumnCount();
            String[][] coches = new String[totalFilas][totalColumnas];
            //cursor.moveToFirst();//nos movemos al primer registro
            int fila = 0;
            while (cursor.moveToNext()) {
                for (int columna = 0; columna < totalColumnas; columna++) {
                    String coche = cursor.getString(columna);
                    coches[fila][columna] = coche;
                }
                fila++;
            }
            db.close();
            return coches;
        }
    }
}






