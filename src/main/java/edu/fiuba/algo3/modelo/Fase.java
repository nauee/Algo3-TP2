package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.Pais;
import edu.fiuba.algo3.excepciones.*;

import java.util.ArrayList;

interface Fase {
    void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, MovimientoConCantidadInvalidaException;
    Fase siguienteFase(ArrayList<Carta> cartas);
    String nombre();
}
