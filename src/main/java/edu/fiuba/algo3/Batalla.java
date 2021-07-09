package edu.fiuba.algo3;

public class Batalla{

    private Pais paisAtacado;
    private Pais paisAtacante;

    public Batalla(Pais atacado, Pais atacante, int idAtacante){

        if(!atacante.lePerteneceA(idAtacante))
            throw new NoTePerteneceException;
        else if(atacado.lePertenece(idAtacante))
            throw new NoTePodesAtacarAVosMismoException;

        this.paisAtacado = atacado;
        this.paisAtacante = atacante;
    }
}