package edu.fiuba.algo3;

import java.util.ArrayList;
import static java.lang.Math.min;

public class Batalla{

    private final Pais paisAtacado;
    private final Pais paisAtacante;
    private final int cantidadEjercitoAtacante;

    public Batalla(Pais atacado, Pais atacante, int cantidadEjercito, Jugador jugadorAtacante) throws PaisNoTePerteneceException, AtaqueAPaisPropioException, AtaqueConCantidadInvalidaException, PaisNoLimitrofeException{

        if(!atacado.esLimitrofeCon(atacante.getNombre()))
            throw new PaisNoLimitrofeException();

        if(!atacante.lePerteneceA(jugadorAtacante))
            throw new PaisNoTePerteneceException();

        if(atacado.lePerteneceA(jugadorAtacante))
            throw new AtaqueAPaisPropioException();

        if(atacante.getCantidadEjercitos() <= cantidadEjercito)
            throw new AtaqueConCantidadInvalidaException();

        paisAtacado = atacado;
        paisAtacante = atacante;
        cantidadEjercitoAtacante = cantidadEjercito;
    }

    private Pais determinarPerdedor(int dadoAtacante, int dadoAtacado){
        return (dadoAtacante <= dadoAtacado ? paisAtacante : paisAtacado);
    }

    public void ataqueEntrePaises(ArrayList<Integer> resultadosDadosAtacado, ArrayList<Integer> resultadosDadosAtacante) throws PaisNoLimitrofeException, PaisNoTePerteneceException, MovimientoConCantidadInvalidaException {

        for(int i = 0; i < min(resultadosDadosAtacado.size(), resultadosDadosAtacante.size()); i++){
            Pais perdedor = determinarPerdedor(resultadosDadosAtacante.get(i), resultadosDadosAtacado.get(i));
            perdedor.serAtacado();
        }
        paisAtacante.conquistar(paisAtacado);
    }

    public void batallar() throws PaisNoTePerteneceException, PaisNoLimitrofeException, AtaqueConCantidadInvalidaException, MovimientoConCantidadInvalidaException {
        ArrayList<Integer> resultadosDadosAtacante = Dados.lanzar(paisAtacante.atacantes(cantidadEjercitoAtacante));
        ArrayList<Integer> resultadosDadosAtacado = Dados.lanzar(paisAtacado.defensores());
        ataqueEntrePaises(resultadosDadosAtacado, resultadosDadosAtacante);
    }
}