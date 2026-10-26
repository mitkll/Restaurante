package com.mycompany.restaurante.DAO.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao 
{
    String url = "jdbc:postgresql://localhost:5432/restaurante"; // URL do banco de dados || 5433 || 5432
    String usuario = "postgres"; // Nome de usuÃ¡rio do PostgreSQL
    String senha = "postgresql"; // Senha do PostgreSQL: postgresql || ifms
    
    public Connection conectar() throws SQLException{
        return DriverManager.getConnection(url, usuario, senha);
    }
}
