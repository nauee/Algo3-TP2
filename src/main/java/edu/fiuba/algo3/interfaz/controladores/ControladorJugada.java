package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.AlertaError;
import edu.fiuba.algo3.interfaz.botones.BotonCantidad;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ControladorJugada implements EventHandler<ActionEvent> {

    private final Juego juego;
    private final int  cantidad;
    private final ArrayList<Pais> paises;

    public ControladorJugada(Juego juego, int cantidad, ArrayList<Pais> paises){
        this.juego=juego;
        this.cantidad= cantidad;
        this.paises=paises;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            juego.jugar(cantidad, paises.get(0));
        } catch (PaisNoLimitrofeException | MovimientoConCantidadInvalidaException | PaisNoTePerteneceException | AtaqueConCantidadInvalidaException | FichasInsuficientesException | PaisNoExisteException | AtaqueAPaisPropioException e) {
            AlertaError.mensajeError(e.getMessage());
        }
    }


}
