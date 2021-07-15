package edu.fiuba.algo3;

import java.util.Hashtable;

public class Jugador{

    private final String nombre;
    private final int id;
    private final Hashtable<String, Pais> paises = new Hashtable<>();

    public Jugador(String nombre, int id){

        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public int getCantidadPaises() { return paises.size(); }

    public int getID(){
        return id;
    }

    public void agregarPais(Pais nuevoPais){

        paises.putIfAbsent(nuevoPais.getNombre(), nuevoPais);
        nuevoPais.asignarDuenio(this);
    }

    public void perderPais(Pais paisAPerder){
        paises.remove(paisAPerder.getNombre());
    }

    public int getCantidadFichas(){
        return paises.size()/2;
    }
}

