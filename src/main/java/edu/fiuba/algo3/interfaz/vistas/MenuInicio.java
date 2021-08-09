package edu.fiuba.algo3.interfaz.vistas;

import edu.fiuba.algo3.interfaz.botones.BotonMenuInicio;
import edu.fiuba.algo3.interfaz.controladores.ControladorMenuInicioInstrucciones;
import edu.fiuba.algo3.interfaz.controladores.ControladorMenuInicioJugar;
import edu.fiuba.algo3.interfaz.controladores.ControladorSalir;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuInicio extends VBox {

    public MenuInicio(Stage stage, MenuBarra menuArriba){
        super();

        BotonMenuInicio jugar= new BotonMenuInicio("Jugar", "-fx-font-size: 30px", 25, 274, new ControladorMenuInicioJugar(stage, menuArriba));
        BotonMenuInicio salir= new BotonMenuInicio("Salir", "-fx-font-size: 30px", 25, 274, new ControladorSalir(stage));
        BotonMenuInicio instrucciones= new BotonMenuInicio("Instrucciones", "-fx-font-size: 30px", 25, 274, new ControladorMenuInicioInstrucciones(stage));

        this.getChildren().addAll(jugar, instrucciones, salir);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

    }
}
