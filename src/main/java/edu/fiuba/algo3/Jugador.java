package edu.fiuba.algo3;

import java.util.Hashtable;

public class Jugador{

    private static int proximoId = 1;

    private final String nombre;
    private final int id;
    private final Hashtable<String, Pais> paises = new Hashtable<>();

    public Jugador(String nombre){

        this.nombre = nombre;
        id = proximoId;
        proximoId++;
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

