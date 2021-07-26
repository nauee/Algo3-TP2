package edu.fiuba.algo3.lectura;

import edu.fiuba.algo3.elementos.Continente;
import edu.fiuba.algo3.elementos.Pais;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

public class LectorDePaisesJSON extends LectorDePaises{

    public LectorDePaisesJSON(String rutaArchivo) throws FileNotFoundException {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            rutaArchivo = rutaArchivo.replace("/","\\");
        }
        lector = new FileReader(rutaArchivo);
        parser = new JSONParser();
    }

    @Override
    public boolean esDeTipo(String tipoArchivo) {
        return tipoArchivo.equals("json");
    }

    @Override
    public ArrayList<Continente> obtener() throws IOException, ParseException {
        ArrayList<Continente> continentes = inicializarContinentes();
        organizarContinentes(continentes);
        return continentes;
    }

    @Override
    protected void organizarContinentes(ArrayList<Continente> continentes) throws IOException, ParseException {
        JSONArray listaPaises = (JSONArray) parser.parse(lector);
        for (Object pais : listaPaises) {
            String nombreContinente = (String)((JSONObject)pais).get("Continente");
            Pais nuevoPais = obtenerPais((JSONObject)pais);
            for (Continente continente : continentes){
                if (continente.getNombre().equals(nombreContinente)){
                    continente.agregarPais(nuevoPais);
                }
            }
        }
    }

    private Pais obtenerPais(JSONObject pais){
        String nombre = (String) pais.get("Pais");
        String[] arrayPaises = ((String) pais.get("Limita con")).split(",");
        ArrayList<String> fronteras = new ArrayList<>(Arrays.asList(arrayPaises));
        return (new Pais(nombre, fronteras));
    }
}
