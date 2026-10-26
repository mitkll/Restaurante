package com.mycompany.restaurante.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cliente {
    private int tempo, raiva, id;
    private boolean atendido;
    private List<String> pedido = new ArrayList<>();

    public Cliente(int id, int tempo, int raiva, boolean atendido, ArrayList pedido) {
        this.id = id;
        this.tempo = tempo;
        this.raiva = raiva;
        this.atendido = atendido;
        this.pedido = pedido;
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

   
    
    
}
