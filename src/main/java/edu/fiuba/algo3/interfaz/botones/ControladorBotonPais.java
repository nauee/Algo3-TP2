package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.modelo.geografia.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ControladorBotonPais implements EventHandler<ActionEvent> {

    ArrayList<Pais> paisesSeleccionados;
    private Pais pais;

    public ControladorBotonPais(Pais pais, ArrayList<Pais> paisesSeleccionados){
        this.paisesSeleccionados= paisesSeleccionados;
        this.pais= pais;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        paisesSeleccionados.add(pais);
    }
}
