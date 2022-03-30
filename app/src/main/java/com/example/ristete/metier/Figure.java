package com.example.ristete.metier;

public class Figure
{
    // Constantes
    private static final int NB_CUBES = 4;

    // Attibuts
    private Cube[][] tabCube;   // Tableau qui, pour chaque ligne, stock la rotation d'une des figures

    private int rotationCount;  // Numéro de la rotation en cours. On fera '% 4' pour récupérer le bon indice.

    // Factory
    public static Figure creerFigure( int num )
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];
        char nom = ' ';

        switch( num )
        {
            case 1 : tab = Figure.creerO();
                     break;

            case 2 : tab = Figure.creerT();
                     break;

            case 3 : tab = Figure.creerI();
                     break;

            case 4 : tab = Figure.creerJ();
                     break;

            case 5 : tab = Figure.creerL();
                     break;

            case 6 : tab = Figure.creerZ();
                     break;

            case 7 : tab = Figure.creerS();
                     break;
        }

        return new Figure( tab );
    }

    // Constructeur privé
    private Figure( Cube[][] tab )
    {
        this.tabCube       = tab;
        this.rotationCount = 0;
    }

    // Accesseurs
    public Cube[][] getCubes()  { return this.tabCube;                  }
    public int      getIndRot() { return this.rotationCount % NB_CUBES; }

    // Setters
    public void incrementeRotCount() { this.rotationCount++; }


    // Methodes

    // Pour tous les cubes (et toutes les rotations), on décrémente y de 1
    public void aGauche()
    {
        for( int i = 0; i < NB_CUBES; i++ )
            for( int j = 0; j < NB_CUBES; j++ )
                this.tabCube[i][j].setY( this.tabCube[i][j].getY() - 1 );
    }

    // Pour tous les cubes (et toutes les rotations), on incrémente y de 1
    public void aDroite()
    {
        for( int i = 0; i < NB_CUBES; i++ )
            for( int j = 0; j < NB_CUBES; j++ )
                this.tabCube[i][j].setY( this.tabCube[i][j].getY() + 1 );
    }

    // Pour tous les cubes (et toutes les rotations), on incrémente x de 1
    public void enBas()
    {
        for( int i = 0; i < NB_CUBES; i++ )
            for( int j = 0; j < NB_CUBES; j++ )
                this.tabCube[i][j].setX( this.tabCube[i][j].getX() + 1 );
    }

    // Pour tous les cubes (et toutes les rotations), on met le cub à false
    public void mort()
    {
        for( int i = 0; i < NB_CUBES; i++ )
            for( int j = 0; j < NB_CUBES; j++ )
                this.tabCube[i][j].setMort();
    }


    // Private methods

    // On créer la pièce carré
    private static Cube[][] creerO()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        for( int i = 0; i < NB_CUBES; i++ )
        {
            tab[i][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'O' );
            tab[i][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'O' );  // X X
            tab[i][2] = new Cube( 0 + Ristete.EXTRA_LIGNES, 5, 'O' );  // X X
            tab[i][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'O' );
        }

        return tab;
    }


    // On créer la pièce en T
    private static Cube[][] creerT()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        tab[0][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'T' );
        tab[0][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'T' );  //   X
        tab[0][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3, 'T' );  // X X X
        tab[0][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'T' );

        tab[1][0] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4, 'T' );  // X
        tab[1][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'T' );  // X X
        tab[1][2] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'T' );  // X
        tab[1][3] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'T' );

        tab[2][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3, 'T' );
        tab[2][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'T' ); // X X X
        tab[2][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'T' ); //   X
        tab[2][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4, 'T' );

        tab[3][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'T' );  //   X
        tab[3][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'T' );  // X X
        tab[3][2] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4, 'T' );  //   X
        tab[3][3] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3, 'T' );

        return tab;
    }

    private static Cube[][] creerI()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        tab[0][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 3, 'I' );
        tab[0][1] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'I' );  // X X X X
        tab[0][2] = new Cube( 0 + Ristete.EXTRA_LIGNES, 5, 'I' );
        tab[0][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 6, 'I' );

        tab[1][0] = new Cube( -1 + Ristete.EXTRA_LIGNES, 5, 'I' );  //   X
        tab[1][1] = new Cube(  0 + Ristete.EXTRA_LIGNES, 5, 'I' );  //   X
        tab[1][2] = new Cube(  1 + Ristete.EXTRA_LIGNES, 5, 'I' );  //   X
        tab[1][3] = new Cube(  2 + Ristete.EXTRA_LIGNES, 5, 'I' );  //   X

        tab[2][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3, 'I' );
        tab[2][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'I' );
        tab[2][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'I' );   // X X X X
        tab[2][3] = new Cube( 1 + Ristete.EXTRA_LIGNES, 6, 'I' );

        tab[3][0] = new Cube( -1 + Ristete.EXTRA_LIGNES, 4, 'I' );  // X
        tab[3][1] = new Cube(  0 + Ristete.EXTRA_LIGNES, 4, 'I' );  // X
        tab[3][2] = new Cube(  1 + Ristete.EXTRA_LIGNES, 4, 'I' );  // X
        tab[3][3] = new Cube(  2 + Ristete.EXTRA_LIGNES, 4, 'I' );  // X

        return tab;
    }

    private static Cube[][] creerJ()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        tab[0][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'J' );
        tab[0][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'J' );  // X
        tab[0][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3, 'J' );  // X X X
        tab[0][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 3, 'J' );

        tab[1][0] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4, 'J' );  // X X
        tab[1][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'J' );  // X
        tab[1][2] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'J' );  // X
        tab[1][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 5, 'J' );

        tab[2][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3, 'J' );
        tab[2][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'J' );  // X X X
        tab[2][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'J' );  //     X
        tab[2][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 5, 'J' );

        tab[3][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'J' );  //   X
        tab[3][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'J' );  //   X
        tab[3][2] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4, 'J' );  // X X
        tab[3][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 3, 'J' );

        return tab;
    }

    private static Cube[][] creerL()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        tab[0][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'L' );
        tab[0][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'L' );  //     X
        tab[0][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3, 'L' );  // X X X
        tab[0][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 5, 'L' );

        tab[1][0] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4, 'L' );  // X
        tab[1][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'L' );  // X
        tab[1][2] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'L' );  // X X
        tab[1][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 5, 'L' );

        tab[2][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3, 'L' );
        tab[2][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'L' );  // X X X
        tab[2][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'L' );  // X
        tab[2][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 3, 'L' );

        tab[3][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'L' );  // X X
        tab[3][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'L' );  //   X
        tab[3][2] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4, 'L' );  //   X
        tab[3][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 3, 'L' );

        return tab;
    }

    private static Cube[][] creerZ()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        tab[0][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 3, 'Z' );
        tab[0][1] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'Z' );  // X X
        tab[0][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'Z' );  //   X X
        tab[0][3] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'Z' );

        tab[1][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 5, 'Z' );  //   X
        tab[1][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'Z' );  // X X
        tab[1][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'Z' );  // X
        tab[1][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4, 'Z' );

        tab[2][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3, 'Z' );
        tab[2][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'Z' );  // X X
        tab[2][2] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4, 'Z' );  //   X X
        tab[2][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 5, 'Z' );

        tab[3][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'Z' );  //   X
        tab[3][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'Z' );  // X X
        tab[3][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3, 'Z' );  // X
        tab[3][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 3, 'Z' );

        return tab;
    }

    private static Cube[][] creerS()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        tab[0][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 5, 'S' );
        tab[0][1] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'S' );  //   X X
        tab[0][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'S' );  // X X
        tab[0][3] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3, 'S' );

        tab[1][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4, 'S' );  // X
        tab[1][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'S' );  // X X
        tab[1][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'S' );  //   X
        tab[1][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 5, 'S' );

        tab[2][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5, 'S' );
        tab[2][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'S' );  //   X X
        tab[2][2] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4, 'S' );  // X X
        tab[2][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 3, 'S' );

        tab[3][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 3, 'S' );  // X
        tab[3][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3, 'S' );  // X X
        tab[3][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4, 'S' );  //   X
        tab[3][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4, 'S' );

        return tab;
    }
}
