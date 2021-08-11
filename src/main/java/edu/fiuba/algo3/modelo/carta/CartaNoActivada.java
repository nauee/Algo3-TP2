package edu.fiuba.algo3.modelo.carta;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.excepciones.PaisNoTePerteneceException;

public class CartaNoActivada implements EstadoCarta {

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