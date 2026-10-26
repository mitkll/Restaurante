package com.mycompany.restaurante.DAO.Controller;

import com.mycompany.restaurante.DAO.SaveDAO;
import com.mycompany.restaurante.Model.Save;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaveC {
    SaveDAO dao = new SaveDAO();
    
    public Save inserir(int id, String n, int d, double dd, boolean nt, ArrayList u) throws SQLException{
        Save s = new Save(id,n,d,dd,nt,u);
        dao.add(s);
        return s;
    }
    
    public void save(){   
        try{
            List<Save> save = dao.save();
            for(Save s: save){
                System.out.println(s);
            }
        }
        catch (SQLException e){
            System.out.println(e);    
        }
    }
    
    public void saveId(int id){   
        try{
            List<Save> save = dao.saveId(id);
            for(Save s: save){
                System.out.println(s);
            }
        }
        catch (SQLException e){
            System.out.println(e);    
        }
    }
    
    public void atualizar(Save s) throws SQLException {
        dao.atualizar(s);
    }
    
    public void delete(int id) throws SQLException{
        dao.delete(id);
    }
}
