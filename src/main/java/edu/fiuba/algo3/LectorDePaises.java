package edu.fiuba.algo3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LectorDePaises extends LectorDeArchivos{

    public LectorDePaises(String rutaArchivo) throws FileNotFoundException {
        super(rutaArchivo);
    }

    @Override
    public Object obtener() throws ParseException, IOException {
        return (tipoArchivo.equals("json") ? obtenerDeJSON() : obtenerDeCSV() );
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

    private Object obtenerDeCSV(){
        ArrayList<Continente> continentes = inicializarContinentes();
        organizarContinentesCSV(continentes);
        return continentes;
    }

    private void organizarContinentesCSV(ArrayList<Continente> continentes){
        Scanner scanner = new Scanner(lector);

        try{
            String linea = scanner.nextLine();
            while (linea != null){

                String[] infoPais = linea.split("\"");
                String[] paisYContinente = infoPais[0].split(",");
                String[] fronteras = infoPais[1].split(",");
                String continente = paisYContinente[1];

                Pais nuevoPais = new Pais(paisYContinente[0], new ArrayList<String>(Arrays.asList(fronteras)));

                continentes.forEach((continenteEnLista)->{
                    if (continenteEnLista.getNombre().equals(continente))
                        continenteEnLista.agregarPais(nuevoPais);
                });

                linea = scanner.nextLine();
            }
        }
        catch(NoSuchElementException ignored){}
        scanner.close();
    }

    private Object obtenerDeJSON() throws ParseException, IOException {
        ArrayList<Continente> continentes = inicializarContinentes();
        organizarContinentesJSON(continentes);
        return continentes;
    }

    private void organizarContinentesJSON(ArrayList<Continente> continentes) throws ParseException, IOException{
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