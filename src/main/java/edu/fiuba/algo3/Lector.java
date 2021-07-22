package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface Lector {
    Object obtener() throws IOException, ParseException;
    boolean esDeTipo(String tipoArchivo);
}
