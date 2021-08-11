package edu.fiuba.algo3.modelo.objetivo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.geografia.Continente;

import java.util.ArrayList;

public class ObjetivoConquista extends Objetivo {

    private final ArrayList<Continente> continentes;
    private final ArrayList<Integer> cantidadAConquistarPorContinente;

    public ObjetivoConquista(ArrayList<Continente> continentes, ArrayList<Integer> cantidadAConquistarPorContinente){
        this.continentes = continentes;
        this.cantidadAConquistarPorContinente = cantidadAConquistarPorContinente;
    }

    @Override
    public boolean cumplido(Jugador jugador) {
        boolean cumplido = true;
        for(int i = 0; i < continentes.size(); i++){
            if (!jugador.conquisto(continentes.get(i), cantidadAConquistarPorContinente.get(i)))
                cumplido = false;
        }
        return cumplido || objetivoComunCumplido(jugador);
    }
}