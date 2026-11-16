package com.mycompany.restaurante.Model;

import com.mycompany.restaurante.Model.Enum.Posicao;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cliente {
    private int tempo, raiva, id;
    private boolean atendido;
    private List<String> pedido = new ArrayList<>();
    private Posicao p;

    public Cliente(int id, int tempo, int raiva, boolean atendido, ArrayList pedido, Posicao p) {
        this.id = id;
        this.tempo = tempo;
        this.raiva = raiva;
        this.atendido = atendido;
        this.pedido = pedido;
        this.p = p;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getRaiva() {
        return raiva;
    }

    public void setRaiva(int raiva) {
        this.raiva = raiva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public List<String> getPedido() {
        return pedido;
    }

    public void setPedido(List<String> pedido) {
        this.pedido = pedido;
    }

    public Posicao getP() {
        return p;
    }

    public void setP(Posicao p) {
        this.p = p;
    }   
    
}
