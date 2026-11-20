/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante.Model;

import com.mycompany.restaurante.Model.Enum.Upgrade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonat
 */
public class Save {
    private String nome;
    private int id, dia;
    private double dinheiro;
    private Upgrade upgrade;

    public Save(int id, String nome, int dia, double dinheiro, Upgrade upgrades) {
        this.id = id;
        this.nome = nome;
        this.dia = dia;
        this.dinheiro = dinheiro;
        this.upgrade = upgrades;
    }
    
    public Save(String nome, int dia, double dinheiro, Upgrade upgrades) {
        this.nome = nome;
        this.dia = dia;
        this.dinheiro = dinheiro;
        this.upgrade = upgrades;
    }

    public Save() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    public Upgrade getUpgrades() {
        return upgrade;
    }

    public void setUpgrades(Upgrade upgrades) {
        this.upgrade = upgrades;
    }

    @Override
    public String toString() {
        return "Save{" + "id=" + id + ", dia=" + dia + ", dinheiro=" + dinheiro + '}';
    }
    
    
}
