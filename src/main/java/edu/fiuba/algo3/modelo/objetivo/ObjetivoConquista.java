package edu.fiuba.algo3.modelo.objetivo;

import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;

public class ObjetivoConquista extends Objetivo {

    private final ArrayList<Continente> continentes;
    private final ArrayList<Integer> cantidadAConquistarPorContinente;
    private final int TODOS_LOS_PAISES = 0;

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

    public ArrayList<Continente> getContinentes(){
        return continentes;
    }

    public ArrayList<Integer> getCantidades(){
        return cantidadAConquistarPorContinente;
    }

    public String getDescripcion(){
        String descripcion = "";
        for (int i = 0; i < continentes.size(); i++){
            descripcion = descripcion.concat("Conquista ");
            int cantidad = cantidadAConquistarPorContinente.get(i);
            descripcion = descripcion.concat(cantidad != TODOS_LOS_PAISES ? cantidad + " paises de " : "todo ");
            descripcion = descripcion.concat(continentes.get(i).getNombre() + "\n");
        }
        return descripcion;
    }
}