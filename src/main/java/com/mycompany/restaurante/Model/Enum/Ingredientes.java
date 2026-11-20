package com.mycompany.restaurante.Model.Enum;

public enum Ingredientes
{
    I1("ÁLCOOL"),
    I2("BALUT"),
    I3("CAFÉ"),
    I4("CÉREBRO"),
    I5("CINZA"),
    I6("DENTE"),
    I7("ESPONJA"),
    I8("FARINHA"),
    I9("FOLHA_SECA"),
    I10("FRUTA_PODRE"),
    I11("GELO"),
    I12("LEITE"),
    I13("OLHO"),
    I14("OVÁRIO"),
    I15("PÃO"),
    I16("POLVO"),
    I17("QUEIJO_MOFADO"),
    I18("RATO"),
    I19("SANGUE"),
    I20("SAGUESSUGA"),
    I21("SAPO_PEÇONHENTO"),
    I22("TESTÍCULO"),
    I23("VIDRO");
    
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
