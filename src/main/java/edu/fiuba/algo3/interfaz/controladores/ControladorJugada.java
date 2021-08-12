package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.AlertaError;
import edu.fiuba.algo3.interfaz.SupervisorJuego;
import edu.fiuba.algo3.interfaz.botones.BotonCantidad;
import edu.fiuba.algo3.interfaz.menu.MenuCantidadEjercitos;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ControladorJugada implements EventHandler<ActionEvent> {

    private final Juego juego;
    private final ArrayList<Pais> paises;
    private final SupervisorJuego supervisor;
    private final Stage ventana;
    private final MenuCantidadEjercitos cantidades;

    public ControladorJugada(Juego juego, MenuCantidadEjercitos opcionesCantidades, ArrayList<Pais> paises, SupervisorJuego supervisor, Stage stage){
        this.juego=juego;
        this.cantidades= opcionesCantidades;
        this.paises=paises;
        this.supervisor= supervisor;
        this.ventana=stage;

    }


    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            if(paises.size()>1)
                juego.jugar(cantidades.cantidadEjercitos(), paises.get(0), paises.get(1));
            else if(paises.size()==1)
                juego.jugar(cantidades.cantidadEjercitos(), paises.get(0));
        } catch (PaisNoLimitrofeException | MovimientoConCantidadInvalidaException | PaisNoTePerteneceException | AtaqueConCantidadInvalidaException | FichasInsuficientesException | PaisNoExisteException | AtaqueAPaisPropioException ex) {
            AlertaError.mensajeError(ex.getMessage());
        }
        supervisor.limpiar();
        ventana.close();
    }
}
