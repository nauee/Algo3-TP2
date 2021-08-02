package edu.fiuba.algo3.elementos;

public class CreadorDeObjetivos implements Creador{


    @Override
    public Object crear(Object... datos) {
        return null;
    }

    @Override
    public boolean esDeTipo(String tipo) {
        return tipo.equals("objetivo");
    }
}
