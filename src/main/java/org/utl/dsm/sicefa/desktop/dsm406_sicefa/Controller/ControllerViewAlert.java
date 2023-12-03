package org.utl.dsm.sicefa.desktop.dsm406_sicefa.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControllerViewAlert {
    @FXML private Label lblTitulo;
    @FXML private Button btnAceptar;
    @FXML private Button btnCancelar;

    public Label getLblTitulo() {
        return lblTitulo;
    }

    public Button getBtnAceptar() {
        return btnAceptar;
    }

    public Button getBtnCancelar() {
        return btnCancelar;
    }
}
