package edu.fiuba.algo3;

public interface Fase {
    void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException;
    Fase siguienteFase(Jugador siguienteJugador);
}
