package com.mycompany.restaurante.DAO;

public enum Upgrade 
{
    CARDAPIO(1),
    INGRADIENTE(2),
    ITENS(3),
    LOCAL(4);

    private final int id;
    
    // Construtor do Enum
    Upgrade(int id) 
    {
        this.id = id;
    }

    // Método para recuperar o ID
    public int getId() {
        return id;
    }

    // Opcional: Buscar o Enum a partir de um ID
    public static Upgrade fromId(int id) {
        for (Upgrade status : Upgrade.values()) {
            if (status.getId() == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("ID inválido: " + id);
    }
}

