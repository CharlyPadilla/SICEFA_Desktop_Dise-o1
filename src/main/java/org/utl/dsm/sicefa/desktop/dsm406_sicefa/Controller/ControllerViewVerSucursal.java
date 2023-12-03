package org.utl.dsm.sicefa.desktop.dsm406_sicefa.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.utl.dsm.sicefa.desktop.dsm406_sicefa.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerViewVerSucursal implements Initializable {

    // Elementos de Ver Sucursal
    @FXML private Button btnCerrarVistaSucursal;
    @FXML private Label labelCiudad;
    @FXML private Label labelCodigoPostal;
    @FXML private Label labelColonia;
    @FXML private Label labelDomicilio;
    @FXML private Label labelEstado;
    @FXML private Label labelLatitud;
    @FXML private Label labelLongitud;
    @FXML private Label labelNombreSucursal;
    @FXML private Label labelRFC;
    @FXML private Label labelTelefono;
    @FXML private Label labelTitular;

    private Sucursal sucursal;

    public ControllerViewVerSucursal() {}

    public void inicializar(Sucursal newValue) throws IOException {
        sucursal = newValue;
        mostrarSeleccion(sucursal);

    }

    public void cargarVistaSucursal() throws IOException {
        System.out.println("Abriendo Vista Sucursal...");
        Stage stage = new Stage();
        stage.setResizable(false);
        URL fxmlUrl = Main.class.getResource("view_verSucursal.fxml");
        //System.out.println("FXML URL: " + fxmlUrl);
        Parent root = FXMLLoader.load(fxmlUrl);
        // root = FXMLLoader.load(Main.class.getResource("view_verSucursal.fxml"));

        Scene scene = new Scene(root, 540, 480);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();

        btnCerrarVistaSucursal.setOnAction(event -> {
            cerrarVistaSucursal(stage);
        });
    }

    public void mostrarSeleccion(Sucursal sucursalSeleccionada) throws IOException {

        sucursal = sucursalSeleccionada;
        //Platform.runLater(() -> {
            // Código para actualizar los elementos de la interfaz de usuario
            labelNombreSucursal.setText(sucursalSeleccionada.getNombreSucursal());
            labelTitular.setText(sucursalSeleccionada.getTitularSucursal());
            labelRFC.setText(sucursalSeleccionada.getRfcSucursal());
            labelDomicilio.setText(sucursalSeleccionada.getDomicilioSucursal());
            labelColonia.setText(sucursalSeleccionada.getColoniaSucursal());
            labelCodigoPostal.setText(sucursalSeleccionada.getCodigoPostalSucursal());
            labelCiudad.setText(sucursalSeleccionada.getCiudadSucursal());
            labelEstado.setText(sucursalSeleccionada.getEstadoSucursal());
            labelTelefono.setText(sucursalSeleccionada.getTelefonoSucursal());
            labelLatitud.setText(sucursalSeleccionada.getLatitulSucursal());
            labelLongitud.setText(sucursalSeleccionada.getLongitudSucursal());
        //});
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        labelNombreSucursal.setText("----");
        labelTitular.setText("....");
        labelRFC.setText("...");
        labelDomicilio.setText("....");
        labelColonia.setText("...");
        labelCodigoPostal.setText("....");
        labelCiudad.setText("....");
        labelEstado.setText("....");
        labelTelefono.setText("....");
        labelLatitud.setText("....");
        labelLongitud.setText("....");
    }

    public void cerrarVistaSucursal(Stage stage) {
        stage.close();
    }
}
