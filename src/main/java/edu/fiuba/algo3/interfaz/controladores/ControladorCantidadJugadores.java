package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.botones.BotonCantidad;
import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import edu.fiuba.algo3.interfaz.vistas.VistaNombresJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorCantidadJugadores implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final ArrayList<BotonCantidad> cantidades;
    private final MenuBarra menuArriba;

    public ControladorCantidadJugadores(Stage stage, ArrayList<BotonCantidad> cantidades, MenuBarra menuArriba) {
        this.stage = stage;
        this.cantidades=cantidades;
        this.menuArriba=menuArriba;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaNombresJugadores jugadores = new VistaNombresJugadores(stage, this.cantidadSeleccionada(), menuArriba);
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
