package edu.fiuba.algo3.modelo.lectura.lector;

import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.lectura.creador.CreadorDePaises;
import edu.fiuba.algo3.modelo.geografia.Pais;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LectorDePaisesJSON extends LectorDePaises implements Lector {

    public LectorDePaisesJSON() throws FileNotFoundException {
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

    private void organizarContinentes(ArrayList<Continente> continentes) throws IOException, ParseException {
        JSONArray listaPaises = (JSONArray) parser.parse(lector);

        for (Object pais : listaPaises) {

            String nombreContinente = (String)((JSONObject)pais).get("Continente");
            Pais nuevoPais = obtenerPais((JSONObject)pais);

            for (Continente continente : continentes)
                if (continente.getNombre().equals(nombreContinente))
                    continente.agregarPais(nuevoPais);
        }
    }

    private Pais obtenerPais(JSONObject pais){
        String nombre = (String) pais.get("Pais");
        String[] arrayPaises = ((String) pais.get("Limita con")).split(",");
        ArrayList<String> fronteras = new ArrayList<>(Arrays.asList(arrayPaises));
        return (CreadorDePaises.crear(nombre, fronteras));
    }
}
