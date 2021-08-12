package edu.fiuba.algo3.modelo.lectura.lector;

import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.excepciones.NoSePudoLeerExcepcion;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExisteException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorDePaises{

    protected FileReader lector;
    protected JSONParser parser;
    protected static String rutaArchivo;
    private final ArrayList<Lector> lectores = new ArrayList<>();

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

    private String getTipoArchivo(String rutaArchivo){
        String[] infoRuta = rutaArchivo.split("\\.");
        return infoRuta[infoRuta.length-1];
    }

    public ArrayList<Continente> leer(String unaRutaArchivo) throws NoSePudoLeerExcepcion, IOException, ParseException, PaisNoExisteException {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            rutaArchivo = unaRutaArchivo.replace("/","\\");
        }
        rutaArchivo = unaRutaArchivo;

        lectores.add(new LectorDePaisesJSON());

        for (Lector lector : lectores){
            if (lector.esDeTipo(getTipoArchivo(rutaArchivo)))
                return (ArrayList<Continente>)lector.obtener();
        }

        throw new NoSePudoLeerExcepcion();
    }
}
