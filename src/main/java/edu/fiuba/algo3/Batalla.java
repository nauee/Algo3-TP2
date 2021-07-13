package edu.fiuba.algo3;

import static java.lang.Math.random;
import static java.lang.Math.min;
import java.util.ArrayList;
import java.util.Collections;

public class Batalla{

    private final Pais paisAtacado;
    private final Pais paisAtacante;

    public Batalla(Pais atacado, Pais atacante, int cantidadEjercito, Jugador jugadorAtacante) throws NoTePerteneceException, AtaqueAPaisPropioException, AtaqueConCantidadInvalidaException {

        if(!atacante.lePerteneceA(jugadorAtacante))
            throw new NoTePerteneceException();
        else if(atacado.lePerteneceA(jugadorAtacante))
            throw new AtaqueAPaisPropioException();

        if(atacante.getCantidadEjercitos() <= cantidadEjercito)
            throw new AtaqueConCantidadInvalidaException();

        paisAtacado = atacado;
        paisAtacante = atacante;
    }

    public ArrayList<Integer> lanzarDados(int cantidad) {
        ArrayList<Integer> dados = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            dados.add((int) (1 + random() * 6));
        }
        Collections.sort(dados);
        return dados;
    }

    private Pais determinarPerdedor(int dadoAtacante, int dadoAtacado){
        return (dadoAtacante <= dadoAtacado ? this.paisAtacante : this.paisAtacado);
    }

    private void ataqueEntrePaises(ArrayList<Integer> resultadosDadosAtacado, ArrayList<Integer> resultadosDadosAtacante) {
        for(int i = 0; i < min(resultadosDadosAtacado.size(), resultadosDadosAtacante.size()); i++) {
            Pais perdedor = this.determinarPerdedor(resultadosDadosAtacante.get(i), resultadosDadosAtacado.get(i));
            perdedor.serAtacado();
        }
    }

    private void conquista() {
        if(paisAtacado.getCantidadEjercitos() <= 0){
            paisAtacado.serConquistadoPor(paisAtacante.getDuenio());
            paisAtacante.moverEjercitos(1, paisAtacado);
        }
    }

    public void batallar(ArrayList<Integer> resultadosDadosAtacado, ArrayList<Integer> resultadosDadosAtacante){
        this.ataqueEntrePaises(resultadosDadosAtacado, resultadosDadosAtacante);
        this.conquista();
    }
}