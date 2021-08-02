package edu.fiuba.algo3.elementos;

public class CreadorDeCartas implements Creador{

    @Override
    public Object crear(Object... datos){
        String pais = (String)datos[0];
        String simbolo = (String)datos[1];
        return new Carta(pais,simbolo);
    }

    @Override
    public boolean esDeTipo(String tipo) {
        return tipo.equals("carta");
    }
}
