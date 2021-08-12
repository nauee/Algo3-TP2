package edu.fiuba.algo3.interfaz;

import javafx.scene.control.Alert;

public class AlertaResultado {

    public static void mensajeError (String mensajeAlerta) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Error");
        alerta.setContentText(mensajeAlerta);
        alerta.showAndWait();
    }

}
