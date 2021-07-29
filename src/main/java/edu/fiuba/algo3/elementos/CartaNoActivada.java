package edu.fiuba.algo3.elementos;

import edu.fiuba.algo3.excepciones.PaisNoTePerteneceException;

import java.util.ArrayList;

public class CartaNoActivada extends Carta{
    public CartaNoActivada(String pais, String simbolo){
        super(pais, simbolo);
    }

    @Override
    public Carta activarse(ArrayList<Pais> paises, Jugador jugador){
        try{
            Pais pais = buscarPais(paises);
            pais.agregarEjercitos(2, jugador);
            return new CartaActivada(this.pais, simbolo);
        }catch(PaisNoTePerteneceException exception){
            return this;
        }
    }
}