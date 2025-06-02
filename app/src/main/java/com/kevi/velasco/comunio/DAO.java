package com.kevi.velasco.comunio;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class DAO {

    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static ArrayList<Equipo> equipos = new ArrayList<>();

    static final String URL_JSON = "https://raw.githubusercontent.com/kvdl94/JSON/main/datos.json";


    public interface Callback {
        void onSuccess();
        void onError(Exception e);
    }

    public static void cargarDatosDesdeInternet(Context context, Callback callback) {
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL_JSON, null,
                response -> {
                    try {

                        jugadores.clear();
                        equipos.clear();


                        JSONArray arrJugadores = response.getJSONArray("jugadores");
                        for (int i = 0; i < arrJugadores.length(); i++) {
                            JSONObject obj = arrJugadores.getJSONObject(i);
                            String nombre = obj.getString("nombre");
                            String posicion = obj.getString("posicion");
                            int media = obj.getInt("media");
                            int valor = obj.getInt("valor");
                            String imagen = obj.getString("imagen");

                            jugadores.add(new Jugador(nombre, posicion, media, valor, imagen));
                        }


                        JSONArray arrEquipos = response.getJSONArray("equipos");
                        for (int i = 0; i < arrEquipos.length(); i++) {
                            JSONObject obj = arrEquipos.getJSONObject(i);
                            int id = obj.getInt("id");
                            String nombre = obj.getString("nombre");
                            String ciudad = obj.getString("ciudad");
                            int fundacion = obj.getInt("fundacion");
                            String estadio = obj.getString("estadio");
                            String liga = obj.getString("liga");
                            String escudo = obj.getString("escudo");
                            String video = obj.getString("video");

                            equipos.add(new Equipo(id, nombre, ciudad, fundacion, estadio, liga, escudo, video));
                        }

                        callback.onSuccess();

                    } catch (Exception e) {
                        callback.onError(e);
                    }
                },
                error -> callback.onError(error)
        );

        queue.add(request);
    }

    public static ArrayList<Jugador> obtenerTodosLosJugadores() {
        return jugadores;
    }

    public static ArrayList<Equipo> obtenerEquipos() {
        return equipos;
    }
}
