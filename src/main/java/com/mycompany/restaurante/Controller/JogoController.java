/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante.Controller;

import com.mycompany.restaurante.App;
import com.mycompany.restaurante.DAO.Controller.SaveC;
import com.mycompany.restaurante.Model.Cliente;
import com.mycompany.restaurante.Model.Clientes;
import com.mycompany.restaurante.Model.Enum.Receitas;
import com.mycompany.restaurante.Model.Save;
import com.mycompany.restaurante.Model.Saves;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
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
    @FXML private Label h, d, p1, p2, p3, t1, t2, t3;
    @FXML private StackPane j;
    @FXML private ImageView monstro1, monstro2, monstro3;
    
    SaveC sc = new SaveC();
    public static LocalTime horaS  = LocalTime.of(22,0);
    private final Save save = Saves.getSave();
    //private final Cliente cliente = Clientes.getCliente();
    
    private LocalTime hora;
    private int dia;
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
    private void cardapio() throws IOException {
        relogio.stop();
        idC.stop();
        tempo.stop();
        horaS = hora;
        save.setDia(dia);
        
        App.setRoot("cardapio");
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
        j.setOnKeyPressed(e ->{
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
            }else if(e.getCode() == KeyCode.J){
                try {
                    cardapio();
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
        p1.setText("");
        p2.setText("");
        p3.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        clienteImg();
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
        idC = new Timeline();

        idC.getKeyFrames().add(
            new KeyFrame(Duration.seconds(10), e -> {
                if(Clientes.cliente.isEmpty() || Clientes.cliente.size() < 3){
                    Cliente novo = new Cliente(id.nextInt(8), 6, 0, false, pedido());
                    Clientes.cliente.add(novo);
                    clienteImg();
                }else{
                    for(int i = 0; i < Clientes.cliente.size(); i++){
                        if(Clientes.cliente.get(i) == null){
                            Cliente novo = new Cliente(id.nextInt(8), 4, 0, false, pedido());
                            Clientes.cliente.set(i, novo);
                            clienteImg();
                        }
                    }
                }
            })
        );

        idC.setCycleCount(Timeline.INDEFINITE);
        idC.play();
        
        tempo = new Timeline(
        new KeyFrame(Duration.seconds(10), e -> {
                Tempo();
            })
        );
        
        tempo.setCycleCount(Timeline.INDEFINITE);
        tempo.play();
    }

    private ArrayList<Receitas> pedido(){
        ArrayList<Receitas> pedido = new ArrayList<>();
        Random random = new Random();
        String receita;
        if(save.getDia() >=5){
            int r = random.nextInt(3);
            for(int i = 0; i <= r; i++){
                switch(save.getUpgrades()){
                    case L1:
                        receita = "R"+(id.nextInt(3)+1);
                        pedido.add(Receitas.valueOf(receita));
                        break;
                    case L2:
                        receita = "R"+(id.nextInt(6)+1);
                        pedido.add(Receitas.valueOf(receita));
                        break;
                    case L3:
                        receita = "R"+(id.nextInt(9)+1);
                        pedido.add(Receitas.valueOf(receita));
                        break;
                    case L4:
                        receita = "R"+(id.nextInt(12)+1);
                        pedido.add(Receitas.valueOf(receita));
                        break;
                }
            }
            return pedido;
        }else if(save.getDia() >= 2){
            int r = random.nextInt(2);
            for(int i = 0; i <= r; i++){
                receita = "R"+(id.nextInt(3)+1);
                pedido.add(Receitas.valueOf(receita));
            }
            return pedido;
        }else{
            for(int i = 0; i < 1; i++){
                receita = "R"+(id.nextInt(3)+1);
                pedido.add(Receitas.valueOf(receita));
            }
            return pedido;
        }
    }
    
    private void Tempo() {
        for (int i = 0; i < Clientes.cliente.size(); i++) {
            Cliente c = Clientes.cliente.get(i);

            if (c.getTempo() > 1 && !c.isAtendido()) {
                c.setTempo(c.getTempo() - 1);
                switch (i) {
                    case 0:
                        t1.setText(String.valueOf(c.getTempo()));
                        break;
                    case 1:
                        t2.setText(String.valueOf(c.getTempo()));
                        break;
                    case 2:
                        t3.setText(String.valueOf(c.getTempo()));
                        break;
                }
            } else {
                imgC(i);
                Clientes.cliente.set(i, null);
            }
        }
    }
    
    private void imgC(int i) {
        switch(i){
            case 0:
                 monstro1.setImage(null);
                 p1.setText("");
                 t1.setText("");
                 break;
            case 1:
                monstro2.setImage(null);
                p2.setText("");
                t2.setText("");
                break;
            case 2:
                monstro3.setImage(null);
                p3.setText("");
                t3.setText("");
                break;
        }
    }
    
    private void fim() throws IOException{
        relogio.stop();
        idC.stop();
        tempo.stop();
        monstro1.setImage(null);
        monstro2.setImage(null);
        monstro3.setImage(null);
        p1.setText("");
        p2.setText("");
        p3.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        Clientes.cliente.clear();
        App.setRoot("final");
    }
    
    @FXML
    private void clienteImg() {
        monstro1.setImage(null);
        monstro2.setImage(null);
        monstro3.setImage(null);
        p1.setText("");
        p2.setText("");
        p3.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");

        for (int i = 0; i < Clientes.cliente.size(); i++) {
            Cliente c = Clientes.cliente.get(i);
            String caminho = "/com/mycompany/restaurante/Monsters/M1.png";

            Image img = new Image(getClass().getResource(caminho).toExternalForm());

            switch (i) {
                case 0:
                    monstro1.setImage(img);
                    t1.setText(String.valueOf(c.getTempo()));
                    for (Receitas pedido : c.getPedido()) {
                        p1.setText(pedido.getReceita()+" ");
                    }
                    break;

                case 1:
                    monstro2.setImage(img);
                    t2.setText(String.valueOf(c.getTempo()));
                    for (Receitas pedido : c.getPedido()) {
                        p2.setText(pedido.getReceita()+" ");
                    }
                    break;
                case 2:
                    monstro3.setImage(img);
                    t3.setText(String.valueOf(c.getTempo()));
                    for (Receitas pedido : c.getPedido()) {
                        p3.setText(pedido.getReceita()+" ");
                    }
                    break;
            }
        }
    }
}
