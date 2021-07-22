package edu.fiuba.algo3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LectorDePaisesCSV extends LectorDePaises{

    public LectorDePaisesCSV(String rutaArchivo) throws FileNotFoundException {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            rutaArchivo = rutaArchivo.replace("/","\\");
        }
        lector = new FileReader(rutaArchivo);
    }

    @Override
    public boolean esDeTipo(String tipoArchivo){
        return tipoArchivo.equals("csv");
    }

    @Override
    public ArrayList<Continente> obtener(){
        ArrayList<Continente> continentes = inicializarContinentes();
        organizarContinentes(continentes);
        return continentes;
    }

    @Override
    protected void organizarContinentes(ArrayList<Continente> continentes){
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
}
