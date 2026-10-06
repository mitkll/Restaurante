/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author jonat
 */
public class JogoController {
    @FXML private Label h, d;
    @FXML private VBox card, background;
    
    private int hora = 10, minuto = 0, dia = 0;
    private double dinheiro;
    
    @FXML
    private void loja() throws IOException {
        App.setRoot("loja");
    }
    
    @FXML
    private void initialize(){
        card.setStyle("-fx-opacity: 0;"
                + "-fx-transition: opacity 2s");
        background.setStyle("-fx-opacity: 0;"
                + "-fx-transition: opacity 1s;"
                + "-fx-background-color: black");
        hora = 10;
        minuto = 0;
        dia += 1;
        relogio();
    }
    
    private void relogio(){
        String r1 = String.valueOf(hora) + ":" + String.valueOf(minuto);
        String r2 = String.valueOf(dia);
        h.setText(r1);
        d.setText(r2);
        do{            
            try {
                Thread.sleep(10000); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            if(minuto == 50){
                minuto = 0;
                hora += 1;
            }else minuto += 10;
            
            r1 = String.valueOf(hora) + ":" + String.valueOf(minuto);
            h.setText(r1);
            
        }while(hora <= 13.50);
        card.setStyle("-fx-opacity: 1.0");
        background.setStyle("-fx-opacity: 0.5");
    }
    
    @FXML
    private void continuar(){
        initialize();
    }
}
