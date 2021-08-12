package edu.fiuba.algo3.modelo.carta;

import edu.fiuba.algo3.modelo.excepciones.PaisNoTePerteneceException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.CartaYaActivadaException;

public class Carta {

    private final Pais pais;
    private final String simbolo;
    private EstadoCarta estado;

    public Carta(Pais pais, String simbolo) {
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

    public Pais getPais(){
        return pais;
    }

    public String getSimbolo(){
        return simbolo;
    }

    public void activarse(Jugador jugador) throws CartaYaActivadaException, PaisNoTePerteneceException {
        estado = estado.activarse(jugador, pais);
    }
}