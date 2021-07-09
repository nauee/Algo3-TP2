package edu.fiuba.algo3;

import static java.lang.Math.random;

public class Batalla{

    private Pais paisAtacado;
    private Pais paisAtacante;
    private int cantidadEjercito;

    public Batalla(){}

    public Batalla(Pais atacado, Pais atacante, int cantidadEjercito, int idAtacante) throws NoTePerteneceException, AtaqueAPaisPropioException {

        if(!atacante.lePerteneceA(idAtacante))
            throw new NoTePerteneceException();
        else if(atacado.lePerteneceA(idAtacante))
            throw new AtaqueAPaisPropioException();

        this.paisAtacado = atacado;
        this.paisAtacante = atacante;
        this.cantidadEjercito = cantidadEjercito;
    }

    public int lanzarDados(){
        return (int)(1+random()*6);
    }
}