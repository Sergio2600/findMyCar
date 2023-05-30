package com.example.findmycar.activities;

public class ResultadoConsulta {
    private String marca;
    private String modelo;
    private double precio;

    public ResultadoConsulta(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }
}