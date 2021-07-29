package edu.fiuba.algo3.elementos;

public class CreadorDeCartas implements Creador{

    @Override
    public Object crear(String pais, String[] datos){
        return new Carta(pais,datos[0]);
    }

    @Override
    public boolean esDeTipo(String tipo) {
        return tipo.equals("carta");
    }
}
