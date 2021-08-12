package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.excepciones.PaisNoTePerteneceException;
import edu.fiuba.algo3.modelo.geografia.Continente;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.excepciones.CartaYaActivadaException;
import edu.fiuba.algo3.modelo.canje.Canje;
import edu.fiuba.algo3.modelo.canje.CanjeEstatico;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;

import java.util.ArrayList;

public class Jugador{

    private static int proximoId = 1;
    private static final int CANTIDAD_MINIMA_PARA_CONQUISTA = 30;

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

    public static void reiniciarID() {
        proximoId = 1;
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

    public void activarCarta(Carta carta) throws CartaYaActivadaException, PaisNoTePerteneceException {
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
        return paises.size() == CANTIDAD_MINIMA_PARA_CONQUISTA;
    }

    public boolean derrotadoPor(Jugador jugador){
        return estado.derrotadoPor(jugador);
    }

    public boolean conquisto(Continente continente, int cantidadPaises){
        return continente.fueConquistado(paises, cantidadPaises);
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

    public int getId(){
        return id;
    }

    public ArrayList<Pais> getPaises(){
        return paises;
    }

    public boolean objetivoCumplido(){
        return objetivo.cumplido(this);
    }

    public String getObjetivoDescripcion(){
        return objetivo.getDescripcion();
    }

    public boolean seQuedoSinPaises(){
        return paises.size()==0;
    }
}