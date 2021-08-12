package edu.fiuba.algo3.modelo.lectura.creador;

import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExisteException;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;

public class CreadorDeCartas{

    private static Pais obtenerPais(ArrayList<Continente> continentes, String nombrePais) throws PaisNoExisteException {
        for (Continente continente : continentes)
            if (continente.getPais(nombrePais) != null)
                return continente.getPais(nombrePais);
        throw new PaisNoExisteException();
    }

    public static Carta crear(String nombrePais, String simbolo, ArrayList<Continente> continentes) throws PaisNoExisteException {
        return new Carta(obtenerPais(continentes, nombrePais),simbolo);
    }
}