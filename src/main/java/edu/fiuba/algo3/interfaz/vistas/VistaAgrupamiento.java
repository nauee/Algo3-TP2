package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.AlertaError;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class VistaAgrupamiento extends VistaJugada{

    public VistaAgrupamiento(Juego juego, ArrayList<Pais> paises){

        Text pregunta = new Text("Seleccione la cantidad de ejercitos a colocar:");
        Slider cantidadAElegir= new Slider(0, (double)paises.get(0).getCantidadEjercitos()-1, 1);
        HBox opciones= new HBox();
        Button jugar= new Button("Jugar");
        Button cancelar= new Button("Cancelar");
        jugar.setOnAction(ex-> {
            try {
                juego.jugar((int)cantidadAElegir.getValue(), paises.get(0), paises.get(1));
            } catch (PaisNoLimitrofeException | MovimientoConCantidadInvalidaException | PaisNoTePerteneceException | AtaqueConCantidadInvalidaException | FichasInsuficientesException | PaisNoExisteException | AtaqueAPaisPropioException e) {
                AlertaError.mensajeError(e.getMessage());

            }
        });
        opciones.getChildren().addAll(jugar, cancelar);
        getChildren().addAll(pregunta, cantidadAElegir, opciones);

    }
}
