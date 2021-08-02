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
        super(rutaArchivo);
        this.lector = new FileReader(this.rutaArchivo);
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
                String[] simbolo = new String[0];
                simbolo[0] = linea.split(",")[1];
                Carta carta = (Carta)creador.crearElemento(linea.split(",")[0], simbolo);
                cartas.add(carta);
                linea = scanner.nextLine();
            }
        }
        catch(NoSuchElementException ignored){}

        scanner.close();
        return cartas;
    }
}
