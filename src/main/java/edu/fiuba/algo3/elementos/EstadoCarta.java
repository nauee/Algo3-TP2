package edu.fiuba.algo3.elementos;

import edu.fiuba.algo3.excepciones.CartaYaActivadaException;

import java.util.ArrayList;

public interface EstadoCarta {
    EstadoCarta activarse(Jugador jugador, Pais pais) throws CartaYaActivadaException;
}
