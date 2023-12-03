package org.utl.dsm.sicefa.desktop.dsm406_sicefa.Controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Popup;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerViewNuevaSucursal implements Initializable {

    @FXML private Button btnGuardarSucursal;
    @FXML private TextField txtCiudadSucursal;
    @FXML private TextField txtCodigoPostal;
    @FXML private TextField txtColoniaSucursal;
    @FXML private TextField txtDomicilio;
    @FXML private TextField txtEstadoSucursal;
    @FXML private TextField txtLatitudSucursal;
    @FXML private TextField txtLongitudSucursal;
    @FXML private TextField txtNombreSucursal;
    @FXML private TextField txtNombreTitular;
    @FXML private TextField txtRFCTitular;
    @FXML private TextField txtTelefonoSucursal;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnGuardarSucursal.setOnAction(event -> {
            try {
                avisoGuardarVenta();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private void avisoGuardarVenta() throws IOException {
        Popup popup = new Popup();
        FXMLLoader loader = new FXMLLoader(ControllerViewGestionSucursales.class.getResource("/org/utl/dsm/sicefa/desktop/dsm406_sicefa/view_alert.fxml"));
        Parent root = loader.load();
        ControllerViewAlert controller = loader.getController();
        Button btnAceptar = controller.getBtnAceptar();
        Button btnCancelar = controller.getBtnCancelar();
        btnAceptar.setOnAction(event -> {
                    // Código que se ejecutara si da clic en boton aceptar
           popup.hide();
            System.out.println("Antes de intentar invocar método 'guardarVenta'");
            try {
                guardarVenta();
            } catch (UnirestException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnCancelar.setOnAction(event -> {
            // Código que se ejecutara si da clic en boton cancelar
            popup.hide();
        });
        popup.getContent().add(root);
        popup.show(btnGuardarSucursal.getScene().getWindow());
    }

    private void guardarVenta() throws UnirestException, IOException {
         String nombreSucursal = txtNombreSucursal.getText();
         String titularSucursal = txtNombreTitular.getText();
         String rfcSucursal = txtRFCTitular.getText();
         String domicilioSucursal = txtDomicilio.getText();
         String coloniaSucursal = txtColoniaSucursal.getText();
         String codigoPostalSucursal =txtCodigoPostal.getText();
         String ciudadSucursal = txtCiudadSucursal.getText();
         String estadoSucursal = txtEstadoSucursal.getText();
         String telefonoSucursal = txtTelefonoSucursal.getText();
         String latitulSucursal = txtLatitudSucursal.getText();
         String longitudSucursal = txtLongitudSucursal.getText();
        // int estatusSucursal = txtEstatusSucursal.getText()
        HttpResponse<JsonNode> apiResponse = Unirest.post("http://localhost:8080/sicefa/api/sucursal/insertSucursalDIAP")
                .field("nombreSucursal",nombreSucursal)
                .field("titularSucursal",titularSucursal)
                .field("rfcSucursal",rfcSucursal)
                .field("domicilioSucursal",domicilioSucursal)
                .field("coloniaSucursal", coloniaSucursal)
                .field("codigoPostalSucursal", codigoPostalSucursal)
                .field("ciudadSucursal", ciudadSucursal)
                .field("estadoSucursal", estadoSucursal)
                .field("telefonoSucursal", telefonoSucursal)
                .field("latitudSucursal", latitulSucursal)
                .field("longitudSucursal", longitudSucursal)
                .asJson();
        System.out.println(apiResponse.getBody().toString());

        ControllerViewGestionSucursales gv = new ControllerViewGestionSucursales();
        gv.cargarSucursales();
        //String resultado = apiResponse.getBody().getObject().getString("result");
        //System.out.println(resultado);
        //alertaError(resultado);
        /*if (resultado.equals("null")){
            System.out.println("Datos Incorrectos!");
            mostrarAlerta("Datos Incorrectos!");
        }else{
            System.out.println("Login exitoso");
            mostrarAlerta("Login exitoso");
        }*/
    }

    private void alertaError(String msg) throws IOException {
        Popup popup = new Popup();
        FXMLLoader loader = new FXMLLoader(ControllerViewGestionSucursales.class.getResource("/org/utl/dsm/sicefa/desktop/dsm406_sicefa/view_alert.fxml"));
        Parent root = loader.load();
        ControllerViewAlert controller = loader.getController();
        Button btnAceptar = controller.getBtnAceptar();
        Button btnCancelar = controller.getBtnCancelar();
        btnAceptar.setOnAction(event -> {
            // Código que se ejecutara si da clic en boton aceptar
            popup.hide();
        });
        btnCancelar.setOnAction(event -> {
            // Código que se ejecutara si da clic en boton cancelar
            popup.hide();
        });
        popup.getContent().add(root);
        popup.show(btnGuardarSucursal.getScene().getWindow());
    }

}
