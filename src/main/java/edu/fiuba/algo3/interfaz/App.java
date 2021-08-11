package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import edu.fiuba.algo3.interfaz.vistas.VistaInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private final double ancho=1280;
    private final double alto=660;
    private final String rutaIcono= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/iconoTEG.jpg";

    @Override
    public void start(Stage stage) {
        VistaInicio inicio = new VistaInicio(stage, new MenuBarra(stage));
        Scene scene = new Scene(inicio, ancho, alto);
        stage.setScene(scene);
        stage.setTitle("A.L.T.E.G.O");
        stage.getIcons().add(new Image("file:"+System.getProperty("user.dir")+rutaIcono));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}