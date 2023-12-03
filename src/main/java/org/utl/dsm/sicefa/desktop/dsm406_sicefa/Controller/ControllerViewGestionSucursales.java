package org.utl.dsm.sicefa.desktop.dsm406_sicefa.Controller;

//import com.fasterxml.jackson.core.type.TypeReference;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.*;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.utl.dsm.sicefa.desktop.dsm406_sicefa.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;


public class ControllerViewGestionSucursales implements Initializable {

    // Elementos de Gestión de Sucursales
    @FXML private Button btnNuevaSucursal;
    @FXML private TableView<Sucursal> tblSucursales;
    @FXML private TableColumn<Sucursal, String> tcolIdSucursal;
    @FXML private TableColumn<Sucursal, String> tcolNombreSucursal;
    @FXML private TableColumn<Sucursal, String> tcolTitular;
    @FXML private TableColumn<Sucursal, String> tcolTelefonoSucursal;
    @FXML private TableColumn<Sucursal, String> tcolEstatusSucursal;

    // Elementos de Ver Sucursal
   /* @FXML private Button btnCerrarVistaSucursal;
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
    @FXML private Label labelTitular;*/


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cargarSucursales();
           
            tblSucursales.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    try {
                        ControllerViewVerSucursal verSucursal = new ControllerViewVerSucursal();
                        verSucursal.cargarVistaSucursal();
                        verSucursal.mostrarSeleccion(newValue);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnNuevaSucursal.setOnAction(event -> {
            try {
                nuevaSucursal();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }


    void cargarSucursales() throws UnirestException, IOException {
        try {
            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/sicefa/api/sucursal/getAll")
                    .asJson();

            System.out.println(apiResponse.getBody().toString());
            String registros = apiResponse.getBody().toString();
            Gson gson = new Gson();

           Sucursal[] arraySucursal = gson.fromJson(registros, Sucursal[].class);
            //System.out.println(arraySucursal[0].toString());
            System.out.println(registros);
            ArrayList<Sucursal> listaSucursal = new ArrayList<>(Arrays.asList(arraySucursal));

            ObservableList<Sucursal> registrosSucursal = FXCollections.observableArrayList(listaSucursal);
            tblSucursales.setItems(registrosSucursal);
            tcolIdSucursal.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getIdSucursal()).asString());
            tcolNombreSucursal.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getNombreSucursal()));
            tcolTitular.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTitularSucursal()));
            tcolTelefonoSucursal.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTelefonoSucursal()));
            tcolEstatusSucursal.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getEstatusSucursal()).asString());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Fallo al cargar Sucursales");
        }
    }

    public void cargarVistaSucursal(Sucursal sucursal) throws IOException {
        //System.out.println("Id de sucursal seleccionada: "+sucursalSeleccionada.getIdSucursal());

        System.out.println("Abriendo Vista Sucursal...");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view_verSucursal.fxml"));
        Parent root = loader.load();

        ControllerViewVerSucursal controllerverSucursal = null;
        // Pasa los datos del registro seleccionado al controlador de la nueva ventana
        controllerverSucursal.mostrarSeleccion(sucursal);

        Stage stage = new Stage();
        stage.setResizable(false);
        Scene scene = new Scene(root, 540, 480);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();


    }





    private void nuevaSucursal() throws IOException {
        System.out.println("Abriendo Nueva Sucursal...");
        Stage stage = new Stage();
        stage.setResizable(false);
        URL fxmlUrl = Main.class.getResource("view_nuevaSucursal.fxml");
        System.out.println("FXML URL: " + fxmlUrl);
        Parent root = FXMLLoader.load(fxmlUrl);
         root = FXMLLoader.load(Main.class.getResource("view_nuevaSucursal.fxml"));

        Scene scene = new Scene(root,540,480);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        //stage.setTitle("Nueva Venta");
        stage.show();
        // Para cerrar la ventana Login:
        // Stage ventanaLogin =(Stage) btnNuevaVenta.getScene().getWindow();
        //ventanaLogin.close();
    }

 
}



/*
             ***** MOSTRAR VENTANA *****
        private void mostarAlerta(String mensaje) throws IOException {
        Popup popup = new Popup();
        FXMLLoader loader = new FXMLLoader(ControllerViewLogin.class.getResource("/org/utl/dsm/sicefa/desktop/dsm406_sicefa/view_alert.fxml"));
        Parent root = loader.load();
        ControllerViewAlert controller = loader.getController();
        Button btnAceptar = controller.getBtnAceptar();
        Button btnCancelar = controller.getBtnCancelar();
        Label lblTitulo = controller.getLblTitulo();
        lblTitulo.setText(mensaje);
        btnAceptar.setOnAction(event -> {
            // Código que se ejecutara si da clic en boton aceptar
            popup.hide();
        });
        btnCancelar.setOnAction(event -> {
            // Código que se ejecutara si da clic en boton cancelar
            popup.hide();
        });
        popup.getContent().add(root);
        popup.show(btnCalcular.getScene().getWindow());
    }*/
