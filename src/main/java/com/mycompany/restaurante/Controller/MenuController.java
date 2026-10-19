package com.mycompany.restaurante.Controller;

import com.mycompany.restaurante.App;
import com.mycompany.restaurante.Model.Saves;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class MenuController {

    @FXML
    private void save() throws IOException {
        if(Saves.save.isEmpty()){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("");
            aviso.setHeaderText(null); // tira a faixa de cima
            aviso.setContentText("Não existe nenhum save");
            aviso.showAndWait();
        }else App.setRoot("save");
    }
    
    @FXML
    private void novoJogo() throws IOException {
        App.setRoot("jogo");
    }
    
    @FXML
    private void creditos() throws IOException 
    {
        App.setRoot("credito");
    }
    
    @FXML
    private void sairJogo() throws IOException 
    {
        //App.setRoot();
    }
}
