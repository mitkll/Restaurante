package com.mycompany.restaurante.Model.Enum;

public enum Receitas
{
    BOLO_CACHORAS(1),
    CAIPIRINHA(2),
    SANDUÍCHE(3),
    BOLO_CROCANTE(4),
    COQUETEL(5),
    SALADA_GOURMET(6),
    POLVO_REFOGADO(7),
    SMOOTHIE(8),
    TIRAMISÚ(9),
    ENSOPADO_GROTESCO(10),
    LASANHA(11),
    MODA_CASA(12);

    private int receita;
    
    private Receitas(int receita)
    {
        this.receita = receita;
    }
           
   private int getReceita()
   {
       return receita;
   }
}