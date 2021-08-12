package edu.fiuba.algo3.interfaz.menu;

import edu.fiuba.algo3.interfaz.botones.BotonGrande;
import edu.fiuba.algo3.interfaz.controladores.ControladorMenuInicioInstrucciones;
import edu.fiuba.algo3.interfaz.controladores.ControladorMenuInicioJugar;
import edu.fiuba.algo3.interfaz.controladores.ControladorSalir;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuInicio extends VBox {

    public MenuInicio(Stage stage, MenuBarra menuArriba){
        super();

        BotonGrande jugar= new BotonGrande("Jugar", "Gabriola", new ControladorMenuInicioJugar(stage, menuArriba));
        BotonGrande salir= new BotonGrande("Salir", "Gabriola", new ControladorSalir(stage));
        BotonGrande instrucciones= new BotonGrande("Instrucciones", "Gabriola", new ControladorMenuInicioInstrucciones(stage));

        this.getChildren().addAll(jugar, instrucciones, salir);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
    }
}
