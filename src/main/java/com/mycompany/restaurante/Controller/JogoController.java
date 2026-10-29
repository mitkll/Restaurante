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
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.util.Duration;

/**
 *
 * @author jonat
 */
public class JogoController {
    @FXML private Label h, d;
    @FXML private VBox jogo;
    
    SaveC sc = new SaveC();
    public static LocalTime horaS  = LocalTime.of(22,0);
    private final Save save = Saves.getSave();
    
    private LocalTime hora;
    private int dia;
    private Timeline relogio;
    
    @FXML
    private void loja() throws IOException {
        relogio.stop();
        horaS = hora;
        save.setDia(dia);
        
        App.setRoot("loja");
    }
    
    @FXML
    private void sair() throws IOException{
        Alert det = new Alert(Alert.AlertType.CONFIRMATION);
        det.setTitle("Você terá que recomeçar o dia");
        det.setHeaderText("Tem certeza que quer sair?");

        Optional<ButtonType> conf = det.showAndWait();
        if (conf.isPresent() && conf.get() == ButtonType.OK) {
            App.setRoot("menu");
        }
    }
    
    @FXML
    private void initialize() throws InterruptedException{
        jogo.setOnKeyPressed(e ->{
            if(e.getCode() == KeyCode.I){
                try {
                    loja();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }else if(e.getCode() == KeyCode.ESCAPE){
                try {
                    sair();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        });
        hora = horaS;
        dia = save.getDia();
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
            new KeyFrame(Duration.seconds(5), e -> {
                hora = hora.plusMinutes(10);
                relogioFX();
                if(!hora.isBefore(LocalTime.of(4, 0)) && hora.isBefore(LocalTime.of(10, 0))) {//3 min e meio de jogatina
                    try {
                        fim();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            })
        );
        relogio.setCycleCount(Timeline.INDEFINITE);
        relogio.play();
    }
    
    private void fim() throws IOException{
        relogio.stop();
        App.setRoot("final");
    }
}
