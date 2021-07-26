package edu.fiuba.algo3;

import edu.fiuba.algo3.elementos.Dado;
import edu.fiuba.algo3.elementos.Pais;
import edu.fiuba.algo3.excepciones.*;

import java.util.ArrayList;
import static java.lang.Math.min;

public class Batalla{

    private final Pais paisAtacado;
    private final Pais paisAtacante;
    private final int cantidadEjercitoAtacante;

    public Batalla(Pais atacado, Pais atacante, int cantidadEjercito) throws AtaqueAPaisPropioException, PaisNoLimitrofeException {
        if(!atacado.esLimitrofeCon(atacante.getNombre()))
            throw new PaisNoLimitrofeException();

        if(atacado.mismoDuenio(atacante))
            throw new AtaqueAPaisPropioException();

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
        ArrayList<Integer> resultadosDadosAtacante = Dado.lanzar(paisAtacante.atacantes(cantidadEjercitoAtacante));
        ArrayList<Integer> resultadosDadosAtacado = Dado.lanzar(paisAtacado.defensores());
        ataqueEntrePaises(resultadosDadosAtacado, resultadosDadosAtacante);
    }
}