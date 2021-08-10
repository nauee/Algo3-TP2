package edu.fiuba.algo3.interfaz;

import javafx.scene.control.Alert;

public class AlertaError {

    public static void mensajeError (String mensajeAlerta) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("Error");
        alerta.setContentText(mensajeAlerta);
        alerta.showAndWait();
    }
}
