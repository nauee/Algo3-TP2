package edu.fiuba.algo3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class LectorDePaises extends LectorDeArchivos{

    public LectorDePaises(String rutaArchivo) throws FileNotFoundException {
        super(rutaArchivo);
    }

    @Override
    public Object obtener() throws ParseException, IOException {

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

    private void organizarContinentes(Hashtable<String, Continente> continentes) throws ParseException, IOException{
        JSONArray listaPaises = (JSONArray) parser.parse(lector);
        for (Object pais : listaPaises) {
            String nombreContinente = (String)((JSONObject)pais).get("Continente");
            Pais nuevoPais = obtenerPais((JSONObject)pais);
            continentes.get(nombreContinente).agregarPais(nuevoPais);
        }
    }

    private Pais obtenerPais(JSONObject pais){
        String nombre = (String) pais.get("Pais");
        String[] arrayPaises = ((String) pais.get("Limita con")).split(",");
        ArrayList<String> fronteras = new ArrayList<>(Arrays.asList(arrayPaises));
        return (new Pais(nombre, fronteras));
    }
}
