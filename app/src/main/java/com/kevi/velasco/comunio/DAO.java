package com.kevi.velasco.comunio;

import java.util.ArrayList;

public class DAO {

    static ArrayList<Integer> escudos = new ArrayList<>();
    static ArrayList<Jugador> jugadores = new ArrayList<>();

    static ArrayList<Integer> obtenerEscudos() {
        escudos.add(R.drawable.roma);
        escudos.add(R.drawable.alcala_dos);
        escudos.add(R.drawable.madrid);
        escudos.add(R.drawable.milan);
        escudos.add(R.drawable.arsenal);
        return escudos;
    }

    static ArrayList<Jugador> obtenerTodosLosJugadores() {
        jugadores.clear();
            jugadores.add(new Jugador("Virgil van Dijk", "Defensa", 91, 85, R.drawable.vandijk));
            jugadores.add(new Jugador("Rúben Dias", "Defensa", 89, 75, R.drawable.rubendias));
            jugadores.add(new Jugador("Antonio Rüdiger", "Defensa", 87, 60, R.drawable.rudiger));
            jugadores.add(new Jugador("Marquinhos", "Defensa", 88, 70, R.drawable.marquinhos));
            jugadores.add(new Jugador("Éder Militão", "Defensa", 89, 80, R.drawable.militao));
            jugadores.add(new Jugador("David Alaba", "Defensa", 85, 50, R.drawable.alaba));
            jugadores.add(new Jugador("João Cancelo", "Defensa", 88, 75, R.drawable.cancelo));
            jugadores.add(new Jugador("Trent Alexander-Arnold", "Defensa", 86, 70, R.drawable.trent));
            jugadores.add(new Jugador("Theo Hernández", "Defensa", 87, 68, R.drawable.theo));
            jugadores.add(new Jugador("Alphonso Davies", "Defensa", 88, 80, R.drawable.davies));
            jugadores.add(new Jugador("Asencio", "Defensa", 73, 25, R.drawable.asencio));


            jugadores.add(new Jugador("Kevin De Bruyne", "Centrocampista", 92, 10, R.drawable.debruyne));
            jugadores.add(new Jugador("Luka Modric", "Centrocampista", 89, 40, R.drawable.modric));
            jugadores.add(new Jugador("Jude Bellingham", "Centrocampista", 91, 12, R.drawable.bellingham));
            jugadores.add(new Jugador("Rodri", "Centrocampista", 90, 90, R.drawable.rodri));
            jugadores.add(new Jugador("Bruno Fernandes", "Centrocampista", 88, 80, R.drawable.fernandes));
            jugadores.add(new Jugador("Joshua Kimmich", "Centrocampista", 89, 85, R.drawable.kimmich));
            jugadores.add(new Jugador("Federico Valverde", "Centrocampista", 88, 90, R.drawable.valverde));
            jugadores.add(new Jugador("Martin Ødegaard", "Centrocampista", 87, 75, R.drawable.odegaard));
            jugadores.add(new Jugador("Declan Rice", "Centrocampista", 87, 70, R.drawable.rice));
            jugadores.add(new Jugador("Pedri", "Centrocampista", 90, 10, R.drawable.pedri));


            jugadores.add(new Jugador("Erling Haaland", "Delantero", 94, 15, R.drawable.haaland));
            jugadores.add(new Jugador("Kylian Mbappe", "Delantero", 95, 18, R.drawable.mbappe));
            jugadores.add(new Jugador("Lionel Messi", "Delantero", 93, 50, R.drawable.messi));
            jugadores.add(new Jugador("Cristiano Ronaldo", "Delantero", 89, 35, R.drawable.cr7));
            jugadores.add(new Jugador("Harry Kane", "Delantero", 91, 11, R.drawable.kane));
            jugadores.add(new Jugador("Vinicius Jr.", "Delantero", 92, 12, R.drawable.vini));
            jugadores.add(new Jugador("Mohamed Salah", "Delantero", 91, 90, R.drawable.salah));
            jugadores.add(new Jugador("Robert Lewandowski", "Delantero", 91, 70, R.drawable.lewandoski));
            jugadores.add(new Jugador("Karim Benzema", "Delantero", 90, 60, R.drawable.benzema));
            jugadores.add(new Jugador("Victor Osimhen", "Delantero", 89, 95, R.drawable.oshimen));


            jugadores.add(new Jugador("Thibaut Courtois", "Portero", 92, 90, R.drawable.curtois));
            jugadores.add(new Jugador("Alisson Becker", "Portero", 91, 85, R.drawable.allison));
            jugadores.add(new Jugador("Ederson Moraes", "Portero", 90, 80, R.drawable.ederson));
            jugadores.add(new Jugador("Marc-Andre ter Stegen", "Portero", 89, 75, R.drawable.terstegen));
            jugadores.add(new Jugador("Jan Oblak", "Portero", 91, 90, R.drawable.oblak));
            jugadores.add(new Jugador("Mike Maignan", "Portero", 89, 80, R.drawable.maignan));
            jugadores.add(new Jugador("Gianluigi Donnarumma", "Portero", 90, 85, R.drawable.donnarumma));
            jugadores.add(new Jugador("Emiliano Martínez", "Portero", 88, 70, R.drawable.emiliano));
            jugadores.add(new Jugador("Andre Onana", "Portero", 87, 65, R.drawable.onana));
            jugadores.add(new Jugador("Aaron Ramsdale", "Portero", 86, 60, R.drawable.aaron));

        return jugadores;
    }
}
