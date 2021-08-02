package edu.fiuba.algo3.lectura;

import edu.fiuba.algo3.elementos.Continente;
import edu.fiuba.algo3.elementos.CreadorDeElementos;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class LectorDePaises implements Lector{

    protected FileReader lector;
    protected JSONParser parser;
    protected String rutaArchivo;
    protected CreadorDeElementos creador = new CreadorDeElementos("pais");

    public LectorDePaises(String rutaArchivo){
        this.rutaArchivo = rutaArchivo;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            this.rutaArchivo = rutaArchivo.replace("/","\\");
        }
    }

    protected ArrayList<Continente> inicializarContinentes(){
        ArrayList<Continente> continentes = new ArrayList<>();
        continentes.add(new Continente("Asia", 7));
        continentes.add(new Continente("Europa", 5));
        continentes.add(new Continente("America del Norte", 5));
        continentes.add(new Continente("America del Sur", 3));
        continentes.add(new Continente("Africa", 3));
        continentes.add(new Continente("Oceania", 2));
        return continentes;
    }

    protected abstract void organizarContinentes(ArrayList<Continente> continentes) throws IOException, ParseException;
}
