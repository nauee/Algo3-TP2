package edu.fiuba.algo3.elementos;

import edu.fiuba.algo3.excepciones.CartaYaActivadaException;

public class CartaActivada implements EstadoCarta{
    @Override
    public EstadoCarta activarse(Jugador jugador, Pais pais) throws CartaYaActivadaException {
        throw new CartaYaActivadaException();
    }
}
