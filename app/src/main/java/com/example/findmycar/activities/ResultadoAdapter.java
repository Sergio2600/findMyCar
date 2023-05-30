package com.example.findmycar.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.findmycar.R;

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

        if(resultado[1] != null && resultado[2] != null && resultado[3] != null && resultado[4] != null){
            TextView textViewMarca = convertView.findViewById(R.id.textViewMarca);
            TextView textViewModelo = convertView.findViewById(R.id.textViewModelo);
            TextView textViewPrecio = convertView.findViewById(R.id.textViewPrecio);

            textViewMarca.setText(resultado[1]); // Marca
            textViewModelo.setText(resultado[2] + " " + resultado[3]); // Modelo
            textViewPrecio.setText(resultado[4] + "€"); // Precio


        }
        return convertView;
    }
}