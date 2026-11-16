/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante.Controller;

import com.mycompany.restaurante.App;
import com.mycompany.restaurante.DAO.Controller.SaveC;
import com.mycompany.restaurante.Model.Cliente;
import com.mycompany.restaurante.Model.Clientes;
import com.mycompany.restaurante.Model.Save;
import com.mycompany.restaurante.Model.Saves;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.*;
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
    @FXML private ImageView monstro1, monstro2, monstro3;
    
    SaveC sc = new SaveC();
    public static LocalTime horaS  = LocalTime.of(22,0);
    private final Save save = Saves.getSave();
    //private final Cliente cliente = Clientes.getCliente();
    
    private LocalTime hora;
    private int dia, posicao;
    private Timeline relogio, idC, tempo;
    private Random id = new Random();
    
    @FXML
    private void loja() throws IOException {
        relogio.stop();
        idC.stop();
        tempo.stop();
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
            relogio.stop();
            idC.stop();
            tempo.stop();
            Clientes.cliente.clear();
            horaS = LocalTime.of(22, 0);
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
        cliente();
        monstro1.setImage(null);
        monstro2.setImage(null);
        monstro3.setImage(null);
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
    
    private void cliente(){
        tempo = new Timeline();
        idC = new Timeline();

        idC.getKeyFrames().add(
            new KeyFrame(Duration.seconds(10), e -> {
                if (Clientes.cliente.size() >= 3) {
                    Tempo();
                } 
                else {
                    Cliente novo = new Cliente(id.nextInt(8), 5, 0, false, new ArrayList<>());
                    Clientes.cliente.add(novo);
                    clienteImg();
                    Tempo();
                }
            })
        );

        idC.setCycleCount(Timeline.INDEFINITE);
        idC.play();

        tempo.setCycleCount(Timeline.INDEFINITE);
        tempo.play();
    }

    private void Tempo() {
        if (tempo.getKeyFrames().isEmpty()) {
            tempo.getKeyFrames().add(
                new KeyFrame(Duration.seconds(10), ex -> {
                    for (int i = Clientes.cliente.size() - 1; i >= 0; i--) {
                        Cliente c = Clientes.cliente.get(i);

                        if (c.getTempo() > 0 && !c.isAtendido()) {
                            c.setTempo(c.getTempo() - 1);
                        } else {
                            imgC(i);
                            Clientes.cliente.remove(i);
                        }
                    }
                })
            );
        }
    }
    
    private void imgC(int i) {
        switch(i){
            case 0:
                 monstro1.setImage(null);
            case 1:
                monstro2.setImage(null);
            case 2:
                monstro3.setImage(null);
        }
    }
    
    private void fim() throws IOException{
        relogio.stop();
        idC.stop();
        tempo.stop();
        monstro1.setImage(null);
        monstro2.setImage(null);
        monstro3.setImage(null);
        Clientes.cliente.clear();
        App.setRoot("final");
    }
    
    @FXML
    private void clienteImg() {
        monstro1.setImage(null);
        monstro2.setImage(null);
        monstro3.setImage(null);

        for (int i = 0; i < Clientes.cliente.size(); i++) {
            Cliente c = Clientes.cliente.get(i);
            String caminho = "/com/mycompany/restaurante/Monsters/M1.png";

            Image img = new Image(getClass().getResource(caminho).toExternalForm());

            switch (i) {
                case 0:
                    monstro1.setImage(img);
                    break;
                case 1:
                    monstro2.setImage(img);
                    break;
                case 2:
                    monstro3.setImage(img);
                    break;
            }
        }
    }
}
