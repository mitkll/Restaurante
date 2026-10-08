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
    private int id, dia;
    private double dinheiro;
    private boolean noite;
    private List<String> upgrades = new ArrayList<>();

    public Save(int id, int dia, double dinheiro, boolean noite, ArrayList upgrades) {
        this.id = id;
        this.dia = dia;
        this.dinheiro = dinheiro;
        this.noite = noite;
        this.upgrades = upgrades;
    }
    
    public Save(int dia, double dinheiro, boolean noite, ArrayList upgrades) {
        this.dia = dia;
        this.dinheiro = dinheiro;
        this.noite = noite;
        this.upgrades = upgrades;
    }
    
    public Save(int dia, double dinheiro, boolean noite){
        this.dia = dia;
        this.dinheiro = dinheiro;
        this.noite = noite;
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

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public boolean isNoite(){
        return noite;
    }

    public void setNoite(boolean noite){
        this.noite = noite;
    }

    public List<String> getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(List<String> upgrades) {
        this.upgrades = upgrades;
    }

    @Override
    public String toString() {
        return "Save{" + "id=" + id + ", dia=" + dia + ", dinheiro=" + dinheiro + '}';
    }
    
    
}
