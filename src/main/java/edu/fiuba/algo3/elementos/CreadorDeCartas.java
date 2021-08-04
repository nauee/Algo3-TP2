package edu.fiuba.algo3.elementos;

public class CreadorDeCartas{

    public static Carta crear(String pais, String simbolo){
        return new Carta(pais,simbolo);
    }
}