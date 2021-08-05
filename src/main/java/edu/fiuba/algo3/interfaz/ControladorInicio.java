package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.elementos.Jugador;
import edu.fiuba.algo3.excepciones.NoSePudoLeerExcepcion;
import edu.fiuba.algo3.excepciones.PaisNoExisteException;
import edu.fiuba.algo3.excepciones.PaisNoTePerteneceException;
import edu.fiuba.algo3.excepciones.SeAlcanzoLaCantidadMaximaException;
import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ControladorInicio implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final ArrayList<TextField> nombresJugadores;

    public ControladorInicio(Stage stage, ArrayList<TextField> jugadores) {
        this.stage = stage;
        this.nombresJugadores=jugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<Jugador> jugadores = this.nombresJugadores();
        try {
            Juego juego = new Juego(jugadores);
            Scene scene = new Scene(new VistaJuego(stage, juego), 1280, 720);
            stage.setScene(scene);
            stage.show();
        } catch (SeAlcanzoLaCantidadMaximaException | IOException | ParseException | PaisNoTePerteneceException | NoSePudoLeerExcepcion | PaisNoExisteException e) {
            e.printStackTrace();
        }

    }

    private ArrayList<Jugador> nombresJugadores(){
        ArrayList<Jugador> jugadores= new ArrayList<>();
        for(int i=0; i< nombresJugadores.size(); i++) {
            String nombre = nombresJugadores.get(i).getText();
            if (!nombre.isEmpty()){
                Jugador nuevoJugador = new Jugador(nombre);
                jugadores.add(nuevoJugador);
            }
        }
        return jugadores;
    }
}
