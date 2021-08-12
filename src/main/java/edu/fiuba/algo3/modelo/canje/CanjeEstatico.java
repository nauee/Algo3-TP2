package edu.fiuba.algo3.modelo.canje;

public class CanjeEstatico implements Canje {
    private final int valorInicial = 4;
    private final int incremento = 3;

    @Override
    public Canje siguienteCanje(int cantidadDeCanjes){
        if(cantidadDeCanjes>1){
            return new CanjeDinamico();
        }
        return this;
    }

    @Override
    public int realizarCanje(int cantidadDeCanjes){
        return valorInicial + ((incremento*(cantidadDeCanjes-1)));
    }
}
