package edu.fiuba.algo3.modelo.lectura.lector;

import edu.fiuba.algo3.modelo.lectura.creador.CreadorDeObjetivos;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorDeObjetivosJSON extends LectorDeObjetivos implements Lector {

    public LectorDeObjetivosJSON() throws FileNotFoundException {
        this.lector = new FileReader(rutaArchivo);
        this.parser = new JSONParser();
    }

    @Override
    public boolean esDeTipo(String tipoArchivo) {
        return tipoArchivo.equals("json");
    }

    @Override
    public ArrayList<Objetivo> obtener() throws IOException, ParseException {
        JSONArray listaObjetivos = (JSONArray) parser.parse(lector);
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        for (Object unObjetivo : listaObjetivos){
            objetivos.add(obtenerObjetivo((JSONObject)unObjetivo));
        }
        return objetivos;
    }

    private Objetivo obtenerObjetivo(JSONObject objetivo){
        String tipo = (String)objetivo.get("tipo");

        if (tipo.equals("Conquista")){
            String[] continentesString = ((String)objetivo.get("continentes")).split(",");
            String[] cantidadPorContinente = ((String)objetivo.get("cantidad")).split(",");
            return CreadorDeObjetivos.crear(continentesString, cantidadPorContinente, continentes);
        }

        int numeroJugador = Integer.parseInt((String)objetivo.get("jugador"));
        return CreadorDeObjetivos.crear(numeroJugador, jugadores);
    }
}