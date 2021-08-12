package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.VentanaConfirmacion;
import edu.fiuba.algo3.interfaz.botones.BotonMediano;
import edu.fiuba.algo3.interfaz.menu.MenuBarra;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorNuevoJuego implements EventHandler<ActionEvent> {

    Stage stage;
    MenuBarra menuArriba;
    private final String rutaIcono= "/src/main/java/edu/fiuba/algo3/recursos/imagenes/brujula.jpg";

    public ControladorNuevoJuego(Stage stage, MenuBarra menuArriba){
        this.stage=stage;
        this.menuArriba=menuArriba;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        HBox opciones= new HBox();
        VentanaConfirmacion confirmacion=new VentanaConfirmacion("Crear un nuevo juego", opciones);
        Stage ventanaConfirmacion = new Stage();
        ventanaConfirmacion.getIcons().add(new Image("file:"+System.getProperty("user.dir")+rutaIcono));
        ventanaConfirmacion.setTitle("Crear un nuevo juego");
        ventanaConfirmacion.initModality(Modality.APPLICATION_MODAL);
        ventanaConfirmacion.initOwner(stage);
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(10);
        BotonMediano confirmar= new BotonMediano("Si", "Gabriola", new ControladorVolverAlPrincipio(stage, menuArriba, ventanaConfirmacion));
        BotonMediano negar= new BotonMediano("No", "Gabriola", new ControladorCancelarNuevoJuego(ventanaConfirmacion));
        opciones.getChildren().addAll(confirmar,negar);
        Scene escenaConfirmacion = new Scene(confirmacion);
        ventanaConfirmacion.setScene(escenaConfirmacion);
        ventanaConfirmacion.show();
    }
}
