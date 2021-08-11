package edu.fiuba.algo3.interfaz.vistas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class ImagenFondo{

    public static Background fondoParcial(String rutaImagen){
        Image image = new Image("file:"+System.getProperty("user.dir")+rutaImagen);
        ImageView vista = new ImageView(image);
        AnchorPane imagenFondo = new AnchorPane();
        imagenFondo.getChildren().addAll(vista);
        vista.setCache(true);
        vista.setPreserveRatio(true);
        BackgroundImage fondoConImagen= new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, false, false, true, false));
        return(new Background(fondoConImagen));
    }

    public static Background fondoTotal(String rutaImagen){
        Image image = new Image("file:"+System.getProperty("user.dir")+rutaImagen);
        ImageView vista = new ImageView(image);
        AnchorPane imagenFondo = new AnchorPane();
        imagenFondo.getChildren().addAll(vista);
        vista.setFitHeight(695);
        vista.setFitWidth(1149);
        vista.setLayoutX(154);
        vista.setCache(true);
        vista.setPreserveRatio(true);
        BackgroundImage fondoConImagen= new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        return (new Background(fondoConImagen));
    }

    public static Background fondoJuego(String rutaImagen){
        Image image = new Image("file:"+System.getProperty("user.dir")+rutaImagen);
        ImageView vista = new ImageView(image);
        AnchorPane imagenFondo = new AnchorPane();
        imagenFondo.getChildren().addAll(vista);
        vista.setFitHeight(695);
        vista.setFitWidth(1149);
        vista.setLayoutX(154);
        vista.setCache(true);
        vista.setPreserveRatio(true);
        BackgroundImage fondoConImagen= new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,  new BackgroundSize(1.0, 1.0, true, true, false, false));
        return (new Background(fondoConImagen));
    }


}
