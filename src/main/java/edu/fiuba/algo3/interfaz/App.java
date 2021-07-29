package edu.fiuba.algo3.interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        /*Image image = new Image("file:"+System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/interfaz/tableroteg.jpg");
        ImageView vista = new ImageView(image);
        vista.setCache(true);
        vista.setPreserveRatio(true);

        BorderPane pane = new BorderPane();

        VBox opciones = new VBox();
        Button colocar = new Button("Colocar");
        Button batalla = new Button("Batalla");
        Button reagrupar = new Button("Reagrupar");

        opciones.getChildren().addAll(colocar, batalla, reagrupar);
        pane.setRight(opciones);

        vista.fitWidthProperty().bind(stage.widthProperty());
        vista.fitHeightProperty().bind(stage.heightProperty());
        pane.setCenter(vista);*/

        VistaInicio inicio = new VistaInicio(stage);
        Scene scene = new Scene(inicio, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}