package com.mycompany.restaurante.Model.Enum;

public enum Ingredientes
{
    I1("ÁLCOOL"),
    I2("BALUT"),
    I3("CÉREBRO"),
    I4("CINZA"),
    I5("ESPONJA"),
    I6("FOLHA_SECA"),
    I7("FRUTA_PODRE"),
    I8("OLHO"),
    I9("OVÁRIO"),
    I10("QUEIJO_MOFADO"),
    I11("RATO"),
    I12("SANGUE"),
    I13("SAGUESSUGA"),
    I14("SAPO_PEÇONHENTO"),
    I15("TESTÍCULO"),
    I16("VIDRO");
    
    private String ingrediente;
    
    private Ingredientes(String ingrediente)
    {
        this.ingrediente = ingrediente;
    }
           
   public String getIngrediente()
   {
       return ingrediente;
   }
}
