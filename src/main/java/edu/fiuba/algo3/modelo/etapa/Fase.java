package edu.fiuba.algo3.modelo.etapa;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;

interface Fase {
    void jugar(int cantidadEjercitos, Pais... paises) throws PaisNoLimitrofeException, PaisNoTePerteneceException, AtaqueConCantidadInvalidaException, AtaqueAPaisPropioException, FichasInsuficientesException, MovimientoConCantidadInvalidaException;
    Fase siguienteFase(ArrayList<Carta> cartas) throws QuedanFichasPorColocarException;
    String nombre();
}
