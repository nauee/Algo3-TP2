package edu.fiuba.algo3;

import java.util.ArrayList;

public interface Fase {
    void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, MovimientoConCantidadInvalidaException;
    Fase siguienteFase(Jugador siguienteJugador, ArrayList<Carta> cartas);
}
