package edu.fiuba.algo3.modelo.lectura.lector;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.lectura.creador.CreadorDeCartas;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExisteException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorDeCartasJSON extends LectorDeCartas implements Lector {

    public LectorDeCartasJSON() throws FileNotFoundException {
        this.lector = new FileReader(rutaArchivo);
        this.parser = new JSONParser();
    }

    @Override
    public boolean esDeTipo(String tipoArchivo) {
        return tipoArchivo.equals("json");
    }

    @Override
    public ArrayList<Carta> obtener() throws IOException, ParseException, PaisNoExisteException {
        JSONArray listaCartas = (JSONArray) parser.parse(lector);
        ArrayList<Carta> cartas = new ArrayList<>();
        for (Object carta : listaCartas)
            cartas.add(obtenerCarta((JSONObject)carta));
        return cartas;
    }

    private Carta obtenerCarta(JSONObject carta) throws PaisNoExisteException {
        String pais = (String)carta.get("Pais");
        String simbolo = (String)carta.get("Simbolo");
        return CreadorDeCartas.crear(pais, simbolo, continentes);
    }
}