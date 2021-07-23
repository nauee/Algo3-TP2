package edu.fiuba.algo3;

class CanjeEstatico implements Canje {

    private static int cantidadDeCanjes = 0;

    @Override
    public Canje siguienteCanje(){
        if(cantidadDeCanjes>1){
            return new CanjeDinamico();
        }
        return this;
    }

    @Override
    public int realizarCanje(){
        cantidadDeCanjes++;
        return 4 + (3*(cantidadDeCanjes-1));
    }
}
