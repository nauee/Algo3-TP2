package edu.fiuba.algo3;

import java.util.Hashtable;
import java.util.Map;

public class Continente {

    private final String nombre;
    private final int recompensa;
    private final Hashtable<String,Pais> paises = new Hashtable<>();

    public Continente(String nombre, int recompensa){
        this.nombre = nombre;
        this.recompensa = recompensa;
    }

    public String getNombre(){
        return nombre;
    }

    public int getRecompensa(Jugador jugador){
        int recompensa = this.recompensa;
        for (Map.Entry<String, Pais> entry : paises.entrySet()) {
            recompensa = entry.getValue().getDuenio().equals(jugador) ? recompensa : 0;
        }
        return recompensa;
    }


    public void agregarPais(Pais pais){
        paises.putIfAbsent(pais.getNombre(), pais);
    }

    public Pais getPais(String unPais) { return paises.get(unPais); }

    public Hashtable<String, Pais> getPaises(){
        return paises;
    }

    public int getCantidadPaises(){
        return paises.size();
    }
}