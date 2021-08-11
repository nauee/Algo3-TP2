package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InformacionJuego extends VBox {

    private final Juego juego;
    private Text etapa;

    public InformacionJuego(Juego juego){
        this.juego=juego;
        this.etapa= new Text("Etapa: " + juego.nombreFase());
        Text jugadorDeTurno= new Text("Jugador de turno: " + juego.getNombreJugadorDeTurno());
       // Button jugar = new Button("Jugar");
        this.getChildren().addAll(etapa, jugadorDeTurno);
        this.setStyle("-fx-font-family: Gabriola; -fx-font-size: 25px; -fx-background-color: AB8146");
    }

}
