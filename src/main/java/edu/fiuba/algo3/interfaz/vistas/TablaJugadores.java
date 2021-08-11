package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class TablaJugadores extends VBox {

    private final Juego juego;

    public TablaJugadores(Juego juego, ArrayList<String> colores ) {

        this.juego=juego;

        for (int i = 0; i < juego.getCantidadJugadores(); i++) {
            HBox jugador = new HBox();
            Label jugadorNombre = new Label(juego.getJugador(i).getNombre());
            jugadorNombre.setStyle("-fx-border-color: " + colores.get(i) + ";-fx-border-width: 3px 3px 3px 3px ; -fx-border-radius: 10%");
            if(jugadorNombre.getText() == juego.getNombreJugadorDeTurno())
                jugadorNombre.setStyle("-fx-border-color: " + colores.get(i) + ";-fx-border-width: 3px 3px 3px 3px ; -fx-border-radius: 10%; -fx-background-color:" + colores.get(i));
            jugadorNombre.setPadding(new Insets(0,0,0,10));
            jugadorNombre.setPrefSize(118, 52);
            jugador.setPrefSize(118, 52);
            jugador.setLayoutY(50 + i*75);
            jugador.getChildren().add(jugadorNombre);
            this.getChildren().add(jugador);
        }
        this.setSpacing(20);
        this.setStyle("-fx-font-family: Gabriola; -fx-font-weight: bold;  -fx-font-size: 30px");
    }
}
