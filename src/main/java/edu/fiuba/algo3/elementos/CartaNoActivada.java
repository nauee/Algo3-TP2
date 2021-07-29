package edu.fiuba.algo3.elementos;

import edu.fiuba.algo3.excepciones.PaisNoTePerteneceException;

import java.util.ArrayList;

public class CartaNoActivada implements EstadoCarta{

    private Pais buscarPais (ArrayList <Pais> paises, String nombrePais) throws PaisNoTePerteneceException {
        Pais pais = null;
        for(Pais paisBuscado : paises) {
            if (paisBuscado.equals(nombrePais)) pais = paisBuscado;
        }

        if(pais == null) throw new PaisNoTePerteneceException();
        return pais;
    }

    @Override
    public EstadoCarta activarse(ArrayList<Pais> paises, Jugador jugador, String nombrePais){
        try{
            Pais pais = buscarPais(paises, nombrePais);
            pais.agregarEjercitos(2, jugador);
            return new CartaActivada();
        }catch(PaisNoTePerteneceException exception){
            return this;
        }
    }
}