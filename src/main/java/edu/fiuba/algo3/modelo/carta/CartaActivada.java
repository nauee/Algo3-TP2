package edu.fiuba.algo3.modelo.carta;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.CartaYaActivadaException;

public class CartaActivada implements EstadoCarta {
    @Override
    public EstadoCarta activarse(Jugador jugador, Pais pais) throws CartaYaActivadaException {
        throw new CartaYaActivadaException();
    }
}
