package edu.fiuba.algo3;

public interface Fase {
    void jugar(int cantidadEjercitos, Jugador jugador, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException;
    Fase siguienteEtapa(int jugadorActual, int cantidadDeJugadores);
}
