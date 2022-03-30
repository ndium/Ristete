package com.example.ristete.metier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ristete
{
    // constantes
    public static final int LIGNES       = 20;
    public static final int COLONNES     = 10;
    public static final int EXTRA_LIGNES = 4;

    // Attributs
    private Plateau plateau;

    private List<Figure> lstFigure;
    private Figure       figureCourante;
    private Thread       descente;

    private int numFigCourante;
    private int score;

    private boolean aPerdu;

    public Ristete()
    {
        // On initialise les attributs
        this.plateau = new Plateau( LIGNES, COLONNES );
        this.score   = 0;
        this.aPerdu  = false;

        // On initialise la liste contenant les différentes figures existantes
        this.lstFigure = new ArrayList<>();
        this.genererFigures();
        this.changerFigure();

        // Créaton du Thread pour la descente
        //this.descente = new ThreadDescente( this );
        //this.descente.start();

        // Boucle de jeu
        while( !this.aPerdu() )
        {
//            this.maj();
//            this.jouer();
        }

        try                 { this.descente.interrupt(); }
        catch (Exception e) { e.printStackTrace();       }
    }

    // Getters
    public boolean aPerdu() { return this.aPerdu; }
    public Figure getFigureCourante() { return this.figureCourante; }

    // Methods
//    public void jouer()
//    {
//        String action = System.console().readLine();
//
//        switch( action )
//        {
//            case "z", "Z" -> this.rotation();
//
//            case "q", "Q" -> this.allerAGauche();
//
//            case "s", "S" -> this.allerEnBas();
//
//            case "d", "D" -> this.allerADroite();
//
//            case "e", "E" -> this.toutEnBas();
//        }
//    }

    // Methode pour savoir si l'on peut se déplacer à gauche
    public void allerAGauche()
    {
        Cube[] tab = this.figureCourante.getCubes()[this.figureCourante.getIndRot()];

        for( Cube c : tab )
        {
            if( c.getY() - 1 < 0 )
                return;

            if( this.plateau.getCase( c.getX(), c.getY() - 1) instanceof Cube && !this.plateau.getCase( c.getX(), c.getY() - 1 ).estVivant() )
                return;
        }

        this.figureCourante.aGauche();


        for( Cube c : tab )
            this.plateau.setCase( c.getX(), c.getY() + 1, null );

        for( Cube c : tab )
            this.plateau.setCase( c.getX(), c.getY(), c   );

    }

    // Methode pour savoir si l'on peut se déplacer à droite
    public void allerADroite()
    {
        Cube[] tab = this.figureCourante.getCubes()[this.figureCourante.getIndRot()];

        for( Cube c : tab )
        {
            if( c.getY() + 1 >= Ristete.COLONNES )
                return;

            if( this.plateau.getCase( c.getX(), c.getY() + 1) instanceof Cube && !this.plateau.getCase( c.getX(), c.getY() + 1 ).estVivant() )
                return;
        }

        this.figureCourante.aDroite();

        for( Cube c : tab )
            this.plateau.setCase( c.getX(), c.getY() - 1, null );

        for( Cube c : tab )
            this.plateau.setCase( c.getX(), c.getY(), c   );
    }

    // Methode pour savoir si l'on peut se déplacer vers le bas
    public synchronized boolean allerEnBas()
    {
        Cube[] tab = this.figureCourante.getCubes()[this.figureCourante.getIndRot()];

        for( Cube c : tab )
        {
            if( (c.getX() + 1 >= Ristete.LIGNES) || (this.plateau.getCase( c.getX() + 1, c.getY()) instanceof Cube && !this.plateau.getCase( c.getX() + 1, c.getY() ).estVivant()) )
            {
                this.ligneEntiere();
                this.perdu();
                this.changerFigure();
                return false;
            }
        }

        this.figureCourante.enBas();

        for( Cube c : tab )
            this.plateau.setCase( c.getX() - 1, c.getY(), null );

        for( Cube c : tab )
            this.plateau.setCase( c.getX(), c.getY(), c   );

        return true;
    }

    // Methode qui va faire descendre la figure courante le plus bas possible
    public void toutEnBas()
    {
        int ligDebut = 0;

        for( Cube c : this.figureCourante.getCubes()[this.figureCourante.getIndRot()] )
            if( c.getX() > ligDebut )
                ligDebut = c.getX();

        boolean bOk = true;
        for( int lig = ligDebut; lig < LIGNES && bOk; lig++ )
            bOk = this.allerEnBas();
    }

    // Methode qui va tourner la piece dans le sens horaire
    public void rotation()
    {
        // Vérification de la possibilité de rotation
        for( Cube c : this.figureCourante.getCubes()[(this.figureCourante.getIndRot() + 1) % 4] )
            if( (c.getX() < 0 || c.getX() >= Ristete.LIGNES) || (c.getY() < 0 || c.getY() >= Ristete.COLONNES) || (this.plateau.getCase( c.getX(), c.getY()) instanceof Cube && !this.plateau.getCase( c.getX(), c.getY() ).estVivant()) )
                return;

        for( Cube c : this.figureCourante.getCubes()[this.figureCourante.getIndRot()] )
            this.plateau.setCase( c.getX(), c.getY(), null );

        this.figureCourante.incrementeRotCount();

        for( Cube c : this.figureCourante.getCubes()[this.figureCourante.getIndRot()] )
            this.plateau.setCase( c.getX(), c.getY(), c );
    }

//    public void maj()
//    {
//        System.out.println( "Score : " + this.score );
//        System.out.println( this.plateau            );
//    }

    // Methode pour changer de figure
    public void changerFigure()
    {
        if( this.figureCourante != null )
            this.figureCourante.mort();

        if( this.numFigCourante == 7 )
        {
            this.genererFigures();
        }

        this.figureCourante = this.lstFigure.get( this.numFigCourante++ );

        // On ajoute la figure au plateau
        Cube[]  tab = this.figureCourante.getCubes()[this.figureCourante.getIndRot()];
        boolean bOk;

        do
        {
            bOk = true;

            for( Cube c : tab )
                if( this.plateau.getCase( c.getX(), c.getY() ) != null )
                    bOk = false;

            if( !bOk )
            {
                for( int i = 0; i < 4; i++ )
                    for( Cube c : this.figureCourante.getCubes()[i] )
                        c.setX( c.getX() - 1 );
            }

        } while( !bOk );

        for( Cube c : this.figureCourante.getCubes()[this.figureCourante.getIndRot()] )
            this.plateau.setCase( c.getX(), c.getY(), c );
    }

    // Methode qui teste les conditions de défaite
    public void perdu()
    {
        for( int i = 0; i < Ristete.EXTRA_LIGNES; i++ )
            for( int j = 0; j < Ristete.COLONNES; j++ )
                if( this.plateau.getCase( i, j ) != null )
                {
                    this.aPerdu = true;
                    return;
                }

        this.aPerdu = false;
    }

    // privates Methods
    // Methode qui vérifie si une ligne (ou plus) a complètement été compléter
    private void ligneEntiere()
    {
        boolean bOk;
        int     nbLigneEntiere = 0;

        for( int i = 0; i < Ristete.LIGNES; i++ )
        {
            bOk = true;

            for( int j = 0; j < Ristete.COLONNES; j++ )
                if( this.plateau.getCase( i, j ) == null )
                    bOk = false;

            if( bOk )
            {
                for( int k = 0; k < Ristete.COLONNES; k++ )
                    this.plateau.setCase( i, k, null );

                this.decalerLigne( i - 1 );
                nbLigneEntiere++;
                i--;
            }

        }

        switch( nbLigneEntiere )
        {
            case 1 : this.score += 40;   break;
            case 2 : this.score += 100;  break;
            case 3 : this.score += 300;  break;
            case 4 : this.score += 1200; break;
        }
    }

    // Methode pour décaler les lignes lorsqu'une d'elle est complété
    private void decalerLigne( int lig )
    {
        for( int i = lig; i >= 0; i-- )
        {
            for( int j = 0; j < Ristete.COLONNES; j++ )
            {
                if( this.plateau.getCase( i + 1, j ) == null && this.plateau.getCase( i, j ) != null )
                {
                    this.plateau.setCase( i + 1, j, this.plateau.getCase( i, j ) );
                    this.plateau.setCase( i, j, null );
                }
            }
        }
    }

    // On génèr la liste des figures
    private void genererFigures()
    {
        this.numFigCourante = 0;
        this.lstFigure.clear();

        // On initialise la liste avec toutes les figures existantes
        for( int i = 0; i < 7; i++ )
            this.lstFigure.add( Figure.creerFigure( i + 1 ) );

        // On mélange aléatoirement la liste des figures
        Collections.shuffle( this.lstFigure );
    }
}
