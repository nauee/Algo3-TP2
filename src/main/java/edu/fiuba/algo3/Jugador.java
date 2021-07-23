package edu.fiuba.algo3;

import java.util.ArrayList;

public class Jugador{

    private static int proximoId = 1;

    private final String nombre;
    private final int id;
    private final ArrayList<Pais> paises = new ArrayList<>();
    private final ArrayList<Carta> cartas = new ArrayList<>();
    private Canje canje;
    private int cantidadDeCanjes;
    private int ejercitosAcumulados;

    public Jugador(String nombre){
        this.nombre = nombre;
        id = proximoId;
        proximoId++;
        this.cantidadDeCanjes =0;
        this.ejercitosAcumulados = 0;
    }

    public String getNombre(){
        return nombre;
    }

    public int getCantidadPaises() { return paises.size(); }

    public void agregarPais(Pais nuevoPais){
        paises.add(nuevoPais);
        nuevoPais.asignarDuenio(this);
    }

    public void perderPais(Pais paisAPerder){
        paises.remove(paisAPerder);
    }

    public int getCantidadFichas(){
        agregarEjercitos(paises.size()/2);
        return (ejercitosAcumulados);      //podriamos hacer que las fichas que se guarde de continente tambien le queden por convencion
    }

    public void agregarEjercitos(int unosEjercitos){
        ejercitosAcumulados += unosEjercitos;
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

    public void canjearCartas(Carta carta1, Carta carta2, Carta carta3, ArrayList<Carta> cartas){
        cantidadDeCanjes++;
        agregarEjercitos(canje.realizarCanje());
        canje = canje.siguienteCanje();
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);

    }

}

