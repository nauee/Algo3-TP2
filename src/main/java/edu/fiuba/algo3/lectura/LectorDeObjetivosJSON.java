package edu.fiuba.algo3.lectura;

import edu.fiuba.algo3.modelo.Objetivo;
import edu.fiuba.algo3.modelo.Objetivo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorDeObjetivosJSON extends LectorDeObjetivos{

    public LectorDeObjetivosJSON(String rutaArchivo) throws FileNotFoundException {
        super(rutaArchivo);
        this.lector = new FileReader(this.rutaArchivo);
        this.parser = new JSONParser();
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
        return null;
    }

    @Override
    public boolean esDeTipo(String tipoArchivo) {
        return tipoArchivo.equals("json");
    }
}
