package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.AlertaError;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ControladorBotonCarta implements EventHandler<ActionEvent> {

    private final HBox contenedor;
    private final Carta carta;
    private final ArrayList<Carta> cartasSeleccionadas;
    private final Juego juego;
    private final Stage stage;

    public ControladorBotonCarta(HBox contenedor, Carta carta, ArrayList<Carta> cartasSeleccionadas, Juego juego, Stage stage){
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
                AlertaError.mensajeError("Se activo correctamente");
            } catch (CartaYaActivadaException | PaisNoTePerteneceException | NoSePuedeActivarCartaEnLaBatallaException ex) {
                AlertaError.mensajeError(ex.getMessage());
            }
            stage.close();
        } else {
            cartasSeleccionadas.add(carta);
            contenedor.setStyle("-fx-border-radius: 25% 25% 0 0; -fx-border-color: red; -fx-border-width: 2px 2px 0 2px;-fx-text-alignment: center");
            if (cartasSeleccionadas.size() == 3) {
                try {
                    juego.canjearCartas(cartasSeleccionadas.get(0),cartasSeleccionadas.get(1),cartasSeleccionadas.get(2));
                    AlertaError.mensajeError("Se canjearon correctamente");
                } catch (NoSePuedeCanjearEnEtapaBatallaException | SimbolosInvalidosException ex) {
                    AlertaError.mensajeError(ex.getMessage());
                }
                stage.close();
            }
        }
    }

}
