package edu.fiuba.algo3;

import java.util.ArrayList;

public class Jugador{

    private static int proximoId = 1;

    private final String nombre;
    private final int id;
    private final ArrayList<Pais> paises = new ArrayList<>();
    private final ArrayList<Carta> cartas = new ArrayList<>();

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

        paises.add(nuevoPais);
        nuevoPais.asignarDuenio(this);
    }

    public void perderPais(Pais paisAPerder){
        paises.remove(paisAPerder);
    }

    public int getCantidadFichas(){
        return paises.size()/2;
    }

    public void darleCarta(Carta carta) {
        cartas.add(carta);
    }

    public void activarCarta(Carta carta){
        carta.activarse(paises, this);
    }

    public int getCantidadCartas(){
        return cartas.size();
    }

}

