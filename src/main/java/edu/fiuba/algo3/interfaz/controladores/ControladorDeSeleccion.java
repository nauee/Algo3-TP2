package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.botones.BotonCantidad;
import edu.fiuba.algo3.interfaz.OpcionesCantidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorDeSeleccion implements EventHandler<ActionEvent> {

    private final OpcionesCantidad cantidades;
    private final BotonCantidad boton;

    public ControladorDeSeleccion(OpcionesCantidad cantidades, BotonCantidad boton){
        this.cantidades=cantidades;
        this.boton=boton;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        cantidades.desactivarOpciones();
        boton.setSelected(true);
    }
}
