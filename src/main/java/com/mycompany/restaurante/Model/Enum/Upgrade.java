package com.mycompany.restaurante.Model.Enum;

public enum Upgrade 
{
    L1(1),
    L2(2),
    L3(3),
    L4(4);
    
    private int licença;
    
    private Upgrade (int licença)
    {
        this.licença = licença;
    }
           
   public int getLicença()
   {
       return licença;
   }
}