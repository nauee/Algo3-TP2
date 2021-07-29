package edu.fiuba.algo3.elementos;

import edu.fiuba.algo3.excepciones.CartaYaActivadaException;

import java.util.ArrayList;

public class CartaActivada implements EstadoCarta{
    @Override
    public EstadoCarta activarse(ArrayList<Pais> paises, Jugador jugador, String pais) throws CartaYaActivadaException {
        throw new CartaYaActivadaException();
    }

}
