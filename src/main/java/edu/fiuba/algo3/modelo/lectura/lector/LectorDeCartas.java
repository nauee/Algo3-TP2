package edu.fiuba.algo3.modelo.lectura.lector;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.excepciones.NoSePudoLeerExcepcion;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExisteException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorDeCartas{

    protected FileReader lector;
    protected JSONParser parser;
    protected static String rutaArchivo;
    protected static ArrayList<Continente> continentes;
    private final ArrayList<Lector> lectores = new ArrayList<>();

    protected LectorDeCartas(){}

    public LectorDeCartas(ArrayList<Continente> unosContinentes){
        continentes = unosContinentes;
    }

    private String getTipoArchivo(String rutaArchivo){
        String[] infoRuta = rutaArchivo.split("\\.");
        return infoRuta[infoRuta.length-1];
    }

    public ArrayList<Carta> leer(String unaRutaArchivo) throws IOException, ParseException, NoSePudoLeerExcepcion, PaisNoExisteException {
        rutaArchivo = unaRutaArchivo;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            rutaArchivo = unaRutaArchivo.replace("/","\\");
        }

        lectores.add(new LectorDeCartasJSON());

        for (Lector lector : lectores){
            if (lector.esDeTipo(getTipoArchivo(rutaArchivo)))
                return (ArrayList<Carta>)lector.obtener();
        }

        throw new NoSePudoLeerExcepcion();
    }
}