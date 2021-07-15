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
import java.util.Hashtable;
import java.util.Locale;

public class LectorDeArchivos {

    private final FileReader lector;
    private final JSONParser parser;

    public LectorDeArchivos(String nombreArchivo) throws FileNotFoundException{
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            nombreArchivo = nombreArchivo.replace("/","\\");
        }
        this.lector = new FileReader(nombreArchivo);
        this.parser = new JSONParser();
    }

    public Hashtable<String, Continente> getContinentes() throws ParseException, IOException{

        Hashtable<String, Continente> continentes = new Hashtable<>();
        continentes.put("Asia", new Continente("Asia", 7));
        continentes.put("Europa", new Continente("Europa", 5));
        continentes.put("America del Norte", new Continente("America del Norte", 5));
        continentes.put("America del Sur", new Continente("America del Sur", 3));
        continentes.put("Africa", new Continente("Africa", 3));
        continentes.put("Oceania", new Continente("Oceania", 2));

        organizarContinentes(continentes);
        return continentes;
    }

    private ArrayList<Pais> organizarContinentes(Hashtable<String, Continente> continentes) throws ParseException, IOException{
        JSONArray listaPaises = (JSONArray) parser.parse(lector);
        ArrayList<Pais> paises = new ArrayList<>();
        for (Object pais : listaPaises) {
            parsearPais((JSONObject)pais, continentes);
        }
        return paises;
    }

    private void parsearPais(JSONObject pais, Hashtable<String, Continente> continentes){
        String nombre = (String) pais.get("Pais");
        String continente = (String) pais.get("Continente");
        String[] arrayPaises = ((String) pais.get("Limita con")).split(",");
        ArrayList<String> fronteras = new ArrayList<>(Arrays.asList(arrayPaises));
        Pais paisNuevo = new Pais(nombre, fronteras);
        continentes.get(continente).agregarPais(paisNuevo);
    }

    public ArrayList<Carta> getCartas() throws ParseException, IOException{
        JSONArray listaCartas = (JSONArray) parser.parse(lector);
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