package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.vistas.Mapa;
import edu.fiuba.algo3.modelo.geografia.Pais;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

public class ReveladorBoton implements EventHandler<MouseEvent> {

    private final Button boton;
    private final String color;
    private final Mapa mapa;
    private final Pais pais;

    public ReveladorBoton(Button boton, Pais pais, Mapa mapa, String color){
        this.boton= boton;
        this.color= color;
        this.mapa=mapa;
        this.pais=pais;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        boton.setStyle("-fx-border-color: #795523 ;-fx-border-width: 2px 2px 2px 2px;-fx-font-weight: bold ; -fx-background-color:" + color);
        boton.setTextFill(Paint.valueOf("#FFFFFF"));
        mapa.mostrarInformacionPais(pais);
    }
}
