package com.example.ristete.metier;

public class Figure
{
    // Constantes
    private static final int NB_CUBES = 4;

    // Attibuts
    private Cube[][] tabCube;   // Tableau qui, pour chaque ligne, stock la rotation d'une des figures

    private String color;

//    private final String JAUNE  = "#FBFF00";
//    private final String ROUGE  = "#FF0000";
//    private final String ORANGE = "#FFA200";
//    private final String VERT   = "#24D101";
//    private final String VIOLET = "#C801D1";
//    private final String ROSE   = "#FF94DA";
//    private final String BLEU   = "#2252FF";

    private int rotationCount;  // Numéro de la rotation en cours. On fera '% 4' pour récupérer le bon indice.

    // Factory
    public static Figure creerFigure( int num )
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];
        String color = "";

        switch( num )
        {
            case 1 : tab = Figure.creerO();
                     color = "YELLOW";
                     break;

            case 2 : tab = Figure.creerT();
                     color = "PINK";
                     break;

            case 3 : tab = Figure.creerI();
                     color = "BLUE";
                     break;

            case 4 : tab = Figure.creerJ();
                     color = "PURPLE";
                     break;

            case 5 : tab = Figure.creerL();
                     color = "GREEN";
                     break;

            case 6 : tab = Figure.creerZ();
                     color = "RED";
                     break;

            case 7 : tab = Figure.creerS();
                     color = "ORANGE";
                     break;
        }

        return new Figure( tab, color );
    }

    // Constructeur privé
    private Figure( Cube[][] tab, String color )
    {
        this.tabCube = tab;
        this.color   = color;

        this.rotationCount = 0;
    }

    // Accesseurs
    public Cube[][] getCubes()  { return this.tabCube;                  }
    public String   getColor()  { return this.color;                    }
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
            tab[i][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 );
            tab[i][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X X
            tab[i][2] = new Cube( 0 + Ristete.EXTRA_LIGNES, 5 );  // X X
            tab[i][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );
        }

        return tab;
    }


    // On créer la pièce en T
    private static Cube[][] creerT()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        tab[0][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 );
        tab[0][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  //   X
        tab[0][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3 );  // X X X
        tab[0][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );

        tab[1][0] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4 );  // X
        tab[1][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X X
        tab[1][2] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );  // X
        tab[1][3] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 );

        tab[2][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3 );
        tab[2][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 ); // X X X
        tab[2][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 ); //   X
        tab[2][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4 );

        tab[3][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );  //   X
        tab[3][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X X
        tab[3][2] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4 );  //   X
        tab[3][3] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3 );

        return tab;
    }

    private static Cube[][] creerI()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        tab[0][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 3 );
        tab[0][1] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );  // X X X X
        tab[0][2] = new Cube( 0 + Ristete.EXTRA_LIGNES, 5 );
        tab[0][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 6 );

        tab[1][0] = new Cube( -1 + Ristete.EXTRA_LIGNES, 5 );  //   X
        tab[1][1] = new Cube(  0 + Ristete.EXTRA_LIGNES, 5 );  //   X
        tab[1][2] = new Cube(  1 + Ristete.EXTRA_LIGNES, 5 );  //   X
        tab[1][3] = new Cube(  2 + Ristete.EXTRA_LIGNES, 5 );  //   X

        tab[2][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3 );
        tab[2][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );
        tab[2][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 );   // X X X X
        tab[2][3] = new Cube( 1 + Ristete.EXTRA_LIGNES, 6 );

        tab[3][0] = new Cube( -1 + Ristete.EXTRA_LIGNES, 4 );  // X
        tab[3][1] = new Cube(  0 + Ristete.EXTRA_LIGNES, 4 );  // X
        tab[3][2] = new Cube(  1 + Ristete.EXTRA_LIGNES, 4 );  // X
        tab[3][3] = new Cube(  2 + Ristete.EXTRA_LIGNES, 4 );  // X

        return tab;
    }

    private static Cube[][] creerJ()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        tab[0][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 );
        tab[0][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X
        tab[0][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3 );  // X X X
        tab[0][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 3 );

        tab[1][0] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4 );  // X X
        tab[1][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X
        tab[1][2] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );  // X
        tab[1][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 5 );

        tab[2][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3 );
        tab[2][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X X X
        tab[2][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 );  //     X
        tab[2][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 5 );

        tab[3][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );  //   X
        tab[3][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  //   X
        tab[3][2] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4 );  // X X
        tab[3][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 3 );

        return tab;
    }

    private static Cube[][] creerL()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        tab[0][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 );
        tab[0][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  //     X
        tab[0][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3 );  // X X X
        tab[0][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 5 );

        tab[1][0] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4 );  // X
        tab[1][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X
        tab[1][2] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );  // X X
        tab[1][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 5 );

        tab[2][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3 );
        tab[2][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X X X
        tab[2][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 );  // X
        tab[2][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 3 );

        tab[3][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );  // X X
        tab[3][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  //   X
        tab[3][2] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4 );  //   X
        tab[3][3] = new Cube( 0 + Ristete.EXTRA_LIGNES, 3 );

        return tab;
    }

    private static Cube[][] creerZ()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        tab[0][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 3 );
        tab[0][1] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );  // X X
        tab[0][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  //   X X
        tab[0][3] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 );

        tab[1][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 5 );  //   X
        tab[1][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 );  // X X
        tab[1][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X
        tab[1][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4 );

        tab[2][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3 );
        tab[2][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X X
        tab[2][2] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4 );  //   X X
        tab[2][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 5 );

        tab[3][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );  //   X
        tab[3][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X X
        tab[3][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3 );  // X
        tab[3][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 3 );

        return tab;
    }

    private static Cube[][] creerS()
    {
        Cube[][] tab = new Cube[NB_CUBES][NB_CUBES];

        tab[0][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 5 );
        tab[0][1] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );  //   X X
        tab[0][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X X
        tab[0][3] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3 );

        tab[1][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 4 );  // X
        tab[1][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  // X X
        tab[1][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 );  //   X
        tab[1][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 5 );

        tab[2][0] = new Cube( 1 + Ristete.EXTRA_LIGNES, 5 );
        tab[2][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  //   X X
        tab[2][2] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4 );  // X X
        tab[2][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 3 );

        tab[3][0] = new Cube( 0 + Ristete.EXTRA_LIGNES, 3 );  // X
        tab[3][1] = new Cube( 1 + Ristete.EXTRA_LIGNES, 3 );  // X X
        tab[3][2] = new Cube( 1 + Ristete.EXTRA_LIGNES, 4 );  //   X
        tab[3][3] = new Cube( 2 + Ristete.EXTRA_LIGNES, 4 );

        return tab;
    }
}
