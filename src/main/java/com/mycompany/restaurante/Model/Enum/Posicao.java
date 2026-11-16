package com.mycompany.restaurante.Model.Enum;

public enum Posicao {
    DIREITA(2),
    CENTRO(1),
    ESQUERDA(0);
    
    private int i;
    
    private Posicao(int i){
        this.i = i;
    }
    private int getPosicao(){
        return i;
    }
}
