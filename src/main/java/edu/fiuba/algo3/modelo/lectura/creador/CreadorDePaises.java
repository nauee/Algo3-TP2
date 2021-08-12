package edu.fiuba.algo3.modelo.lectura.creador;

import edu.fiuba.algo3.modelo.geografia.Pais;

import java.util.ArrayList;

public class CreadorDePaises{

    public static Pais crear(String pais, ArrayList<String> fronteras){
        return new Pais(pais, fronteras);
    }
}