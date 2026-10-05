package com.mycompany.restaurante;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class MenuController {

    @FXML
    private void save() throws IOException {
        if(Saves.save.isEmpty()){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Sistema de reservas");
            aviso.setHeaderText(null); // tira a faixa de cima
            aviso.setContentText("Não existe nenhum save");
            aviso.showAndWait();
        }else App.setRoot("save");
    }
    
    @FXML
    private void novoJogo() throws IOException {
        App.setRoot("jogo");
    }
}
