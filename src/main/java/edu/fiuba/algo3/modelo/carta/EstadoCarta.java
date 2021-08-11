package edu.fiuba.algo3.modelo.carta;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.excepciones.CartaYaActivadaException;

public interface EstadoCarta {
    EstadoCarta activarse(Jugador jugador, Pais pais) throws CartaYaActivadaException;
}
