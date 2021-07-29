package edu.fiuba.algo3.elementos;

import java.util.ArrayList;

public class CreadorDeElementos{

    protected String tipoElemento;
    private final ArrayList<Creador> creadores = new ArrayList<>();

    public CreadorDeElementos(String tipoElemento){
        this.tipoElemento = tipoElemento;
        creadores.add(new CreadorDeCartas());
        creadores.add(new CreadorDePaises());
    }

    public Object crearElemento(String pais, String[] datos){
        for (Creador creador : creadores){
            if (creador.esDeTipo(tipoElemento))
                return creador.crear(pais, datos);
        }
        return null;
    }
}
