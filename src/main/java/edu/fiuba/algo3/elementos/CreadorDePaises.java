package edu.fiuba.algo3.elementos;

import java.util.ArrayList;

public class CreadorDePaises{

    public static Pais crear(String pais, ArrayList<String> fronteras){
        return new Pais(pais, fronteras);
    }
}