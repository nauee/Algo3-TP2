package edu.fiuba.algo3.lectura;

import edu.fiuba.algo3.elementos.Carta;
import edu.fiuba.algo3.elementos.CartaNoActivada;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LectorDeCartasCSV extends LectorDeCartas{

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
    public ArrayList<Carta> obtener() {
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

    @Override
    protected Carta obtenerCarta(Object carta){
        String pais = ((String[])carta)[0];
        String simbolo = ((String[])carta)[1];
        return (new CartaNoActivada(pais, simbolo));
    }
}