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
        if (cartas.contains(carta))
            carta.activarse(this);
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
        return paises.size() == 30;
    }

    public boolean derrotadoPor(Jugador jugador){
        return estado.derrotadoPor(jugador);
    }

    public boolean conquisto(Continente continente, int cantidadPaises){
        int cantidadConquistada = 0;

        for (Pais pais : paises) {
            if (continente.tiene(pais))
                cantidadConquistada++;
        }

        if (cantidadPaises == 0)
            return cantidadConquistada == continente.getCantidadPaises();

        return cantidadPaises <= cantidadConquistada;
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

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
}