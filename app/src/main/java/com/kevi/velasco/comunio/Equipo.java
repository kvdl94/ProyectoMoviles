package com.kevi.velasco.comunio;

import java.io.Serializable;

public class Equipo implements Serializable {
    int id;
    String nombre;
    String escudoUrl;
    String localizacion;
    int anioFundacion;
    String nombreEstadio;
    String division;
    String videoUrl;

    public Equipo(int id, String nombre, String localizacion, int anioFundacion, String nombreEstadio, String division, String escudoUrl, String videoUrl) {
        this.id = id;
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.anioFundacion = anioFundacion;
        this.nombreEstadio = nombreEstadio;
        this.division = division;
        this.escudoUrl = escudoUrl;
        this.videoUrl = videoUrl;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEscudoUrl() {
        return escudoUrl;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public String getDivision() {
        return division;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
