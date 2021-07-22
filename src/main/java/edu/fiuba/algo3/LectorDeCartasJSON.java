package edu.fiuba.algo3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorDeCartasJSON extends LectorDeCartas{

    public LectorDeCartasJSON(String rutaArchivo) throws FileNotFoundException {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            rutaArchivo = rutaArchivo.replace("/","\\");
        }
        this.lector = new FileReader(rutaArchivo);
        this.parser = new JSONParser();
    }

    @Override
    public boolean esDeTipo(String tipoArchivo) {
        return tipoArchivo.equals("json");
    }

    @Override
    public ArrayList<Carta> obtener() throws IOException, ParseException {
        JSONArray listaCartas = (JSONArray) parser.parse(lector);
        ArrayList<Carta> cartas = new ArrayList<>();
        for (Object carta : listaCartas) {
            cartas.add(obtenerCarta((JSONObject) carta));
        }
        return cartas;
    }

    @Override
    protected Carta obtenerCarta(Object carta){
        String pais = (String)((JSONObject)carta).get("Pais");
        String simbolo = (String)((JSONObject)carta).get("Simbolo");
        return (new Carta(pais, simbolo));
    }
}
