package com.example.sanchez_luis_r4_u2;

public class Comida {
    String comida;
    String presio;
    String descripcion;


    public Comida(String comida, String presio, String descripcion) {
        this.comida = comida;
        this.presio = presio;
        this.descripcion = descripcion;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getPresio() {
        return presio;
    }

    public void setPresio(String presio) {
        this.presio = presio;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
