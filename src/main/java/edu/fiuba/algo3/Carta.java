package edu.fiuba.algo3;

public class Carta {

    private final String pais;
    private final String simbolo;

    public Carta(String pais, String simbolo) {
        this.pais = pais;
        this.simbolo = simbolo;
    }

    public String getPais(){
        return pais;
    }

    public String getSimbolo(){
        return simbolo;
    }
}