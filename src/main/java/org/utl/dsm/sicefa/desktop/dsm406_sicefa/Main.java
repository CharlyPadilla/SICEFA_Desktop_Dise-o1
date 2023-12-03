package org.utl.dsm.sicefa.desktop.dsm406_sicefa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root= FXMLLoader.load(this.getClass().getResource("view_gestionSucursales.fxml"));
        Scene scene = new Scene(root,900,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestión de Sucursales");
        // primaryStage.setResizable(true);
        primaryStage.show();
    }

  public static void main (String[] args)  {
        launch();
  }


}
