package edu.fiuba.algo3;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class LectorDeArchivos {

    protected final FileReader lector;
    protected final JSONParser parser;
    protected final String tipoArchivo;

    public LectorDeArchivos(String rutaArchivo) throws FileNotFoundException{
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            rutaArchivo = rutaArchivo.replace("/","\\");
        }
        this.lector = new FileReader(rutaArchivo);
        this.parser = new JSONParser();
        this.tipoArchivo = rutaArchivo.split("\\.")[1];
    }
}