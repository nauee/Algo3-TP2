package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.vistas.Mapa;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

public class OcultadorBoton implements EventHandler<MouseEvent> {

    private final Button boton;
    private final Mapa mapa;

    public OcultadorBoton (Button boton, Mapa mapa){
        this.boton= boton;
        this.mapa=mapa;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        boton.setTextFill(Paint.valueOf("#B5884B00"));
        boton.setStyle("-fx-background-color: #B5884B00; -fx-border-width: 2px 2px 2px 2px");
        mapa.ocultarInformacionPais();
    }
}
