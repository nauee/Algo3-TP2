package edu.fiuba.algo3;

import java.util.ArrayList;

public class Jugador{

    private final String nombre;
    private final int id;
    private final ArrayList<Pais> paises = new ArrayList<>();

    public Jugador(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public int getID(){
        return id;
    }

    public void agregarPais(Pais nuevoPais){
        paises.add(nuevoPais);
        nuevoPais.asignarDuenio(this);
    }

    public void perderPais(Pais paisAPerder){
        paises.remove(paisAPerder);
    }
}