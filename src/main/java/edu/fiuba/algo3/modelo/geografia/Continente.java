package edu.fiuba.algo3.modelo.geografia;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;

public class Continente {

    private static final int TODOS_LOS_PAISES = 0;

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
            recompensa = pais.lePerteneceA(jugador) ? recompensa : 0;
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

    public boolean fueConquistado(ArrayList<Pais> paises, int cantidadPaises){
        int cantidadConquistada = 0;

        for (Pais pais : paises){
            if (this.paises.contains(pais))
                cantidadConquistada++;
        }

        if (cantidadPaises == TODOS_LOS_PAISES)
            return cantidadConquistada == this.paises.size();

        return cantidadPaises <= cantidadConquistada;
    }
}