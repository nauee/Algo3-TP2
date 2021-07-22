package edu.fiuba.algo3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LectorDePaisesJSON implements Lector{

    private final FileReader lector;
    private final JSONParser parser;

    public LectorDePaisesJSON(String rutaArchivo) throws FileNotFoundException {
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
    public Object obtener() throws IOException, ParseException {
        ArrayList<Continente> continentes = inicializarContinentes();
        organizarContinentes(continentes);
        return continentes;
    }

    private ArrayList<Continente> inicializarContinentes(){
        ArrayList<Continente> continentes = new ArrayList<>();
        continentes.add(new Continente("Asia", 7));
        continentes.add(new Continente("Europa", 5));
        continentes.add(new Continente("America del Norte", 5));
        continentes.add(new Continente("America del Sur", 3));
        continentes.add(new Continente("Africa", 3));
        continentes.add(new Continente("Oceania", 2));
        return continentes;
    }

    private void organizarContinentes(ArrayList<Continente> continentes) throws IOException, ParseException {
        JSONArray listaPaises = (JSONArray) parser.parse(lector);
        for (Object pais : listaPaises) {
            String nombreContinente = (String)((JSONObject)pais).get("Continente");
            Pais nuevoPais = obtenerPaisJSON((JSONObject)pais);
            for (Continente continente : continentes){
                if (continente.getNombre().equals(nombreContinente)){
                    continente.agregarPais(nuevoPais);
                }
            }
        }
    }

    private Pais obtenerPaisJSON(JSONObject pais){
        String nombre = (String) pais.get("Pais");
        String[] arrayPaises = ((String) pais.get("Limita con")).split(",");
        ArrayList<String> fronteras = new ArrayList<>(Arrays.asList(arrayPaises));
        return (new Pais(nombre, fronteras));
    }
}
