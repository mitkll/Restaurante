/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante.Controller;

import com.mycompany.restaurante.App;
import com.mycompany.restaurante.DAO.Controller.SaveC;
import com.mycompany.restaurante.DAO.SaveDAO;
import com.mycompany.restaurante.Model.Save;
import com.mycompany.restaurante.Model.Saves;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author jonat
 */
public class SaveController {
    SaveDAO dao = new SaveDAO();
    SaveC sc = new SaveC();
    public static Save save = new Save();
    
    @FXML private Button um, dois, tres;
    
    @FXML
    private void jogo() throws IOException, SQLException {
        List<Save> saves = dao.save();

        botao(um, 1, saves);
        botao(dois, 2, saves);
        botao(tres, 3, saves);
    }
    
    @FXML
    private void voltar() throws IOException {
        App.setRoot("menu");
    }
    
    private void botao(Button botao, int id, List<Save> saves) throws IOException {
        Save sv = null;
        for (Save s : saves) {
            if (s.getId() == id) {
                sv = s;
                break;
            }
        }

        if (sv != null) {
            botao.setText("[Funcionário: " + sv.getNome() 
                    + " | Dia: " + sv.getDia() 
                    + " | Dinheiro: " + String.format("%.2f", sv.getDinheiro()) + "]");

            Save saveA = sv;

            botao.setOnAction(e -> {
                Alert opcao = new Alert(Alert.AlertType.CONFIRMATION);
                opcao.setTitle("O que quer fazer?");
                opcao.setHeaderText(null);

                ButtonType jogar = new ButtonType("Jogar");
                ButtonType excluir = new ButtonType("Deletar Save");
                opcao.getButtonTypes().setAll(jogar, excluir);

                Optional<ButtonType> result = opcao.showAndWait();
                if (result.isPresent()) {
                    if (result.get() == jogar) {
                        try {
                            carregar(saveA);
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }
                    } else if (result.get() == excluir) {
                        Alert det = new Alert(Alert.AlertType.CONFIRMATION);
                        det.setTitle("Tem certeza que quer excluir permanentemente?");
                        det.setHeaderText(null);

                        Optional<ButtonType> conf = det.showAndWait();
                        if (conf.isPresent() && conf.get() == ButtonType.OK) {
                            try {
                                sc.delete(id);
                                botao.setText("Novo Jogo "+id+".");
                            } catch (SQLException ex) {
                                System.out.println(ex);
                            }
                        }
                    }
                }
            });
        } else {
            try {
                nSave(id);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    private void carregar(Save save) throws IOException{
        Saves.setSave(save);
        App.setRoot("jogo");
    }
    
    private void nSave(int id) throws SQLException, IOException{
        Alert nome = new Alert(Alert.AlertType.CONFIRMATION);
        nome.setTitle("Qual seu nome?");
        nome.setHeaderText(null);
        
        TextField n = new TextField();
        VBox vbox = new VBox(n);
        
        nome.getDialogPane().setContent(vbox);
        Optional<ButtonType> result = nome.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            String nm = n.getText();
            sc.inserir(id, nm, 1, 50.0, false, new ArrayList<>());
            App.setRoot("jogo");
        }
    }
}
