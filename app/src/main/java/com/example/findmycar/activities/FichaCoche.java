package com.example.findmycar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.findmycar.R;
// para poder añadir un enlace de youtube con codigo html
import android.webkit.WebSettings;
import android.webkit.WebView;


public class FichaCoche extends AppCompatActivity {
    private WebView webView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_coche);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        String marca = intent.getStringExtra("marca");
        String modelo = intent.getStringExtra("modelo");
        String precio = intent.getStringExtra("precio");
        String cilindrada = intent.getStringExtra("cilindrada");
        String combustible = intent.getStringExtra("combustible");
        String potencia = intent.getStringExtra("potencia");
        String traccion = intent.getStringExtra("traccion");
        String consumo = intent.getStringExtra("consumo");
        String etiqueta = intent.getStringExtra("etiqueta");
        String cambio = intent.getStringExtra("cambio");
        String carroceria = intent.getStringExtra("carroceria");
        String maletero = intent.getStringExtra("maletero");
        int imagen = intent.getIntExtra("imagen",0);
        String enlace = intent.getStringExtra("enlace");


        ImageView imageView = findViewById(R.id.imagenFichaCoche);
        imageView.setImageResource(imagen);
        TextView textViewMarca = findViewById(R.id.marcaFicha);
        textViewMarca.setText(marca);
        TextView textViewModelo = findViewById(R.id.modeloFicha);
        textViewModelo.setText(modelo);
        TextView textViewPrecio = findViewById(R.id.precioFicha);
        textViewPrecio.setText(precio + "€");
        TextView textViewCilindrada = findViewById(R.id.textoCilindrada);
        textViewCilindrada.setText(cilindrada);
        TextView textViewCombustible = findViewById(R.id.textoCombustible);

        switch (combustible){
            case "1":
                textViewCombustible.setText("Gasolina");
                break;
            case "2":
                textViewCombustible.setText("Diesel");
                break;
            case "3":
                textViewCombustible.setText("Hibrido");
                break;
            case "4":
                textViewCombustible.setText("Eléctrico");
                break;
        }
        TextView textViewPotencia = findViewById(R.id.textoPotencia);
        textViewPotencia.setText(potencia + " cv");
        TextView textViewTraccion = findViewById(R.id.textoTraccion);
        textViewTraccion.setText(traccion);
        TextView textViewConsumo = findViewById(R.id.textoConsumo);
        textViewConsumo.setText(consumo + " l/100");
        ImageView imagenEtiqueta = findViewById(R.id.imagenEtiqueta);
        switch (etiqueta){
            case "1":
                imagenEtiqueta.setImageResource(R.mipmap.pegatina_eco);
                break;
            case "2":
                imagenEtiqueta.setImageResource(R.mipmap.pegatina_0);
                break;
            case "3":
                imagenEtiqueta.setImageResource(R.mipmap.pegatina_b);
                break;
            case "4":
                imagenEtiqueta.setImageResource(R.mipmap.pegatina_c);
                break;
        }
        TextView textViewCambio = findViewById(R.id.textoTipoCambio);
        //textViewCambio.setText(cambio);
        switch (cambio){
            case "1":
                textViewCambio.setText("Manual");
                break;
            case "2":
                textViewCambio.setText("Automático");
                break;
        }
        TextView textViewCarroceria = findViewById(R.id.textoTipoCarroceria);
        textViewCarroceria.setText(carroceria);
        switch (carroceria){
            case "1":
                textViewCarroceria.setText("Berlina");
                break;
            case "2":
                textViewCarroceria.setText("Cabrio");
                break;
            case "3":
                textViewCarroceria.setText("Coupé");
                break;
            case "4":
                textViewCarroceria.setText("Familiar");
                break;
            case "5":
                textViewCarroceria.setText("Monovolumen");
                break;
            case "6":
                textViewCarroceria.setText("SUV/4X4");
                break;
        }
        TextView textViewMaletero = findViewById(R.id.textoCapacidadMaletero);
        textViewMaletero.setText(maletero + " l");

        webView = findViewById(R.id.webview);
        // Habilita JavaScript para el iframe
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        // Obtener el ID del video de YouTube a partir de la url que tenemos en la base de datos
        String videoId = "";
        if (enlace.contains("youtube.com") || enlace.contains("youtu.be")) {
            String[] splitUrl = enlace.split("v=");
            if (splitUrl.length > 1) {
                videoId = splitUrl[1];
                int ampersandPosition = videoId.indexOf('&');
                if (ampersandPosition != -1) {
                    videoId = videoId.substring(0, ampersandPosition);
                }
            } else {
                String[] splitUrlSlash = enlace.split("/");
                videoId = splitUrlSlash[splitUrlSlash.length - 1];
            }
        }
        // cargamos el iframe con el id que hemos extraido de la url
        String iframeHtml = "<html><body><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        webView.loadData(iframeHtml, "text/html", "utf-8");
    }
}
