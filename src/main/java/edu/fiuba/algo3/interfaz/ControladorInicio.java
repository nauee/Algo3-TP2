package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.elementos.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

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

    }

    private ArrayList<Jugador> nombresJugadores(){
        ArrayList<Jugador> jugadores= new ArrayList<>();
        for(int i=0; i< nombresJugadores.size(); i++) {
            Jugador nuevoJugador = new Jugador(nombresJugadores.get(i).getText());
            jugadores.add(nuevoJugador);
        }
        return jugadores;
    }
}
