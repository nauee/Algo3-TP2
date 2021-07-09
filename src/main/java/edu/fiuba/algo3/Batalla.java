package edu.fiuba.algo3;

public class Batalla{

    private Pais paisAtacado;
    private Pais paisAtacante;

    public Batalla(Pais atacado, Pais atacante, int idAtacante) throws NoTePerteneceException, AtaqueAPaisPropioException {

        if(!atacante.lePerteneceA(idAtacante))
            throw new NoTePerteneceException();
        else if(atacado.lePerteneceA(idAtacante))
            throw new AtaqueAPaisPropioException();

        this.paisAtacado = atacado;
        this.paisAtacante = atacante;
    }
}