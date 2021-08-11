package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.excepciones.NoSePudoLeerExcepcion;
import edu.fiuba.algo3.excepciones.PaisNoExisteException;
import edu.fiuba.algo3.excepciones.PaisNoTePerteneceException;
import edu.fiuba.algo3.excepciones.SeAlcanzoLaCantidadMaximaException;
import edu.fiuba.algo3.interfaz.AlertaError;
import edu.fiuba.algo3.interfaz.vistas.MenuBarra;
import edu.fiuba.algo3.interfaz.vistas.VistaJuego;
import edu.fiuba.algo3.interfaz.vistas.VistaNombresJugadores;
import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorInicio implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final ArrayList<TextField> nombresJugadores;
    private final MenuBarra menuArriba;
    private final int cantidadEsperada;
    private final VistaNombresJugadores vistaAnterior;

    public ControladorInicio(Stage stage, int cantidad, ArrayList<TextField> jugadores, MenuBarra menuArriba, VistaNombresJugadores vistaAnterior) {
        this.stage = stage;
        this.nombresJugadores=jugadores;
        this.menuArriba= menuArriba;
        this.cantidadEsperada=cantidad;
        this.vistaAnterior= vistaAnterior;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<Jugador> jugadores = this.nombresJugadores();
        if(cantidadEsperada!=jugadores.size())
            AlertaError.mensajeError("Por favor completa los nombres de todos los jugadores");
        else {
            try {
                Juego juego = new Juego(jugadores);
                Scene scene = new Scene(new VistaJuego(stage, juego, menuArriba), 1280, 720);
                stage.setScene(scene);
                stage.show();
            } catch (SeAlcanzoLaCantidadMaximaException | IOException | ParseException | PaisNoTePerteneceException | NoSePudoLeerExcepcion | PaisNoExisteException e) {
                e.printStackTrace();
            }
        }

    }

    private ArrayList<Jugador> nombresJugadores(){
        ArrayList<Jugador> jugadores= new ArrayList<>();
        for(int i=0; i< nombresJugadores.size(); i++) {
            String nombre = nombresJugadores.get(i).getText();
            if (!nombre.isEmpty()){
                Jugador nuevoJugador = new Jugador(nombre);
                jugadores.add(nuevoJugador);
            }
        }
        return jugadores;
    }
}
