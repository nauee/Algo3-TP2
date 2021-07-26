package edu.fiuba.algo3.elementos;

import edu.fiuba.algo3.excepciones.PaisNoTePerteneceException;

import java.util.ArrayList;

public class CartaNoActivada extends Carta{
    public CartaNoActivada(String pais, String simbolo){
        super(pais, simbolo);
    }

    @Override
    public Carta activarse(ArrayList<Pais> paises, Jugador jugador){
        Pais pais = buscarPais(paises);
        if (pais != null) {
            try {
                pais.agregarEjercitos(2, jugador);
            } catch(PaisNoTePerteneceException ignored){}
            return new CartaActivada(this.pais, this.simbolo);
        }
        return this;
    }
}