package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.AlertaError;
import edu.fiuba.algo3.interfaz.SupervisorJuego;

import edu.fiuba.algo3.interfaz.controladores.ControladorCancelarJugada;
import edu.fiuba.algo3.interfaz.controladores.ControladorJugada;
import edu.fiuba.algo3.modelo.geografia.Pais;
import edu.fiuba.algo3.modelo.logica.Juego;

import java.util.ArrayList;

public class VistaColocacion extends VistaJugada{


    public VistaColocacion(Juego juego, ArrayList<Pais> paises, SupervisorJuego supervisor, VentanaJugada stage){
        super();
        menu= agregarOpcionesCantidadEjercitos("Seleccione la cantidad de ejercitos a colocar:", juego.getCantidadFichasDisponibles());
        ControladorJugada jugar = new ControladorJugada(juego, menu, paises, supervisor, stage);
        ControladorCancelarJugada cancelar= new ControladorCancelarJugada(supervisor, stage);
        getChildren().addAll(menu, botonesJugada(jugar, cancelar));
    }
}
