package edu.fiuba.algo3.lectura;

import edu.fiuba.algo3.Objetivo;
import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.Continente;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FachadaLector {

    private String tipoArchivo;
    private final ArrayList<Lector> lectoresPaises = new ArrayList<>();
    private final ArrayList<Lector> lectoresCartas = new ArrayList<>();
    private final ArrayList<Lector> lectoresObjetivos = new ArrayList<>();

    public FachadaLector(String rutaArchivo) throws FileNotFoundException {
        setRuta(rutaArchivo);
    }

    public void setRuta(String rutaArchivo) throws FileNotFoundException {
        this.tipoArchivo = getTipoArchivo(rutaArchivo);
        lectoresPaises.add(new LectorDePaisesJSON(rutaArchivo));
        lectoresPaises.add(new LectorDePaisesCSV(rutaArchivo));
        lectoresCartas.add(new LectorDeCartasJSON(rutaArchivo));
        lectoresCartas.add(new LectorDeCartasCSV(rutaArchivo));
        lectoresObjetivos.add(new LectorDeObjetivosJSON(rutaArchivo));
    }

    private String getTipoArchivo(String rutaArchivo){
        String[] infoRuta = rutaArchivo.split("\\.");
        return infoRuta[infoRuta.length-1];
    }

    public ArrayList<Continente> obtenerPaises() throws IOException, ParseException {
        for (Lector lector : lectoresPaises){
            if (lector.esDeTipo(tipoArchivo))
                return (ArrayList<Continente>) lector.obtener();
        }
        return null;
    }

    public ArrayList<Carta> obtenerCartas() throws IOException, ParseException {
        for (Lector lector : lectoresCartas){
            if (lector.esDeTipo(tipoArchivo))
                return (ArrayList<Carta>) lector.obtener();
        }
        return null;
    }

    public ArrayList<Objetivo> obtenerObjetivos() throws IOException, ParseException {
        for (Lector lector : lectoresObjetivos){
            if (lector.esDeTipo(tipoArchivo))
                return (ArrayList<Objetivo>) lector.obtener();
        }
        return null;
    }
}