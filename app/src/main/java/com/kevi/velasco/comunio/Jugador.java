package com.kevi.velasco.comunio;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String nombre;
    private String posicion;
    private int media;
    private int valorMercado;
    private int foto;

    boolean favorito;

    public Jugador(String nombre, String posicion, int media, int valorMercado, int foto) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.media = media;
        this.valorMercado = valorMercado;
        this.foto = foto;
    }

    public Jugador(String nombre, String posicion, int media, int valorMercado, int foto, boolean favorito) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.media = media;
        this.valorMercado = valorMercado;
        this.foto = foto;
        this.favorito = favorito;
    }


    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getMedia() {
        return media;
    }

    public int getValorMercado() {
        return valorMercado;
    }

    public int getFoto() {
        return foto;
    }
}
