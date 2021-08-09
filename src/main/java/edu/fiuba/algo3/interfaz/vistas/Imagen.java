package edu.fiuba.algo3.interfaz.vistas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Imagen extends ImageView {

    public Imagen(String ruta, double altura, double ancho, double posicionX){
        super();
        Image image = new Image("file:"+System.getProperty("user.dir")+ruta);
        this.setImage(image);
        this.setFitHeight(altura);
        this.setFitWidth(ancho);
        this.setLayoutX(posicionX);
        this.setCache(true);
        this.setPreserveRatio(true);
    }
}
