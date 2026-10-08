/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.Duration;

/**
 *
 * @author jonat
 */
public class JogoController {
    @FXML private Label h, d;
    //@FXML private VBox card, background;
    
    LocalTime hora = LocalTime.of(10,0);
    private int dia = 1;
    
    @FXML
    private void loja() throws IOException {
        App.setRoot("loja");
    }
    
    @FXML
    private void initialize() throws InterruptedException{
        
        /*card.setStyle("-fx-opacity: 0;"
                + "-fx-transition: opacity 2s");
        background.setStyle("-fx-opacity: 0;"
                + "-fx-transition: opacity 1s;"
                + "-fx-background-color: black");
        hora = LocalTime.of(10,0);*/
        relogioFX();
        relogio();
    }
    
    @FXML
    private void relogioFX(){
        String Dia = String.valueOf(dia);
        h.setText(hora.format(DateTimeFormatter.ofPattern("HH:mm")));
        d.setText(Dia);
    }
    
    private void relogio() throws InterruptedException{
        Timeline timeline = new Timeline();
        
        timeline.getKeyFrames().add(
            new KeyFrame(Duration.seconds(5), e -> {
                if (hora.getHour() < 14) {
                    hora = hora.plusMinutes(10);
                    relogioFX();
                }else{
                    hora = LocalTime.of(9, 50);
                    dia++;
                }
            })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
    /*private void fim(){
        card.setStyle("-fx-opacity: 1.0");
        background.setStyle("-fx-opacity: 0.5");
    }*/
    
    @FXML
    private void continuar() throws InterruptedException{
        initialize();
    }
}
