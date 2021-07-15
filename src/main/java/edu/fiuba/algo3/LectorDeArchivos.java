package edu.fiuba.algo3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public abstract class LectorDeArchivos {

    protected final FileReader lector;
    protected final JSONParser parser;

    public LectorDeArchivos(String nombreArchivo) throws FileNotFoundException{
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            nombreArchivo = nombreArchivo.replace("/","\\");
        }
        this.lector = new FileReader(nombreArchivo);
        this.parser = new JSONParser();
    }

    public abstract Object obtener() throws ParseException, IOException;
}