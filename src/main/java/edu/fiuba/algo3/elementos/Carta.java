package edu.fiuba.algo3.elementos;

import edu.fiuba.algo3.excepciones.CartaYaActivadaException;
import edu.fiuba.algo3.excepciones.PaisNoTePerteneceException;

import java.util.ArrayList;

public abstract class Carta {

    protected final String pais;
    protected final String simbolo;

    public Carta(String pais, String simbolo) {
        this.pais = pais;
        this.simbolo = simbolo;
    }

    public static boolean canjeables(Carta carta1, Carta carta2, Carta carta3){
        return carta1.esCanjeable(carta2, carta3) || (carta1.esComodin() || carta2.esComodin() || carta3.esComodin());
    }

    private boolean simbolosIguales(Carta carta1, Carta carta2){
        return (!simbolo.equals(carta1.getSimbolo())) && (!carta1.getSimbolo().equals(carta2.getSimbolo())) && (!carta2.getSimbolo().equals(simbolo));
    }

    private boolean simbolosDistintos(Carta carta1, Carta carta2){
        return (simbolo.equals(carta1.getSimbolo()))&&(carta1.getSimbolo().equals(carta2.getSimbolo()) && (simbolo.equals (carta2.getSimbolo())));
    }

    private boolean esCanjeable(Carta carta1, Carta carta2){
        return simbolosIguales(carta1, carta2) || simbolosDistintos(carta1, carta2);
    }

    private boolean esComodin(){
        return simbolo.equals("Comodin");
    }

    public String getPais(){
        return pais;
    }

    public String getSimbolo(){
        return simbolo;
    }

    protected Pais buscarPais (ArrayList <Pais> paises) throws PaisNoTePerteneceException {
        Pais pais = null;
        for(Pais paisBuscado : paises) {
            if (paisBuscado.equals(this.pais)) pais = paisBuscado;
        }

        if(pais == null) throw new PaisNoTePerteneceException();
        return pais;
    }

    public abstract Carta activarse(ArrayList<Pais> paises, Jugador jugador) throws CartaYaActivadaException;
}