package com.example.findmycar.activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.findmycar.R;

import java.util.Locale;

//clase para cargar la base de datos en la pantalla resultados
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

        // cargamos los datos y la imagen en pantalla a un diseño predefinido en activity_resultados
        TextView textViewMarca = convertView.findViewById(R.id.textViewMarca);
        TextView textViewModelo = convertView.findViewById(R.id.textViewModelo);
        TextView textViewPrecio = convertView.findViewById(R.id.textViewPrecio);
        ImageView imageView = convertView.findViewById(R.id.imagenCoche);

        textViewMarca.setText(resultado[1]); // Marca
        textViewModelo.setText(resultado[2] + " " + resultado[3]); // Modelo
        textViewPrecio.setText(resultado[4] + "€"); // Precio

        // generamos el nombre del fichero de imagen, tendra el formato 'marca_modelo.jpg'
        ficheroImagen = resultado[1].replace(" ","_")+"_" + resultado[2].replace(" ","_");
        ficheroImagen = ficheroImagen.replace(" ","");
        ficheroImagen = ficheroImagen.toLowerCase(Locale.ROOT);
        //sacamos el id de la imagen a partir de su nombre de fichero
        int resourceId = context.getResources().getIdentifier(ficheroImagen,"mipmap",context.getPackageName());
        // establecemos la imagen
        imageView.setImageResource(resourceId);
        // hacemos que la imagen sea clickable y que te lleva a la ficha del coche
        imageView.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FichaCoche.class);
                intent.putExtra("marca", resultado[1]);
                intent.putExtra("modelo", resultado[2] + " " + resultado[3]);
                intent.putExtra("precio", resultado[4]);
                intent.putExtra("cilindrada", resultado[5]);
                intent.putExtra("combustible", resultado[6]);
                intent.putExtra("potencia", resultado[7]);
                intent.putExtra("tracción", resultado[8]);
                intent.putExtra("consumo", resultado[9]);
                intent.putExtra("etiqueta", resultado[10]);
                intent.putExtra("cambio", resultado[11]);
                intent.putExtra("carroceria", resultado[12]);
                intent.putExtra("maletero", resultado[13]);
                intent.putExtra("imagen",resourceId);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}