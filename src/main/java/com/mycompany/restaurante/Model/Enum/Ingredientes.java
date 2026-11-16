package com.mycompany.restaurante.Model.Enum;

public enum Ingredientes
{
    ÁLCOOL(1),
    BALUT(2),
    CAFÉ(3),
    CÉREBRO(4),
    CINZA(5),
    DENTE(6),
    ESPONJA(7),
    FARINHA(8),
    FOLHA_SECA(9),
    FRUTA_PODRE(10),
    GELO(11),
    LEITE(12),
    OLHO(13),
    OVÁRIO(14),
    PÃO(15),
    POLVO(16),
    QUEIJO_MOFADO(17),
    RATO(18),
    SANGUE(19),
    SAGUESSUGA(20),
    SAPO_PEÇONHENTO(21),
    TESTÍCULO(22),
    VIDRO(23);

    private int ingrediente;
    
    private Ingredientes(int ingrediente)
    {
        this.ingrediente = ingrediente;
    }
           
   private int getIngrediente()
   {
       return ingrediente;
   }
}
