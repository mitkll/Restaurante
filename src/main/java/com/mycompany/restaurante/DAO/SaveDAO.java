/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante.DAO;

import com.mycompany.restaurante.DAO.utils.Conexao;
import com.mycompany.restaurante.Model.Save;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jonat
 */
public class SaveDAO {
    Conexao conexao = new Conexao();
    public int add(Save s) throws SQLException{
        String sql = "INSERT INTO save (nome, dia, dinheiro, noite, upgrades) VALUES (?, ?, ?, ?, ?) RETURNING id";
        
        Connection connection = conexao.conectar();

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, s.getNome());
        stmt.setInt(2, s.getDia());
        stmt.setDouble(3, s.getDinheiro());
        stmt.setBoolean(4, s.isNoite());

        String[] upgradesArray = s.getUpgrades().toArray(new String[0]);
        Array up = connection.createArrayOf("text", upgradesArray);

        stmt.setArray(5, up);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                int id = rs.getInt("id");
                s.setId(id);           
                return id;
            }
        }
        
        return -1;
    }
    public List<Save> save() throws SQLException    {
        String sql = "SELECT * FROM save";
        
        List<Save> sLista = new ArrayList<>();    
        
        Connection connection = conexao.conectar();            
        PreparedStatement stmt = connection.prepareStatement(sql);                    
        ResultSet rs = stmt.executeQuery();                    
        while(rs.next()){
            Save s = new Save();

            s.setId(rs.getInt("id"));
            s.setNome(rs.getString("nome"));
            s.setDinheiro(rs.getDouble("dinheiro"));
            s.setNoite(rs.getBoolean("noite"));
            Array sqlArray = rs.getArray("upgrades");

            if (sqlArray != null) {
                String[] upgradesArray = (String[]) sqlArray.getArray();
                List<String> listaUpgrades = new ArrayList<>(Arrays.asList(upgradesArray));
                s.setUpgrades(listaUpgrades);
            } else {
                s.setUpgrades(new ArrayList<>()); 
            }

            sLista.add(s);
        }

        return sLista;
            
    }
    
    public void atualizar(Save s) throws SQLException {
        String sql = "UPDATE save SET dinheiro=?, noite=?, upgrade=? WHERE id = ?";
        
            Connection connection = conexao.conectar(); 
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setDouble(1, s.getDinheiro());
            stmt.setBoolean(2, s.isNoite());
            
            String[] upgradesArray = s.getUpgrades().toArray(new String[0]);
            Array up = connection.createArrayOf("text", upgradesArray);
            
            stmt.setArray(3, up);
            stmt.setInt(4, s.getId());

            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("");
            }
        
    }
    
    public void delete(int id) throws SQLException{
        String sql = "DELETE from save WHERE id=?";
        
        Connection connection = conexao.conectar();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, id);
    }
}