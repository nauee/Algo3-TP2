package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.AlertaError;
import edu.fiuba.algo3.interfaz.AlertaResultado;
import edu.fiuba.algo3.interfaz.musica.EfectoDeSonido;
import edu.fiuba.algo3.interfaz.vistas.VistaCarta;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ControladorBotonCarta implements EventHandler<ActionEvent> {

    private final VistaCarta contenedor;
    private final Carta carta;
    private final ArrayList<Carta> cartasSeleccionadas;
    private final Juego juego;
    private final Stage stage;
    private final String rutaSonidoActivarCarta = System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/sonidos/activarCarta.mp3";
    private final String rutaSondidoCanje = System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/sonidos/canjeExitoso.mp3";

    public ControladorBotonCarta(VistaCarta contenedor, Carta carta, ArrayList<Carta> cartasSeleccionadas, Juego juego, Stage stage){
        this.contenedor = contenedor;
        this.carta = carta;
        this.cartasSeleccionadas = cartasSeleccionadas;
        this.juego = juego;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (cartasSeleccionadas.contains(carta)) {
            try {
                juego.activarCarta(carta);
                EfectoDeSonido sonido = new EfectoDeSonido(new File(rutaSonidoActivarCarta));
                sonido.reproducir();
                AlertaResultado.mensajeResultado("Se activo correctamente la carta, obtuviste 2 ejercitos en " + carta.getPais().getNombre(), "Carta activada");
            } catch (CartaYaActivadaException | PaisNoTePerteneceException | NoSePuedeActivarCartaEnLaBatallaException ex) {
                AlertaError.mensajeError(ex.getMessage());
            }
            stage.close();
        } else {
            cartasSeleccionadas.add(carta);
            contenedor.subirCarta();
            if (cartasSeleccionadas.size() == 3) {
                try {
                    int fichasActuales = juego.getCantidadFichasDisponibles();
                    juego.canjearCartas(cartasSeleccionadas.get(0),cartasSeleccionadas.get(1),cartasSeleccionadas.get(2));
                    int fichasNuevas = juego.getCantidadFichasDisponibles() - fichasActuales;
                    EfectoDeSonido sonido = new EfectoDeSonido(new File(rutaSondidoCanje));
                    sonido.reproducir();
                    AlertaResultado.mensajeResultado("Se canjearon las cartas correctamente, obtuviste " + fichasNuevas + " fichas", "Canje correcto");
                } catch (NoSePuedeCanjearEnEtapaBatallaException | SimbolosInvalidosException ex) {
                    AlertaError.mensajeError(ex.getMessage());
                }
                stage.close();
            }
        }
    }

}
