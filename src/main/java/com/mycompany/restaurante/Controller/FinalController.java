/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante.Controller;

import com.mycompany.restaurante.App;
import com.mycompany.restaurante.DAO.Controller.SaveC;
import com.mycompany.restaurante.Model.Save;
import com.mycompany.restaurante.Model.Saves;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 *
 * @author jonat
 */
public class FinalController {
    @FXML private Label g, c, d;
    
    SaveC sc = new SaveC();
    private final Save save = Saves.getSave();
    private int dia = save.getDia();
    
    @FXML
    private void sair() throws IOException, SQLException{
        Alert det = new Alert(Alert.AlertType.CONFIRMATION);
        det.setTitle(null);
        det.setHeaderText("Tem certeza que quer sair do jogo?");

        Optional<ButtonType> conf = det.showAndWait();
        if (conf.isPresent() && conf.get() == ButtonType.OK) {
            dia++;
            save.setDia(dia);
            sc.atualizar(save);
            App.setRoot("menu");
        }
    }
    
    @FXML
    private void initialize() throws InterruptedException{
    }
    
    @FXML
    private void continuar() throws InterruptedException, SQLException, IOException{
        JogoController.horaS = LocalTime.of(22, 0);
        dia++;
        save.setDia(dia);
        sc.atualizar(save);
        App.setRoot("jogo");
    }
}
