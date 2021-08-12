package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.vistas.Mapa;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class OcultadorBotonDeTurno implements EventHandler<MouseEvent> {

    private final Mapa mapa;

    public OcultadorBotonDeTurno(Mapa mapa){
        this.mapa=mapa;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        mapa.ocultarInformacionPais();
    }
}