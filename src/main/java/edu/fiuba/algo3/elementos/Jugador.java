package edu.fiuba.algo3.elementos;

import edu.fiuba.algo3.excepciones.CartaYaActivadaException;
import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public class Jugador{

    private static int proximoId = 1;

    private final String nombre;
    private final int id;
    private final ArrayList<Pais> paises = new ArrayList<>();
    private final ArrayList<Carta> cartas = new ArrayList<>();
    private Canje canje;
    private int cantidadDeCanjes;
    private EstadoJugador estado;
    private Objetivo objetivo;

    public Jugador(String nombre){
        this.nombre = nombre;
        cantidadDeCanjes = 0;
        id = proximoId;
        proximoId++;
        canje = new CanjeEstatico();
        estado = new EstadoVivo();
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

    public void activarCarta(Carta carta) throws CartaYaActivadaException {
        /*
        Carta cartaJugador = cartas.get(cartas.indexOf(carta));
        if (cartaJugador != null){
            Carta cartaActuazliada = cartaJugador.activarse(paises, this);
            cartas.remove(carta);
            cartas.add(cartaActuazliada);
        }*/
        if (cartas.contains(carta))
            carta = carta.activarse(paises, this);
        //no guarda la instamcia de CartaActivada
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
        cantidadDeCanjes++;
        int fichas = canje.realizarCanje(cantidadDeCanjes);
        canje = canje.siguienteCanje(cantidadDeCanjes);
        devolverCartasAlMazo(carta1, carta2, carta3, mazo);

        return fichas;
    }

    public boolean tienePais(Pais unPais) {
        return paises.contains(unPais);
    }

    public boolean conquistoMundo(){
        return paises.size() == 50;
    }

    public boolean derrotadoPor(Jugador jugador){
        return estado.derrotadoPor(jugador);
    }

    public boolean gano() {
        return estado.gano();
    }

    public boolean perdio(){
        return estado.perdio();
    }

    public void ganar(){
        estado = new EstadoGanador();
    }

    public void serDerrotadoPor(Jugador jugador) {
        estado = new EstadoDerrotado(jugador);
    }

    public void agregarObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }
}