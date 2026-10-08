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
    @FXML private Button loja;
    @FXML private VBox card;//, background;
    
    private static LocalTime horaS  = LocalTime.of(10,0);
    private static int diaS = 1;
    public static Save save = new Save(1, 3000, false);
    
    private LocalTime hora;
    private int dia, i = 0;
    private Timeline relogio;
    
    @FXML
    private void loja() throws IOException {
        relogio.stop();
        horaS = hora;
        diaS = dia;
        
        App.setRoot("loja");
    }
    
    @FXML
    private void initialize() throws InterruptedException{        
        card.setStyle("-fx-opacity: 0;"
                + "-fx-transition: opacity 2s;"
                + "-fx-backgrond-color: #ebebd1");
        /*background.setStyle("-fx-opacity: 0;"
                + "-fx-transition: opacity 1s;"
                + "-fx-background-color: black");*/
        loja.setStyle("-fx-translate-x:200;"
                + "-fx-translate-y:40;"
                + "-fx-padding: 3 15;"
                + "-fx-opacity: 1");
        hora = horaS;
        dia = diaS;
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
        relogio = new Timeline();
        relogio.getKeyFrames().add(
            new KeyFrame(Duration.seconds(10), e -> {
                hora = hora.plusMinutes(10);
                relogioFX();

                if (!save.isNoite()) {
                    if (!hora.isBefore(LocalTime.of(15, 0))) {
                        fim();
                    }
                } else {
                    if (hora.isAfter(LocalTime.of(10, 0)) && !hora.isBefore(LocalTime.of(15, 0)) 
                        && hora.isBefore(LocalTime.of(22, 0))) {
                        fim();
                    } 
                    else if (!hora.isBefore(LocalTime.of(3, 0)) && hora.isBefore(LocalTime.of(10, 0))) {
                        fim();
                    }
                }
            })
        );
        relogio.setCycleCount(Timeline.INDEFINITE);
        relogio.play();
    }
    
    private void fim(){
        card.setStyle("-fx-opacity: 1.0");
        relogio.stop();
        loja.setStyle("-fx-opacity: 0");
        //background.setStyle("-fx-opacity: 0.5");
    }
    
    @FXML
    private void continuar() throws InterruptedException{
        if (!save.isNoite()) {
            hora = LocalTime.of(10, 0);
            dia++;
            horaS = hora;
            diaS = dia;
            initialize();
        } else {
            if (hora.getHour() >= 15 && hora.getHour() < 22) {
                hora = LocalTime.of(22, 0);
                horaS = hora;
                initialize();
            } else {
                hora = LocalTime.of(10, 0);
                dia++;
                horaS = hora;
                diaS = dia;
                initialize();
            }
        }
    }
}
