package com.mycompany.restaurante.Controller;

import com.mycompany.restaurante.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class CreditosController 
{    
    @FXML
    private void creditos() throws IOException 
    {
        App.setRoot("credito");
    }
    
    @FXML
    private void voltar() throws IOException
    {
        App.setRoot("menu");
    }
}