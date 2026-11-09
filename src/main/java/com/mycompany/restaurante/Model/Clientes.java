package com.mycompany.restaurante.Model;

import java.util.ArrayList;
import java.util.List;

public class Clientes {
    public static List<Cliente> cliente = new ArrayList<>();
    
    private static Cliente clienteA;

    public static Cliente getCliente() {
        return clienteA;
    }

    public static void setCliente(Cliente cliente) {
        clienteA = cliente;
    }
}
