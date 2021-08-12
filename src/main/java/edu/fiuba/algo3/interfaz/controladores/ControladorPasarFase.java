package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.excepciones.QuedanFichasPorColocarException;
import edu.fiuba.algo3.modelo.logica.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorPasarFase implements EventHandler<ActionEvent> {

    private final Juego juego;

    public ControladorPasarFase(Juego juego){
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            juego.pasarDeFase();
        } catch (QuedanFichasPorColocarException e) {
            e.printStackTrace();
        }
    }
}
