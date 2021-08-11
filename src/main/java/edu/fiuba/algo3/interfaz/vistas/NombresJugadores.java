package edu.fiuba.algo3.interfaz.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class NombresJugadores extends VBox {

    private ArrayList<TextField> nombres= new ArrayList<>();

    public NombresJugadores(int cantidad){
        for(int i=1;i<=cantidad;i++){
            Label lJugador = new Label("Nombre Jugador " + i);
            lJugador.setStyle("-fx-font-size: 20px; -fx-font-family: Gabriola");
            HBox.setMargin(lJugador,new Insets(0,25,0,0));
            TextField areaTextoNombreJugador = new TextField("");
            areaTextoNombreJugador.setStyle("-fx-background-color: #B2864B; -fx-border-color: #905A02;-fx-font-size: 30px; -fx-font-family: Gabriola; -fx-font-weight: bold ");
            HBox HBnombreJugador = new HBox();
            HBnombreJugador.getChildren().addAll(lJugador, areaTextoNombreJugador);
            HBnombreJugador.setAlignment(Pos.CENTER);
            nombres.add(areaTextoNombreJugador);
            this.getChildren().add(HBnombreJugador);
            this.setSpacing(5);
        }

    }
     public ArrayList<TextField> nombres(){
        return (this.nombres);
     }
}
