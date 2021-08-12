package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.botones.BotonMediano;
import edu.fiuba.algo3.interfaz.controladores.ControladorSalir;
import edu.fiuba.algo3.interfaz.vistas.ImagenFondo;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AlertaResultado {

    public static void mensajeResultado (String mensajeAlerta, String titulo) {
        String rutaIcono= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/brujula.jpg";
        Stage informacion = new Stage();
        informacion.getIcons().add(new Image("file:"+System.getProperty("user.dir")+rutaIcono));
        Label info= new Label(mensajeAlerta);
        VBox textoInformacion = new VBox();
        BotonMediano ok = new BotonMediano("Ok", "Gabriola", new ControladorSalir(informacion));
        textoInformacion.setStyle("-fx-background-color: #AB8146; -fx-font-family: Gabriola; -fx-font-size: 18; -fx-font-weight: bold");
        info.setAlignment(Pos.CENTER);
        ok.setAlignment(Pos.BOTTOM_CENTER);
        textoInformacion.getChildren().addAll(info, ok);
        textoInformacion.setAlignment(Pos.CENTER);
        textoInformacion.setBackground(ImagenFondo.fondoJuego("/src/main/java/edu/fiuba/algo3/recursos/imagenes/brujula.jpg"));
        Scene pantallaInformacion= new Scene(textoInformacion, 400, 100);
        informacion.setScene(pantallaInformacion);
        informacion.setTitle(titulo);
        informacion.showAndWait();
    }

}
