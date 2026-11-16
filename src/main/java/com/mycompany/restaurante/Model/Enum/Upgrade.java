package com.mycompany.restaurante.Model.Enum;

public enum Upgrade 
{
    LICENÇA_1(1),
    LICENÇA_2(2),
    LICENÇA_3(3),
    LICENÇA_4(4);
    
    private int licença;
    
    private Upgrade (int licença)
    {
        this.licença = licença;
    }
           
   private int getLicença()
   {
       return licença;
   }
}