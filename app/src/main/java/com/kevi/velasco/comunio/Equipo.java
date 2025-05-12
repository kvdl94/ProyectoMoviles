package com.kevi.velasco.comunio;

public class Equipo {
    int id;
    String nombre;
    int imagenEscudo;
    String localizacion;
    int anioFundacion;
    String nombreEstadio;
    String division;

    int video;


    public Equipo(int id, String nombre, int imagenEscudo, String localizacion, int anioFundacion, String nombreEstadio, String division, int video) {
        this.id = id;
        this.nombre = nombre;
        this.imagenEscudo = imagenEscudo;
        this.localizacion = localizacion;
        this.anioFundacion = anioFundacion;
        this.nombreEstadio = nombreEstadio;
        this.division = division;
        this.video=video;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagenEscudo() {
        return imagenEscudo;
    }

    public void setImagenEscudo(int imagenEscudo) {
        this.imagenEscudo = imagenEscudo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }


    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }
}



