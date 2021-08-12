package edu.fiuba.algo3.modelo.lectura.lector;

import edu.fiuba.algo3.modelo.excepciones.PaisNoExisteException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public interface Lector {

    ArrayList<?> obtener() throws IOException, ParseException, PaisNoExisteException;
    boolean esDeTipo(String tipoArchivo);
}
