package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.interfaz.SupervisorJuego;
import edu.fiuba.algo3.interfaz.controladores.ControladorBotonPais;
import edu.fiuba.algo3.interfaz.vistas.Mapa;
import edu.fiuba.algo3.modelo.geografia.Pais;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;


public class BotonPais {

    private final Button boton;
    private final Pais pais;
    private final String color;
    private final Mapa mapa;

    public BotonPais(Pais pais, int posicionX, int posicionY, int ancho, int alto, Mapa mapa, SupervisorJuego supervisorJuego){
        this.pais=pais;
        boton = new Button(pais.getNombre());
        this.color= mapa.getColor(pais.getIdDuenio() -1);
        this.mapa=mapa;

        boton.setOnAction(new ControladorBotonPais(pais, supervisorJuego));
        boton.setLayoutX(posicionX);
        boton.setLayoutY(posicionY);
        boton.setPrefSize(ancho, alto);

        this.determinarComportamiento();
    }

    public Button getBoton(){
        return boton;
    }

    public Pais getPais(){
        return (this.pais);
    }

    private void determinarComportamiento(){
        boton.setTextFill(Paint.valueOf("#B5884B00"));
        boton.setStyle("-fx-background-color: #B5884B00; -fx-border-width: 2px 2px 2px 2px");
        boton.setOnMouseEntered(new ReveladorBoton(boton, pais, mapa, color));
        boton.setOnMouseExited(new OcultadorBoton(boton, mapa));
    }

    public void activar(Pais pais){
        if(this.pais.getNombre() == pais.getNombre()){
            boton.setStyle("-fx-border-color: #795523 ;-fx-border-width: 2px 2px 2px 2px;-fx-font-weight: bold ; -fx-background-color:" + color);
            boton.setTextFill(Paint.valueOf("#FFFFFF"));
            boton.setOnMouseEntered(new ReveladorBoton(boton, pais, mapa, color));
            boton.setOnMouseExited(new OcultadorBotonDeTurno(mapa));
        }
    }
}
