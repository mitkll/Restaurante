package com.mycompany.restaurante.Model;

public class Clientes {
    private static Cliente clienteA;

    public static Cliente getCliente() {
        return clienteA;
    }

    public static void setCliente(Cliente cliente) {
        clienteA = cliente;
    }
}