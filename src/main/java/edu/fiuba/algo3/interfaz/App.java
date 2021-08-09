package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.vistas.VistaInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VistaInicio inicio = new VistaInicio(stage);
        Scene scene = new Scene(inicio, 1280, 720);
        stage.setScene(scene);
        stage.setTitle("A.L.T.E.G.O");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}