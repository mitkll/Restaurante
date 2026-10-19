/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/*import java.util.ArrayList;
import java.util.List;
import com.mycompany.restaurante.DAO.utils.Conexao;
import shogunato.Enum.Classe;
import shogunato.Enum.Condicao;
import shogunato.Enum.Elemento;
import shogunato.Enum.Flecha;
import shogunato.Model.Samurai;*/

/**
 *
 * @author jonat
 */
public class SamuraiDAO {
    /*Conexao conexao = new Conexao();
    public int add(Samurai s) throws SQLException{
        String sql = "INSERT INTO samurai (nome, nivel, xp, pe, pem, vida, vm, flechaqtde, dinheiro, andar, elixir, flecha, clas, cond, elem) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
        {
            Connection connection = conexao.conectar();
            
            PreparedStatement stmt = connection.prepareStatement(sql);
                    
            stmt.setString(1, s.getNome());
            stmt.setInt(2, s.getNivel());
            stmt.setInt(3, s.getXp());
            stmt.setInt(4, s.getPe());
            stmt.setInt(5, s.getPem());
            stmt.setDouble(6, s.getVida());
            stmt.setDouble(7, s.getVm());
            stmt.setInt(8, s.getFlechaQtde());
            stmt.setInt(9, s.getDinheiro());
            stmt.setInt(10, s.getAndar());
            stmt.setInt(11, s.getElixirV());
            stmt.setString(12, s.getFlecha().name());
            stmt.setString(13, s.getClas().name());
            stmt.setString(14, s.getCond().name());
            stmt.setString(15, s.getElem().name());
                    
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    s.setId(id);           
                    return id;
                }
            }
        }
        return -1;
    }
    public List<Samurai> save() throws SQLException    {
        String sql = "SELECT * FROM samurai";
        
        List<Samurai> sLista = new ArrayList<>();    
        {
            Connection connection = conexao.conectar();            
            PreparedStatement stmt = connection.prepareStatement(sql);                    
            ResultSet rs = stmt.executeQuery();                    
            while(rs.next()){
                Samurai s = new Samurai();
                
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                s.setNivel(rs.getInt("nivel"));
                s.setXp(rs.getInt("xp"));
                s.setPe(rs.getInt("pe"));
                s.setPem(rs.getInt("pem"));
                s.setVida(rs.getInt("vida"));
                s.setVm(rs.getInt("vm"));
                s.setFlechaQtde(rs.getInt("flechaqtde"));
                s.setDinheiro(rs.getInt("dinheiro"));
                s.setAndar(rs.getInt("andar"));
                s.setElixirV(rs.getInt("elixir"));
                s.setFlecha(Flecha.valueOf(rs.getString("flecha")));
                s.setClas(Classe.valueOf(rs.getString("clas")));
                s.setCond(Condicao.valueOf(rs.getString("cond")));
                s.setElem(Elemento.valueOf(rs.getString("elem")));

                sLista.add(s);
            }
                    
            return sLista;
            }
    }
    public void atualizar(Samurai s) throws SQLException {
        String sql = "UPDATE samurai SET nivel=?, xp=?, vida=?, vm=?, dinheiro=?, andar=?, elixir=?, cond=? WHERE id = ?";
        {
            Connection connection = conexao.conectar(); 
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, s.getNivel());
            stmt.setInt(2, s.getXp());
            stmt.setDouble(3, s.getVida());
            stmt.setDouble(4, s.getVm());
            stmt.setInt(5, s.getDinheiro());
            stmt.setInt(6, s.getAndar());
            stmt.setInt(7, s.getElixirV());
            stmt.setString(8, s.getCond().name());
            stmt.setInt(9, s.getId());

            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("");
            }
        }
    }
    public void atualizarN(Samurai s) throws SQLException {
        String sql = "UPDATE samurai SET nivel=?, xp=?, pe=?, pem=?, vida=?, vm=?, dinheiro=?, andar=?, elixir=?, cond=? WHERE id = ?";

        try (Connection connection = conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, s.getNivel());
            stmt.setInt(2, s.getXp());
            stmt.setInt(3, s.getPe());
            stmt.setInt(4, s.getPem());
            stmt.setDouble(5, s.getVida());
            stmt.setDouble(6, s.getVm());
            stmt.setInt(7, s.getDinheiro());
            stmt.setInt(8, s.getAndar());
            stmt.setInt(9, s.getElixirV());
            stmt.setString(10, s.getCond().name());
            stmt.setInt(11, s.getId());

            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("");
            }
        }
    }
    public void atualizarAq(Samurai s) throws SQLException {
        String sql = "UPDATE samurai SET nivel=?, xp=?, vida=?, vm=?, flechaqtde=?, dinheiro=?, andar=?, elixir=?, flecha=?, cond=? WHERE id = ?";
        {
            Connection connection = conexao.conectar(); 
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, s.getNivel());
            stmt.setInt(2, s.getXp());
            stmt.setDouble(3, s.getVida());
            stmt.setDouble(4, s.getVm());
            stmt.setInt(5, s.getFlechaQtde());
            stmt.setInt(6, s.getDinheiro());
            stmt.setInt(7, s.getAndar());
            stmt.setInt(8, s.getElixirV());
            stmt.setString(9, s.getFlecha().name());
            stmt.setString(10, s.getCond().name());
            stmt.setInt(11, s.getId());

            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("");
            }
        }
    }*/
}