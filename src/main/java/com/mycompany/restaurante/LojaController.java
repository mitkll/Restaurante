package com.mycompany.restaurante;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LojaController {
    @FXML private Label dd;    
    private Save save = JogoController.save;
    
    @FXML
    private void initialize(){
        String DD = String.valueOf(save.getDinheiro());
        dd.setText("$"+DD);
    }
    
    @FXML
    private void voltar() throws IOException{
        App.setRoot("jogo");
    }
    
    @FXML
    private void noite(){
        if(save.isNoite()){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("");
            aviso.setHeaderText(null); // tira a faixa de cima
            aviso.setContentText("Você já tem esse upgrade");
            aviso.showAndWait();
        }else if(save.getDinheiro() < 1500){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("");
            aviso.setHeaderText(null); // tira a faixa de cima
            aviso.setContentText("Você não tem dinheiro suficiente");
            aviso.showAndWait();
        }else{
            save.setDinheiro(save.getDinheiro() - 1500);
            String DD = String.valueOf(save.getDinheiro());
            dd.setText("$"+DD);
            save.setNoite(true);
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("");
            aviso.setHeaderText(null); // tira a faixa de cima
            aviso.setContentText("Parabéns por comprar o turno da noite!");
            aviso.showAndWait();
        }
    }
}