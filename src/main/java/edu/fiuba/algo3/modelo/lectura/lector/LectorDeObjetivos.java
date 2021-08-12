package edu.fiuba.algo3.modelo.lectura.lector;

import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.excepciones.NoSePudoLeerExcepcion;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExisteException;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorDeObjetivos{
    protected FileReader lector;
    protected JSONParser parser;
    protected static String rutaArchivo;
    private final ArrayList<Lector> lectores = new ArrayList<>();
    protected static ArrayList<Continente> continentes;
    protected static ArrayList<Jugador> jugadores;

    protected LectorDeObjetivos(){}

    public LectorDeObjetivos(ArrayList<Continente> unosContinentes, ArrayList<Jugador> unosJugadores){
        continentes = unosContinentes;
        jugadores = unosJugadores;
    }

    private String getTipoArchivo(String rutaArchivo){
        String[] infoRuta = rutaArchivo.split("\\.");
        return infoRuta[infoRuta.length-1];
    }

    public ArrayList<Objetivo> leer(String unaRutaArchivo) throws IOException, ParseException, NoSePudoLeerExcepcion, PaisNoExisteException {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            rutaArchivo = unaRutaArchivo.replace("/","\\");
        }
        rutaArchivo = unaRutaArchivo;

        lectores.add(new LectorDeObjetivosJSON());

        for (Lector lector : lectores){
            if (lector.esDeTipo(getTipoArchivo(rutaArchivo)))
                return (ArrayList<Objetivo>)lector.obtener();
        }
        throw new NoSePudoLeerExcepcion();
    }
}