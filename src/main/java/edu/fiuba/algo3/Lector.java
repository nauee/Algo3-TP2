package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public interface Lector {

    ArrayList<?> obtener() throws IOException, ParseException;
    boolean esDeTipo(String tipoArchivo);
}
