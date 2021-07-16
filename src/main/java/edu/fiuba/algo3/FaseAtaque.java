package edu.fiuba.algo3;

import java.util.ArrayList;

import static java.lang.Math.min;

class FaseAtaque extends Fase {
    public void Jugar(Pais paisAtacante, Pais paisAtacado, int cantidadEjercitosAtacante){
        Batalla batalla = new Batalla (paisAtacado, paisAtacante, cantidadEjercitosAtacante);
        batalla.batallar();
    }
}
