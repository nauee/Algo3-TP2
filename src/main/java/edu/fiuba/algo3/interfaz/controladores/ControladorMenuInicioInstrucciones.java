package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.ImagenFondo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorMenuInicioInstrucciones implements EventHandler<ActionEvent> {

    private final Stage stage;

    public ControladorMenuInicioInstrucciones(Stage stage){
        this.stage=stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Stage ventanaInformacion= new Stage();
        ventanaInformacion.setTitle("Informacion");
        ventanaInformacion.initModality(Modality.APPLICATION_MODAL);
        ventanaInformacion.initOwner(stage);
        ventanaInformacion.getIcons().add(new Image("file:"+System.getProperty("user.dir")+"/src/main/java/edu/fiuba/algo3/recursos/imagenes/iconoInformacion.jpg"));
        AnchorPane instrucciones= new AnchorPane();
        instrucciones.setBackground(ImagenFondo.fondoJuego("/src/main/java/edu/fiuba/algo3/recursos/imagenes/pergaminoPapel.jpg"));
        Label texto= new Label("El juego se divide por fases indicadas en el cartel superior derecho. Dependiendo en que fase se encuentre la partida se podrán realizar distintas actividades seleccionando el boton del nombre del país en el que se quiera hacer la jugada. Para finalizar su turno, el jugador puede tocar el botón \"Pasar\" en la esquina superior izquierda\n\n" +
                "FASE ATAQUE: Se deben elegir dos países para realizar el ataque. El primer país será el atacante y el segundo el atacado, luego de seleccionar los paises se podran elegir con cuantos ejercitos atacar, en caso de que el ataque resulte en conquista se pasara un ejercito al país conquistado\n\n" +
                "FASE REAGRUPACION: Dos países propios son seleccionados para pasar fichas de un país a otro, el primer país será el que entregue los ejércitos\n\n" +
                "FASE COLOCACION: Se mostrara en un cuadro a la izquierda la cantidad de ejércitos disponibles que se tienen para usar en los países, los cuales pueden ser colocados seleccionando el país al que se desea reforzar, los ejercitos seran agregados uno a uno a medida que se vaya apretando el boton.\n\n" +
                "Cada jugador tendra una lista de cartas las cuales puede apretar dos veces para activar la carta si posee el pais de esta, o seleccionar tres cartas de simbolos distintos o simbolos iguales para canjearlas por mas fichas\n\n"+
                "El juego se dara por finalizado cuando se cumpla el objetivo personal, o bien se conquisten treinta paises");

        texto.setStyle("-fx-font-family: 'Book Antiqua'; -fx-font-size: 15; -fx-wrap-text: true; -fx-hgap: 2");
        texto.setMaxWidth(550);
        texto.setMaxHeight(550);
        texto.setTextAlignment(TextAlignment.CENTER);
        texto.setAlignment(Pos.CENTER);
        texto.setPadding(new Insets(25,25,25,25));

        instrucciones.getChildren().add(texto);
        Scene informacionTexto= new Scene(instrucciones, 550, 550);
        ventanaInformacion.setScene(informacionTexto);
        ventanaInformacion.show();
    }
}