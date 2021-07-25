package edu.fiuba.algo3;

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
