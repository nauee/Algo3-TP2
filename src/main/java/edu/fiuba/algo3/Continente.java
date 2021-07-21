package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Continente {

    private final String nombre;
    private final int recompensa;
    private final ArrayList<Pais> paises = new ArrayList<>();

    public Continente(String nombre, int recompensa){
        this.nombre = nombre;
        this.recompensa = recompensa;
    }

    public String getNombre(){
        return nombre;
    }

    public int getRecompensa(Jugador jugador){
        int recompensa = this.recompensa;
        for (Pais pais : paises) {
            recompensa = pais.getDuenio().equals(jugador) ? recompensa : 0;
        }
        return recompensa;
    }


    public void agregarPais(Pais pais){
        paises.add(pais);
    }

    public Pais getPais(String unPais) {
        Pais paisBuscado = null;

        for (Pais pais : paises)
            if (pais.getNombre().equals(unPais))
                paisBuscado = pais;

        return paisBuscado;
    }

    public ArrayList<Pais> getPaises(){
        return paises;
    }

    public int getCantidadPaises(){
        return paises.size();
    }
}