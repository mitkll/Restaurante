package com.mycompany.restaurante.Controller;

import com.mycompany.restaurante.App;
import com.mycompany.restaurante.Model.Enum.Upgrade;
import com.mycompany.restaurante.Model.Save;
import com.mycompany.restaurante.Model.Saves;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

public class LojaController {
    @FXML private Label dd;    
    @FXML private Button inkay;
    @FXML private VBox loja;
    private final Save save = Saves.getSave();
    
    @FXML
    private void licenca(){
        switch(save.getUpgrades()){
            case L1:
                if(save.getDinheiro() >= 200){
                    save.setDinheiro(save.getDinheiro() - 200);
                    save.setUpgrades(Upgrade.L2);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Compra realizada com sucesso!");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    inkay.setText("Licenca 3");
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Você não tem dinheiro suficiente!");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                break;
            case L2:
                if(save.getDinheiro() >= 400){
                    save.setDinheiro(save.getDinheiro() - 400);
                    save.setUpgrades(Upgrade.L2);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Compra realizada com sucesso!");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    inkay.setText("Licenca 4");
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Você não tem dinheiro suficiente!");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                break;
            case L3:
                if(save.getDinheiro() >= 400){
                    save.setDinheiro(save.getDinheiro() - 400);
                    save.setUpgrades(Upgrade.L2);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Compra realizada com sucesso!");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    inkay.setText("Todas as licenças obtidas");
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Você não tem dinheiro suficiente!");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                break;
            case L4:
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Você já comprou todas!");
                alert.setHeaderText(null);
                alert.showAndWait();
                break;
        }
    }
    
    @FXML
    private void initialize(){
        String DD = String.valueOf(save.getDinheiro());
        dd.setText("$"+DD);
        switch(save.getUpgrades()){
            case L2:
                inkay.setText("Licenca 3");
                break;
            case L3:
                inkay.setText("Licanca 4");
                break;
            case L4:
                inkay.setText("Você já tem todas");
                break;
        }
        loja.setOnKeyPressed(e ->{
            if(e.getCode() == KeyCode.ESCAPE){
                try {
                    voltar();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        });
    }
    
    @FXML
    private void voltar() throws IOException{
        App.setRoot("jogo");
    }
}