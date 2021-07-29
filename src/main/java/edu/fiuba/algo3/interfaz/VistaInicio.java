package edu.fiuba.algo3.interfaz;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class VistaInicio extends VBox {

    Stage stage;

    public VistaInicio(Stage stage){
        super();
        this.stage = stage;

        ArrayList<TextField> jugadores = new ArrayList<>();

        TextField jugador1 = new TextField();
        jugador1.setPromptText("Jugador 1");
        jugadores.add(jugador1);
        TextField jugador2 = new TextField();
        jugador2.setPromptText("Jugador 2");
        jugadores.add(jugador2);
        TextField jugador3 = new TextField();
        jugador3.setPromptText("Jugador 3");
        jugadores.add(jugador3);
        TextField jugador4 = new TextField();
        jugador4.setPromptText("Jugador 4");
        jugadores.add(jugador4);
        TextField jugador5 = new TextField();
        jugador5.setPromptText("Jugador 5");
        jugadores.add(jugador5);
        TextField jugador6 = new TextField();
        jugador6.setPromptText("Jugador 6");
        jugadores.add(jugador6);

        Button inicio = new Button("Iniciar");
        ControladorInicio controladorInicio = new ControladorInicio(stage, jugadores);
        inicio.setOnAction(controladorInicio);

        this.getChildren().addAll(jugador1, jugador2, jugador3, jugador4, jugador5, jugador6, inicio);
    }
}
