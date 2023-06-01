package com.example.findmycar.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.findmycar.R;

import java.util.Locale;

public class ResultadoAdapter extends BaseAdapter {
    private Context context;
    private String[][] resultados;

    public ResultadoAdapter(Context context, String[][] resultados) {
        this.context = context;
        this.resultados = resultados;
    }

    @Override
    public int getCount() {
        return resultados.length;
    }

    @Override
    public Object getItem(int position) {
        return resultados[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_resultados, parent, false);
        }

        String[] resultado = resultados[position];
        String ficheroImagen;

        TextView textViewMarca = convertView.findViewById(R.id.textViewMarca);
        TextView textViewModelo = convertView.findViewById(R.id.textViewModelo);
        TextView textViewPrecio = convertView.findViewById(R.id.textViewPrecio);
        // añadimos imagenes de coches
        ImageView imageView = convertView.findViewById(R.id.imagenCoche);

        textViewMarca.setText(resultado[1]); // Marca
        textViewModelo.setText(resultado[2] + " " + resultado[3]); // Modelo
        textViewPrecio.setText(resultado[4] + "€"); // Precio
        ficheroImagen = resultado[1].replace(" ","_")+"_" + resultado[2].replace(" ","_");
        ficheroImagen = ficheroImagen.replace(" ","");
        ficheroImagen = ficheroImagen.toLowerCase(Locale.ROOT);
        //sacamos el id de la imagen
        System.out.println(ficheroImagen);
        int resourceId = context.getResources().getIdentifier(ficheroImagen,"mipmap",context.getPackageName());
        System.out.println(resourceId);
        imageView.setImageResource(resourceId);


        return convertView;
    }
}