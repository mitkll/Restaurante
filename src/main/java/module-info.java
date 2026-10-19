module com.mycompany.restaurante {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.restaurante to javafx.fxml;
    opens com.mycompany.restaurante.Controller to javafx.fxml;
    
    exports com.mycompany.restaurante;
    exports com.mycompany.restaurante.Controller;
}
