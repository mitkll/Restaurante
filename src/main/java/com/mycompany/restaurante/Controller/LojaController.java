package com.mycompany.restaurante.Controller;

import com.mycompany.restaurante.App;
import com.mycompany.restaurante.Controller.JogoController;
import com.mycompany.restaurante.Model.Save;
import com.mycompany.restaurante.Model.Saves;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LojaController {
    @FXML private Label dd;    
    private final Save save = Saves.getSave();
    
    @FXML
    private void initialize(){
        String DD = String.valueOf(save.getDinheiro());
        dd.setText("$"+DD);
    }
    
    @FXML
    private void voltar() throws IOException{
        App.setRoot("jogo");
    }
}