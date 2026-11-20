/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante.DAO;

import com.mycompany.restaurante.DAO.utils.Conexao;
import com.mycompany.restaurante.Model.Enum.Upgrade;
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
    public void add(Save s) throws SQLException{
        String sql = "INSERT INTO save (id, nome, dia, dinheiro, upgrades) VALUES ( ?, ?, ?, ?, ?)";
        
        Connection connection = conexao.conectar();

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, s.getId());
        stmt.setString(2, s.getNome());
        stmt.setInt(3, s.getDia());
        stmt.setDouble(4, s.getDinheiro());
        stmt.setString(5, s.getUpgrades().name());
        stmt.executeUpdate();
    }
    
    public List<Save> saveId(int id) throws SQLException{
        List<Save> lista = new ArrayList<>();
        String sql = "SELECT * FROM save WHERE id=?";
        
        Connection connection = conexao.conectar();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){            
            Save s = new Save(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("dia"),
                    rs.getDouble("dinheiro"),
                    Upgrade.valueOf(rs.getString("upgrades"))
            );
            lista.add(s);
        }

        return lista;
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
            s.setDia(rs.getInt("dia"));
            s.setDinheiro(rs.getDouble("dinheiro"));
            s.setUpgrades(Upgrade.valueOf(rs.getString("upgrades")));

            sLista.add(s);
        }

        return sLista;
            
    }
    
    public void atualizar(Save s) throws SQLException {
        String sql = "UPDATE save SET dia=?, dinheiro=?, upgrades=? WHERE id = ?";
        
            Connection connection = conexao.conectar(); 
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, s.getDia());
            stmt.setDouble(2, s.getDinheiro());
            stmt.setString(3, s.getUpgrades().name());
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
        stmt.executeUpdate();
    }
}