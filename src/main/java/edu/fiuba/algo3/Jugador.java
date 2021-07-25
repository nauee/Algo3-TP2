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
        cantidadDeCanjes = 0;
        id = proximoId;
        proximoId++;
        canje = new CanjeEstatico();
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

    public int getCantidadFichasPorPais(){
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

    private void devolverCartasAlMazo(Carta carta1, Carta carta2, Carta carta3, ArrayList<Carta> mazo){
        cartas.remove(carta1);
        cartas.remove(carta2);
        cartas.remove(carta3);
        mazo.add(carta1);
        mazo.add(carta2);
        mazo.add(carta3);
    }

    public int canjearCartas(Carta carta1, Carta carta2, Carta carta3, ArrayList<Carta> mazo){
        int fichas =0;
        cantidadDeCanjes++;
        fichas = canje.realizarCanje(cantidadDeCanjes);
        canje = canje.siguienteCanje(cantidadDeCanjes);
        devolverCartasAlMazo(carta1, carta2, carta3, mazo);
        return fichas;
    }


}

