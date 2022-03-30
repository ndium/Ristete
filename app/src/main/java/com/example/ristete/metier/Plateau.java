package com.example.ristete.metier;

public class Plateau
{
    // Attributs
    private Cube[][] plateau;

    public Plateau( int lig, int col )
    {
        this.plateau = Plateau.initPlateau();
    }

    // Accesseurs
    public Cube getCase( int lig, int col ) { return this.plateau[lig][col]; }

    // Setters
    public void setCase( int lig, int col, Cube c ) { this.plateau[lig][col] = c; }


    // private merhodes
    private static Cube[][] initPlateau()
    {
        Cube[][] tab = new Cube[Ristete.LIGNES][Ristete.COLONNES];

        for( int i = 0; i < Ristete.LIGNES; i++ )
            for( int j = 0; j < Ristete.COLONNES; j++ )
                tab[i][j] = null;

        return tab;
    }

    public String toString()
    {
        // Bordure
        String bordure = "+";

        for( int i = 0; i < 10; i++ )
            bordure += "---+";

        bordure += "\n";

        // Affichage des extras lignes
        String sRet = "";

        for( int i = 0; i < Ristete.EXTRA_LIGNES; i++ )
        {
            for( int j = 0; j < Ristete.COLONNES; j++ )
            {
                sRet += "  " + (this.plateau[i][j]==null?" ":this.plateau[i][j]) + " ";
            }
            sRet += "\n";
        }

        // Affichage du tableau
        sRet += bordure;

        for( int i = 4; i < Ristete.LIGNES; i++ )
        {
            for( int j = 0; j < Ristete.COLONNES; j++ )
            {
                sRet += "| " + (this.plateau[i][j]==null?" ":this.plateau[i][j]) + " ";
            }
            sRet += "|\n" + bordure;
        }

        return sRet;
    }
}
