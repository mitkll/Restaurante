/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonat
 */
public class Save {
    private int id, dia, hora;
    private double dinheiro;
    private List<String> upgrades = new ArrayList<>();

    public Save(int id, int dia, int hora, double dinheiro) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
        this.dinheiro = dinheiro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public List<String> getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(List<String> upgrades) {
        this.upgrades = upgrades;
    }

    @Override
    public String toString() {
        return "Save{" + "id=" + id + ", dia=" + dia + ", hora=" + hora + ", dinheiro=" + dinheiro + '}';
    }
    
    
}
