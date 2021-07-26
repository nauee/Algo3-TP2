package edu.fiuba.algo3.elementos;

import edu.fiuba.algo3.excepciones.CartaYaActivadaException;

import java.util.ArrayList;

public class CartaActivada extends Carta{
    public CartaActivada(String pais, String simbolo){
        super(pais, simbolo);
    }

    @Override
    public Carta activarse(ArrayList<Pais> paises, Jugador jugador) throws CartaYaActivadaException {
        throw new CartaYaActivadaException();
    }
}
