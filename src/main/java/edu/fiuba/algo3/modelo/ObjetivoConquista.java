package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.elementos.Jugador;
import edu.fiuba.algo3.elementos.Pais;

import java.util.ArrayList;

public class ObjetivoConquista extends Objetivo{

    private final ArrayList<Pais> paisesAConquistar;

    public ObjetivoConquista(ArrayList<Pais> paisesAConquistar){
        this.paisesAConquistar = paisesAConquistar;
    }

    @Override
    public boolean cumplido(Jugador jugador) {
        boolean cumplido = true;
        for(Pais pais : paisesAConquistar){
            if (!jugador.tienePais(pais))
                cumplido = false;
        }
        return cumplido || objetivoComunCumplido(jugador);
    }
}
