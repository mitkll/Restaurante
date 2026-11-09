package com.mycompany.restaurante.Model;

public enum Enum 
{
    LICENÇA_1(1),
    LICENÇA_2(2),
    LICENÇA_3(3),
    LICENÇA_4(4);
    
    private int licença;
    
    private Enum (int licença)
    {
        this.licença = licença;
    }
           
   private int getLicença()
   {
       return licença;
   }
}

enum Ingredientes
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

enum Receitas
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