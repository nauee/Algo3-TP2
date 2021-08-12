package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.AlertaError;
import edu.fiuba.algo3.interfaz.SupervisorJuego;
import edu.fiuba.algo3.interfaz.controladores.ControladorJugada;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class VistaColocacion extends VistaJugada{


    public VistaColocacion(Juego juego, ArrayList<Pais> paises, SupervisorJuego supervisor, VentanaJugada stage){

        Text pregunta = new Text("Seleccione la cantidad de ejercitos a colocar:");
        //MenuOpcionesCantidad cantidades= new MenuOpcionesCantidad(pregunta, 1, juego.getCantidadFichasDisponibles(), "ejercitos", 30);
        Slider cantidades = new Slider(0,juego.getCantidadFichasDisponibles(),0);
        cantidades.setBlockIncrement(1);
        cantidades.setShowTickLabels(true);
        cantidades.setMinorTickCount(0);
        cantidades.setMajorTickUnit(1);
        cantidades.setSnapToTicks(true);
        HBox opciones= new HBox();
        Button jugar= new Button("Jugar");
        Button cancelar= new Button("Cancelar");
        jugar.setOnAction(e -> {
            try {
                juego.jugar((int)cantidades.getValue(), paises.get(0));
            } catch (PaisNoLimitrofeException | MovimientoConCantidadInvalidaException | PaisNoTePerteneceException | AtaqueConCantidadInvalidaException | FichasInsuficientesException | PaisNoExisteException | AtaqueAPaisPropioException ex) {
                AlertaError.mensajeError(ex.getMessage());
            }
            supervisor.limpiar();
            stage.close();
        });

        cancelar.setOnAction(e-> {
            supervisor.limpiar();
            stage.close();
        });
        opciones.getChildren().addAll(jugar, cancelar);
        getChildren().addAll(pregunta, cantidades, opciones);

    }
}
