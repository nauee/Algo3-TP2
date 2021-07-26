package edu.fiuba.algo3;

public class CanjeDinamico implements Canje {

    @Override
    public Canje siguienteCanje(int cantidadDeCanjes){
        return this;
    }

    @Override
    public int realizarCanje(int cantidadDeCanjes){
        return ((cantidadDeCanjes-1)*5);
    }
}
