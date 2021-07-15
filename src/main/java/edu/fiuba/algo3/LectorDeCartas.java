package edu.fiuba.algo3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LectorDeCartas extends LectorDeArchivos{

    public LectorDeCartas(String rutaArchivo) throws FileNotFoundException {
        super(rutaArchivo);
    }

    @Override
    public Object obtener() throws ParseException, IOException {
        JSONArray listaCartas = (JSONArray) parser.parse(lector);
        ArrayList<Carta> cartas = new ArrayList<>();
        for (Object carta : listaCartas) {
            cartas.add(obtenerCarta((JSONObject) carta));
        }
        return cartas;
    }

    private Carta obtenerCarta(JSONObject carta){
        String pais = (String) carta.get("Pais");
        String simbolo = (String) carta.get("Simbolo");
        return (new Carta(pais, simbolo));
    }
}