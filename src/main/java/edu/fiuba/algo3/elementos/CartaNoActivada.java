package edu.fiuba.algo3.elementos;

import edu.fiuba.algo3.excepciones.PaisNoTePerteneceException;

public class CartaNoActivada implements EstadoCarta{

    @Override
    public EstadoCarta activarse(Jugador jugador, Pais pais){
        try{
            pais.agregarEjercitos(2, jugador);
            return new CartaActivada();
        }catch(PaisNoTePerteneceException exception){
            return this;
        }
    }
}