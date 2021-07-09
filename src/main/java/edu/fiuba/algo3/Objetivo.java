package edu.fiuba.algo3;

public abstract class Objetivo {

    private String descripcion;
    public abstract void cumplido();

    public Objetivo(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

}
