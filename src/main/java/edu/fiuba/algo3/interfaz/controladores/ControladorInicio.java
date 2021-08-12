package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.excepciones.NoSePudoLeerExcepcion;
import edu.fiuba.algo3.modelo.excepciones.PaisNoExisteException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoTePerteneceException;
import edu.fiuba.algo3.interfaz.AlertaError;
import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import edu.fiuba.algo3.interfaz.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.logica.Juego;
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

    public ControladorInicio(Stage stage, ArrayList<TextField> jugadores, MenuBarra menuArriba) {
        this.stage = stage;
        this.nombresJugadores=jugadores;
        this.menuArriba= menuArriba;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(!(this.esCantidadEsperada()))
            AlertaError.mensajeError("Por favor completa los nombres de todos los jugadores");
        else {
            try {
                ArrayList<Jugador> jugadores = this.nombresJugadores();
                Juego juego = new Juego(jugadores);
                Scene scene = new Scene(new VistaJuego(stage, juego, menuArriba), 1280, 720);
                stage.setScene(scene);
                stage.show();
            } catch (IOException | ParseException | PaisNoTePerteneceException | NoSePudoLeerExcepcion | PaisNoExisteException e) {
                e.printStackTrace();
            }
        }

    }

    private boolean esCantidadEsperada(){
        boolean cantidadCorrecta=true;
        for(TextField campo: nombresJugadores){
            if(campo.getText().isEmpty())
                cantidadCorrecta=false;
        }
        return cantidadCorrecta;
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
