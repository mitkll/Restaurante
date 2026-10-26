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
    public void add(Save s) throws SQLException{
        String sql = "INSERT INTO save (id, nome, dia, dinheiro, upgrades) VALUES ( ?, ?, ?, ?, ?)";
        
        Connection connection = conexao.conectar();

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, s.getId());
        stmt.setString(2, s.getNome());
        stmt.setInt(3, s.getDia());
        stmt.setDouble(4, s.getDinheiro());

        String[] upgradesArray = s.getUpgrades().toArray(new String[0]);
        Array up = connection.createArrayOf("text", upgradesArray);

        stmt.setArray(5, up);
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
            Array sqlArray = rs.getArray("upgrades");
            ArrayList<String> upgrades = new ArrayList<>();

            if (sqlArray != null) {
                String[] array = (String[]) sqlArray.getArray();
                upgrades = new ArrayList<>(Arrays.asList(array));
            }
            
            Save s = new Save(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("dia"),
                    rs.getDouble("dinheiro"),
                    upgrades
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
        String sql = "UPDATE save SET dia=?, dinheiro=?, upgrades=? WHERE id = ?";
        
            Connection connection = conexao.conectar(); 
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, s.getDia());
            stmt.setDouble(2, s.getDinheiro());
            
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
        stmt.executeUpdate();
    }
}