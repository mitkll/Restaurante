package com.mycompany.restaurante.Controller;

import com.mycompany.restaurante.App;
import com.mycompany.restaurante.Model.Saves;
import java.io.IOException;
import java.util.Optional;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class MenuController {
    
    @FXML
    private void novoJogo() throws IOException {
        App.setRoot("save");
    }
    
    @FXML
    private void creditos() throws IOException 
    {
        App.setRoot("credito");
    }
    
    @FXML
    private void sairJogo() throws IOException 
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText("Quer sair do jogo?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK)Platform.exit();
        
    }
}
