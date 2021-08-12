package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class TablaJugadores extends VBox {

    private final Juego juego;

    public TablaJugadores(Juego juego, ArrayList<String> colores ) {

        this.juego=juego;

        for (int i = 0; i < juego.getCantidadJugadores(); i++) {
            HBox jugador = new HBox();
            Label jugadorNombre = new Label(juego.getJugador(i).getNombre());
            jugadorNombre.setMaxWidth(120);
            jugadorNombre.setMinWidth(120);
            Background fondoNormal = new Background(new BackgroundFill(Color.valueOf(colores.get(i)+"AA"), new CornerRadii(10,0,0,10,false), Insets.EMPTY));
            Background fondoActivo = new Background(new BackgroundFill(Color.valueOf(colores.get(i)), new CornerRadii(10,0,0,10,false), Insets.EMPTY));
            jugadorNombre.setBackground(fondoNormal);
            jugadorNombre.setStyle("-fx-border-color: " + colores.get(i) + ";-fx-border-width: 3px 3px 3px 3px ; -fx-border-radius: 10 0 0 10; -fx-text-fill: #FFFFFF");
            if(jugadorNombre.getText() == juego.getNombreJugadorDeTurno()) {
                jugadorNombre.setBackground(fondoActivo);
                jugadorNombre.setMaxWidth(150);
                jugadorNombre.setMinWidth(150);
            }
            jugadorNombre.setPadding(new Insets(0,0,0,10));
            jugadorNombre.setPrefSize(118, 52);
            jugador.setAlignment(Pos.CENTER_RIGHT);
            jugador.setPrefSize(118, 52);
            jugador.setLayoutY(50 + i*75);
            jugador.getChildren().add(jugadorNombre);
            this.getChildren().add(jugador);
        }
        this.setSpacing(10);
        this.setStyle("-fx-font-family: Gabriola; -fx-font-weight: bold;  -fx-font-size: 30px");
    }
}
