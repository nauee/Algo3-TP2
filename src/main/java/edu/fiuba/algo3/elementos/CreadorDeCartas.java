package edu.fiuba.algo3.elementos;

import edu.fiuba.algo3.excepciones.PaisNoExisteException;

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