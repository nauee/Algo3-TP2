package edu.fiuba.algo3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LectorDeCartasCSV implements Lector{

    private final FileReader lector;

    public LectorDeCartasCSV(String rutaArchivo) throws FileNotFoundException {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            rutaArchivo = rutaArchivo.replace("/","\\");
        }
        this.lector = new FileReader(rutaArchivo);
    }

    @Override
    public boolean esDeTipo(String tipoArchivo) {
        return tipoArchivo.equals("csv");
    }

    @Override
    public Object obtener() {
        ArrayList<Carta> cartas = new ArrayList<>();
        Scanner scanner = new Scanner(lector);

        try{
            String linea = scanner.nextLine();
            while (linea != null){
                cartas.add(obtenerCarta(linea.split(",")));
                linea = scanner.nextLine();
            }
        }
        catch(NoSuchElementException ignored){}

        scanner.close();
        return cartas;
    }

    private Carta obtenerCarta(String[] datosCarta){
        return (new Carta(datosCarta[0], datosCarta[1]));
    }
}
