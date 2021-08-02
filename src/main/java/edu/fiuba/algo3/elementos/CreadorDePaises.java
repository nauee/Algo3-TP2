package edu.fiuba.algo3.elementos;

import java.util.ArrayList;
import java.util.Arrays;

public class CreadorDePaises implements Creador{

    @Override
    public Object crear(Object... datos){
        ArrayList<String> fronteras = new ArrayList<>(Arrays.asList(datos));
        return new Pais(pais, fronteras);
    }

    @Override
    public boolean esDeTipo(String tipo) {
        return tipo.equals("pais");
    }
}
