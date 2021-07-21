package edu.fiuba.algo3;

import java.util.ArrayList;

public class Carta {

    private final String pais;
    private final String simbolo;
    private boolean activada;

    public Carta(String pais, String simbolo) {

        this.pais = pais;
        this.simbolo = simbolo;
        activada = false;
    }

    public String getPais(){
        return pais;
    }

    public String getSimbolo(){
        return simbolo;
    }

    private Pais buscarPais (ArrayList <Pais> paises) {
        for (Pais p : paises) {
            if (p.equals(this.pais))
                return p;
        }
        return null;
    }

    public void activarse(ArrayList<Pais> paises, Jugador jugador){
        if (activada) return;
        Pais pais = buscarPais(paises);
        if (pais != null) {
            activada = true;
            try {
                pais.agregarEjercitos(2, jugador);
            } catch(PaisNoTePerteneceException ignored){};
        }
    }

}