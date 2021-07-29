package edu.fiuba.algo3.lectura;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.CreadorDeCartas;
import edu.fiuba.algo3.elementos.CreadorDeElementos;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public abstract class LectorDeCartas implements Lector{

    protected FileReader lector;
    protected JSONParser parser;
    protected CreadorDeElementos creador = new CreadorDeElementos("carta");

    protected abstract Carta obtenerCarta(Object carta);
}