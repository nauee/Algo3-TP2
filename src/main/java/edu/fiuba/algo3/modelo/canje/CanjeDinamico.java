package edu.fiuba.algo3.modelo.canje;

public class CanjeDinamico implements Canje {
    private final int incremento = 5;

    @Override
    public Canje siguienteCanje(int cantidadDeCanjes){
        return this;
    }

    @Override
    public int realizarCanje(int cantidadDeCanjes){
        return ((cantidadDeCanjes-1)*incremento);
    }
}
