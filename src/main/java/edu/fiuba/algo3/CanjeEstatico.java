package edu.fiuba.algo3;

class CanjeEstatico implements Canje {

    @Override
    public Canje siguienteCanje(int cantidadDeCanjes){
        if(cantidadDeCanjes>1){
            return new CanjeDinamico();
        }
        return this;
    }

    @Override
    public int realizarCanje(int cantidadDeCanjes){
        return 4 + ((3*(cantidadDeCanjes-1)));
    }
}
