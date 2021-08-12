package edu.fiuba.algo3.modelo.lectura.creador;

import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
import edu.fiuba.algo3.modelo.objetivo.ObjetivoConquista;
import edu.fiuba.algo3.modelo.objetivo.ObjetivoDestruccion;

import java.util.ArrayList;

public class CreadorDeObjetivos{

    public static Objetivo crear(String[] continentesObjetivo, String[] cantidadPorPais, ArrayList<Continente> continentes) {

        ArrayList<Continente> continentesParaObjetivo = new ArrayList<>();
        for (Continente continente : continentes){
            for (String continenteString : continentesObjetivo) {
                if (continente.getNombre().equals(continenteString))
                    continentesParaObjetivo.add(continente);
            }
        }

        ArrayList<Integer> cantidadPaisesAConquistarPorContinente = new ArrayList<>();
        for (String cantidad : cantidadPorPais)
            cantidadPaisesAConquistarPorContinente.add(Integer.parseInt(cantidad));

        return new ObjetivoConquista(continentesParaObjetivo, cantidadPaisesAConquistarPorContinente);
    }

    public static Objetivo crear(int numeroJugador, ArrayList<Jugador> jugadores){
        Jugador jugador;
        if (numeroJugador > jugadores.size())
            jugador = jugadores.get(0);
        else
            jugador = jugadores.get(numeroJugador-1);

        return new ObjetivoDestruccion(jugador);
    }
}