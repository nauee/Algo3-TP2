package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.BotonCantidad;
import edu.fiuba.algo3.interfaz.vistas.VistaJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorCantidadJugadores implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final ArrayList<BotonCantidad> cantidades;

    public ControladorCantidadJugadores(Stage stage, ArrayList<BotonCantidad> cantidades) {
        this.stage = stage;
        this.cantidades=cantidades;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaJugadores jugadores = new VistaJugadores(stage, this.cantidadSeleccionada());
        Scene scene = new Scene(jugadores, 1280, 720);
        stage.setScene(scene);
    }

    private int cantidadSeleccionada(){
        int cantidadSeleccionada=0;
        for(int i=0; i<cantidades.size(); i++){
            if(cantidades.get(i).isSelected())
                cantidadSeleccionada=cantidades.get(i).getCantidad();
        }
        return cantidadSeleccionada;
    }
}
