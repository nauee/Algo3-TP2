package edu.fiuba.algo3.interfaz.botones;

import edu.fiuba.algo3.modelo.geografia.Pais;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import edu.fiuba.algo3.interfaz.controladores.ControladorBotonPais;


import java.util.ArrayList;

public class BotonPais {

    private final Button boton;
    private final Pais pais;
    private final ArrayList<String> colores;

    public BotonPais(Pais pais, int posicionX, int posicionY, int ancho, int alto,  ArrayList<String> colores, ArrayList<Pais> paisesSeleccionados){
        this.pais=pais;
        boton = new Button(pais.getNombre());
        this.colores=colores;

        boton.setOnAction(new ControladorBotonPais(pais, paisesSeleccionados));
        boton.setLayoutX(posicionX);
        boton.setLayoutY(posicionY);
        boton.setPrefSize(ancho, alto);
        /*boton.setTextFill(Paint.valueOf("#B5884B00"));
        boton.setStyle("-fx-background-color: #B5884B00; -fx-border-width: 2px 2px 2px 2px");
        boton.setRotate(0);
        String color= colores.get(pais.getDuenio().getId() -1 );
        boton.setStyle("-fx-border-color: #795523 ;-fx-border-width: 2px 2px 2px 2px;-fx-font-weight: bold ; -fx-background-color:" + color);
        boton.setTextFill(Paint.valueOf("#000000"));*/

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
        boton.setText(pais.getNombre());
        boton.setOnMouseEntered(e-> {
            String color= colores.get(pais.getDuenio().getId()-1);
            boton.setStyle("-fx-border-color: #795523 ;-fx-border-width: 2px 2px 2px 2px;-fx-font-weight: bold ; -fx-background-color:" + color);
            boton.setTextFill(Paint.valueOf("#000000"));
        });
        boton.setOnMouseExited(e-> {
            boton.setTextFill(Paint.valueOf("#B5884B00"));
            boton.setStyle("-fx-background-color: #B5884B00; -fx-border-width: 2px 2px 2px 2px");
            boton.setText(pais.getNombre());
        });
    }

    public void activar(Pais pais){
        if(this.pais.getNombre() == pais.getNombre()){
            String color= colores.get(pais.getDuenio().getId() -1 );
            boton.setStyle("-fx-border-color: #795523 ;-fx-border-width: 2px 2px 2px 2px;-fx-font-weight: bold ; -fx-background-color:" + color);
            boton.setTextFill(Paint.valueOf("#000000"));
            boton.setOnMouseEntered(e-> {
                boton.setStyle("-fx-border-color: #795523 ;-fx-border-width: 2px 2px 2px 2px;-fx-font-weight: bold ; -fx-background-color:" + color);
                boton.setTextFill(Paint.valueOf("#000000"));
            });
            boton.setOnMouseExited(e-> {
                boton.setStyle("-fx-border-color: #795523 ;-fx-border-width: 2px 2px 2px 2px;-fx-font-weight: bold ; -fx-background-color:" + color);
                boton.setTextFill(Paint.valueOf("#000000"));
            });
        }
    }


}
