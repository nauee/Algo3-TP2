package edu.fiuba.algo3.elementos;

import edu.fiuba.algo3.excepciones.CartaYaActivadaException;
import edu.fiuba.algo3.excepciones.PaisNoTePerteneceException;

import java.util.ArrayList;

public class Carta {

    protected final String pais;
    protected final String simbolo;
    private EstadoCarta estado;

    public Carta(String pais, String simbolo) {
        this.pais = pais;
        this.simbolo = simbolo;
        estado = new CartaNoActivada();
    }

    public static boolean canjeables(Carta carta1, Carta carta2, Carta carta3){
        boolean sonIguales = carta1.canjearConIguales(carta2, carta3) && carta2.canjearConIguales(carta1, carta3);
        boolean sonDistintas = carta1.canjearConDiferentes(carta2, carta3) && carta2.canjearConDiferentes(carta1, carta3);
        return (sonIguales || sonDistintas || carta1.esComodin() || carta2.esComodin() || carta3.esComodin());
    }

    private boolean canjearConIguales(Carta carta1, Carta carta2){
        return ((carta1.simbolosIguales(simbolo) && carta2.simbolosIguales(simbolo)));
    }

    private boolean simbolosIguales(String simboloCarta){
        return (simbolo.equals(simboloCarta));
    }

    private boolean canjearConDiferentes(Carta carta1, Carta carta2){
        return ((carta1.simbolosDiferentes(simbolo) && carta2.simbolosDiferentes(simbolo)));
    }

    private boolean simbolosDiferentes(String simboloCarta){
        return (!simbolo.equals(simboloCarta));
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

    public void activarse(ArrayList<Pais> paises, Jugador jugador) throws CartaYaActivadaException {
        estado = estado.activarse(paises, jugador, pais);
    }
}