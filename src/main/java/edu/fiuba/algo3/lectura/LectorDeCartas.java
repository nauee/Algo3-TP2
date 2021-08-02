package edu.fiuba.algo3.lectura;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.CreadorDeCartas;
import edu.fiuba.algo3.elementos.CreadorDeElementos;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public abstract class LectorDeCartas implements Lector{

    protected FileReader lector;
    protected JSONParser parser;
    protected String rutaArchivo;
    protected CreadorDeElementos creador = new CreadorDeElementos("carta");

    public LectorDeCartas(String rutaArchivo){
        this.rutaArchivo = rutaArchivo;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            this.rutaArchivo = rutaArchivo.replace("/","\\");
        }
    }
}