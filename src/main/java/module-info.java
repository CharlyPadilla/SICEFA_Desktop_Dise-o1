module org.utl.dsm.sicefa.desktop.dsm406_sicefa {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires unirest.java;

    //Estamos exponiedo el paquete de controller al proyecto
    opens org.utl.dsm.sicefa.desktop.dsm406_sicefa to javafx.fxml;
    exports org.utl.dsm.sicefa.desktop.dsm406_sicefa;

    opens org.utl.dsm.sicefa.desktop.dsm406_sicefa.Controller to javafx.fxml, com.google.gson;
    exports org.utl.dsm.sicefa.desktop.dsm406_sicefa.Controller;
}