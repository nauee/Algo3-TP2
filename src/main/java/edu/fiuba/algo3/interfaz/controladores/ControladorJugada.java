package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.AlertaError;
import edu.fiuba.algo3.interfaz.AlertaResultado;
import edu.fiuba.algo3.interfaz.SupervisorJuego;
import edu.fiuba.algo3.interfaz.botones.BotonCantidad;
import edu.fiuba.algo3.interfaz.menu.MenuCantidadEjercitos;
import edu.fiuba.algo3.interfaz.musica.EfectoDeSonido;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class ControladorJugada implements EventHandler<ActionEvent> {

    private final Juego juego;
    private final ArrayList<Pais> paises;
    private final SupervisorJuego supervisor;
    private final Stage ventana;
    private final MenuCantidadEjercitos cantidades;
    private final String rutaSonidoAtaque = System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/sonidos/3canones.mp3";
    private final String rutaSonidoTropas = System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/sonidos/tropas.mp3";
    private final ArrayList<File> sonidos = new ArrayList<>();
    private final String faseAtaque= "ataque";

    public ControladorJugada(Juego juego, MenuCantidadEjercitos opcionesCantidades, ArrayList<Pais> paises, SupervisorJuego supervisor, Stage stage){
        this.juego=juego;
        this.cantidades= opcionesCantidades;
        this.paises=paises;
        this.supervisor= supervisor;
        this.ventana=stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        inicializarSonidos();
        EfectoDeSonido sonido;
        try {
            if(paises.size()>1){
                int cantidadEjercitosAnterior = paises.get(0).getCantidadEjercitos();
                juego.jugar(cantidades.cantidadEjercitos(), paises.get(0), paises.get(1));
                sonido = new EfectoDeSonido(obtenerSonido(juego.nombreFase()));
                sonido.reproducir();
                mostrarResultadosBatalla(cantidadEjercitosAnterior);
            }
            else if(paises.size()==1) {
                juego.jugar(cantidades.cantidadEjercitos(), paises.get(0));
                sonido = new EfectoDeSonido(obtenerSonido(juego.nombreFase()));
                sonido.reproducir();
                mostrarResultadoColocacion();
            }

        } catch (PaisNoLimitrofeException | MovimientoConCantidadInvalidaException | PaisNoTePerteneceException | AtaqueConCantidadInvalidaException | FichasInsuficientesException | PaisNoExisteException | AtaqueAPaisPropioException ex) {
            AlertaError.mensajeError(ex.getMessage());
        }
        supervisor.limpiar();
        ventana.close();
    }

    private void mostrarResultadoColocacion() {
        AlertaResultado.mensajeResultado("Se colocaron satisfactoriamente " + cantidades.cantidadEjercitos() + " ejercitos en " + paises.get(0).getNombre(), "Colocación de ejercitos");
    }

    private void mostrarResultadosBatalla(int cantidadEjercitosAnterior) {
        Pais origen = paises.get(0);
        Pais destino = paises.get(1);
        Jugador atacante = juego.getJugadorDeTurno();
        int ejercitosPerdidos = cantidadEjercitosAnterior - origen.getCantidadEjercitos();
        String mensaje = "";
        String titulo = "";
        if (juego.getNombreFase().equals(faseAtaque)){
            if (destino.lePerteneceA(atacante)) {
                mensaje = "Conquistaste " + destino.getNombre() + ", en la batalla perdiste " + (ejercitosPerdidos - 1) + " ejercitos.";
                titulo = "Victoria en la batalla frente a " + destino.getNombre();
            } else {
                mensaje = "No pudiste conquistar " + destino.getNombre() + ", en la batalla perdiste " + ejercitosPerdidos + " ejercitos.";
                titulo = "Derrota en la batalla frente a " + destino.getNombre();
            }
        } else {
            mensaje = "Moviste " + ejercitosPerdidos + " ejercitos de " + origen.getNombre() + " a " + destino.getNombre() + ".";
            titulo = "Movimiento de ejercitos de " + origen.getNombre() + " a " + destino.getNombre();
        }
        AlertaResultado.mensajeResultado(mensaje, titulo);
    }

    private void inicializarSonidos(){
        sonidos.add(new File(rutaSonidoAtaque));
        sonidos.add(new File(rutaSonidoTropas));
    }

    private File obtenerSonido(String nombreFase){
        if (nombreFase.equals(faseAtaque))
            return sonidos.get(0);
        return sonidos.get(1);
    }
}