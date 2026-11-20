package com.mycompany.restaurante.Model.Enum;

public enum Receitas
{
    R1("BOLO CACHORAS"),
    R2("CAIPIRINHA"),
    R3("SANDUÍCHE"),
    R4("BOLO CROCANTE"),
    R5("COQUETEL"),
    R6("SALADAGOURMET"),
    R7("POLVO REFOGADO"),
    R8("SMOOTHIE"),
    R9("TIRAMISÚ"),
    R10("ENSOPADO GROTESCO"),
    R11("LASANHA"),
    R12("MODA CASA");

    private String receita;
    
    private Receitas(String receita)
    {
        this.receita = receita;
    }
           
   public String getReceita()
   {
       return receita;
   }
}