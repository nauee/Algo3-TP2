package edu.fiuba.algo3.lectura;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class LectorDeObjetivos implements Lector{
    protected FileReader lector;
    protected JSONParser parser;
    protected String rutaArchivo;

    public LectorDeObjetivos(String rutaArchivo){
        this.rutaArchivo = rutaArchivo;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            this.rutaArchivo = rutaArchivo.replace("/","\\");
        }
    }
}
