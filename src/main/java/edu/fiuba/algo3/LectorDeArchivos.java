package edu.fiuba.algo3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class LectorDeArchivos {

    private final FileReader lector;
    private final JSONParser parser;

    public LectorDeArchivos(String nombreArchivo) throws FileNotFoundException{
        this.lector = new FileReader(nombreArchivo);
        this.parser = new JSONParser();
    }

    public ArrayList<Pais> getPaises() throws ParseException, IOException{
        Object obj = parser.parse(lector);
        JSONArray listaPaises = (JSONArray) obj;
        ArrayList<Pais> paises = new ArrayList<>();
        for (Object pais : listaPaises) {
            paises.add(this.parsearPais((JSONObject)pais));
        }
        return paises;
    }

    private Pais parsearPais (JSONObject pais){
        String nombre = (String) pais.get("Pais");
        String continente = (String) pais.get("Continente");
        String[] arrayPaises = ((String) pais.get("Limita con")).split(",");
        ArrayList<String> fronteras = new ArrayList<>(Arrays.asList(arrayPaises));
        return (new Pais(nombre, continente, fronteras));
    }

    public ArrayList<Carta> getCartas() throws ParseException, IOException{
        Object obj = parser.parse(lector);
        JSONArray listaCartas = (JSONArray) obj;
        ArrayList<Carta> cartas = new ArrayList<>();
        for (Object carta : listaCartas) {
            cartas.add(this.parsearCarta((JSONObject) carta));
        }
        return cartas;
    }

    private Carta parsearCarta (JSONObject carta){
        String pais = (String) carta.get("Pais");
        String simbolo = (String) carta.get("Simbolo");
        return (new Carta(pais, simbolo));
    }

}
