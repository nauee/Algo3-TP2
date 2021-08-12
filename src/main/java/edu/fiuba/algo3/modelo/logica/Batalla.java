package edu.fiuba.algo3.modelo.logica;

import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.elementos.Dado;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;
import static java.lang.Math.min;

public class Batalla{

    private final Pais atacado;
    private final Pais atacante;
    private final int cantidadEjercitoAtacante;

    public Batalla(Pais atacado, Pais atacante, int cantidadEjercitoAtacante) throws AtaqueAPaisPropioException, PaisNoLimitrofeException {
        if(!atacado.esLimitrofeCon(atacante.getNombre()))
            throw new PaisNoLimitrofeException();
        if(atacado.mismoDuenio(atacante))
            throw new AtaqueAPaisPropioException();

        this.atacado = atacado;
        this.atacante = atacante;
        this.cantidadEjercitoAtacante = cantidadEjercitoAtacante;
    }

    private Pais determinarPerdedor(int dadoAtacante, int dadoAtacado){
        return (dadoAtacante <= dadoAtacado ? atacante : atacado);
    }

    public void ataqueEntrePaises(ArrayList<Integer> resultadosDadosAtacado, ArrayList<Integer> resultadosDadosAtacante) throws PaisNoLimitrofeException, PaisNoTePerteneceException, MovimientoConCantidadInvalidaException {
        for(int i = 0; i < min(resultadosDadosAtacado.size(), resultadosDadosAtacante.size()); i++){
            Pais perdedor = determinarPerdedor(resultadosDadosAtacante.get(i), resultadosDadosAtacado.get(i));
            perdedor.serAtacado();
        }

        atacante.conquistar(atacado);
    }

    public void batallar() throws PaisNoTePerteneceException, PaisNoLimitrofeException, AtaqueConCantidadInvalidaException, MovimientoConCantidadInvalidaException {
        ArrayList<Integer> resultadosDadosAtacante = Dado.lanzar(atacante.atacantes(cantidadEjercitoAtacante));
        ArrayList<Integer> resultadosDadosAtacado = Dado.lanzar(atacado.defensores());
        ataqueEntrePaises(resultadosDadosAtacado, resultadosDadosAtacante);
    }
}