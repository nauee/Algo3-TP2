package edu.fiuba.algo3;

class CanjeDinamico implements Canje {

    private static int cantidadDeCanjes = 2;
    @Override
    public Canje siguienteCanje(){
        return this;
    }

    @Override
    public int realizarCanje(){
        cantidadDeCanjes++;
        return ((cantidadDeCanjes-1)*5);
    }
}
