package com.example.ristete;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.example.ristete.metier.Plateau;
import com.example.ristete.metier.Ristete;

public class ZoneDessin extends View
{
    private Ristete ristete;

    private Paint grille     = new Paint();
    private Paint bordure    = new Paint();
    private Paint extraLigne = new Paint();

    private Paint figureO = new Paint();
    private Paint figureZ = new Paint();
    private Paint figureS = new Paint();
    private Paint figureL = new Paint();
    private Paint figureJ = new Paint();
    private Paint figureT = new Paint();
    private Paint figureI = new Paint();

    public ZoneDessin(Context context, Ristete ristete)
    {
        super( context );
        setFocusable( true );
        this.ristete = ristete;
        System.out.println( this.ristete );

        //Style de la grille et des bordures
        grille.setColor( Color.DKGRAY );
        grille.setAntiAlias(true);
        grille.setStyle(Paint.Style.STROKE);
        grille.setStrokeWidth(3);

        bordure.setColor( Color.WHITE );
        bordure.setAntiAlias(true);
        bordure.setStyle(Paint.Style.STROKE);
        bordure.setStrokeWidth(5);

        extraLigne.setColor( Color.TRANSPARENT );


        //Style des figures
        figureO.setColor( Color.YELLOW );
        figureO.setAntiAlias(true);
        figureO.setStyle(Paint.Style.FILL);
        figureO.setStrokeWidth(1);

        figureZ.setColor( Color.RED );
        figureZ.setAntiAlias(true);
        figureZ.setStyle(Paint.Style.FILL);
        figureZ.setStrokeWidth(1);

        figureS.setColor( Color.rgb(248,175,40) );
        figureS.setAntiAlias(true);
        figureS.setStyle(Paint.Style.FILL);
        figureS.setStrokeWidth(1);

        figureL.setColor( Color.GREEN );
        figureL.setAntiAlias(true);
        figureL.setStyle(Paint.Style.FILL);
        figureL.setStrokeWidth(1);

        figureJ.setColor( Color.rgb(189,40,248) );
        figureJ.setAntiAlias(true);
        figureJ.setStyle(Paint.Style.FILL);
        figureJ.setStrokeWidth(1);

        figureT.setColor( Color.rgb(249,75,202) );
        figureT.setAntiAlias(true);
        figureT.setStyle(Paint.Style.FILL);
        figureT.setStrokeWidth(1);

        figureI.setColor( Color.BLUE );
        figureI.setAntiAlias(true);
        figureI.setStyle(Paint.Style.FILL);
        figureI.setStrokeWidth(1);

        // Ajout des listeners
        //this.setOnTouchListener( this );
//        this.setOnClickListener( this );
    }

    public void onDraw( Canvas canvas )
    {
        // Récupération des mesures
        int largeurGrille = canvas.getWidth()-((canvas.getWidth()/10)*2); //80%
        int largeurCube   = largeurGrille/10;

        // Création de la grille de jeu
        this.dessinerBordure( canvas, largeurCube );

        // Dessin du plateau
        this.dessinerPlateau( canvas, largeurCube );

        this.PrintScore(canvas);

    }

    private void PrintScore(Canvas canvas)
    {
        int score = this.ristete.getScore();
        Paint paint = new Paint();
        paint.setColor(Color.TRANSPARENT);
        canvas.drawRect(0, 100, 200, 200, paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(100);
        canvas.drawText(Integer.toString(score), 80, 170, paint);

    }

    public void dessinerBordure( Canvas canvas, int largeurCube )
    {
        for( int i = 0; i < Ristete.COLONNES; i++ )
        {
            for( int j = 4; j < Ristete.LIGNES; j++ )
            {
                canvas.drawRect((canvas.getWidth()/10) + largeurCube * i,
                        canvas.getHeight()/20 + (largeurCube * j),
                        (canvas.getWidth()/10) + largeurCube + (largeurCube * i),
                        canvas.getHeight()/20+ largeurCube + (largeurCube * j), this.grille);
            }
        }

        // Dessin de la bordure
        canvas.drawRect((canvas.getWidth()/10),
                canvas.getHeight()/20 + (largeurCube * 4),
                (canvas.getWidth()/10) + largeurCube + (largeurCube * (Ristete.COLONNES - 1)),
                canvas.getHeight()/20+ largeurCube + (largeurCube * (Ristete.LIGNES - 1)), this.bordure);
    }

    public void dessinerPlateau( Canvas canvas, int largeurCube )
    {
        Plateau pl = this.ristete.getPlateau();

        // On dessine le plateau
        for( int i = 0; i < Ristete.LIGNES; i++ )
        {
            for( int j = 0; j < Ristete.COLONNES; j++ )
            {
                if( pl.getCase( i, j ) != null )
                {
                    char nom = pl.getCase( i, j ).getNom();

                    switch( nom )
                    {
                        case 'O' : canvas.drawRect((canvas.getWidth()/10) + largeurCube * j, canvas.getHeight()/20 + (largeurCube * i),
                                (canvas.getWidth()/10) + largeurCube + (largeurCube * j), canvas.getHeight()/20+ largeurCube + (largeurCube * i), this.figureO);
                            break;

                        case 'Z' : canvas.drawRect((canvas.getWidth()/10) + largeurCube * j, canvas.getHeight()/20 + (largeurCube * i),
                                (canvas.getWidth()/10) + largeurCube + (largeurCube * j), canvas.getHeight()/20+ largeurCube + (largeurCube * i), this.figureZ);
                            break;

                        case 'S' : canvas.drawRect((canvas.getWidth()/10) + largeurCube * j, canvas.getHeight()/20 + (largeurCube * i),
                                (canvas.getWidth()/10) + largeurCube + (largeurCube * j), canvas.getHeight()/20+ largeurCube + (largeurCube * i), this.figureS);
                            break;

                        case 'L' : canvas.drawRect((canvas.getWidth()/10) + largeurCube * j, canvas.getHeight()/20 + (largeurCube * i),
                                (canvas.getWidth()/10) + largeurCube + (largeurCube * j), canvas.getHeight()/20+ largeurCube + (largeurCube * i), this.figureL);
                            break;

                        case 'J' : canvas.drawRect((canvas.getWidth()/10) + largeurCube * j, canvas.getHeight()/20 + (largeurCube * i),
                                (canvas.getWidth()/10) + largeurCube + (largeurCube * j), canvas.getHeight()/20+ largeurCube + (largeurCube * i), this.figureJ);
                            break;

                        case 'T' : canvas.drawRect((canvas.getWidth()/10) + largeurCube * j, canvas.getHeight()/20 + (largeurCube * i),
                                (canvas.getWidth()/10) + largeurCube + (largeurCube * j), canvas.getHeight()/20+ largeurCube + (largeurCube * i), this.figureT);
                            break;

                        case 'I' : canvas.drawRect((canvas.getWidth()/10) + largeurCube * j, canvas.getHeight()/20 + (largeurCube * i),
                                (canvas.getWidth()/10) + largeurCube + (largeurCube * j), canvas.getHeight()/20+ largeurCube + (largeurCube * i), this.figureI);
                            break;
                    }
                }
            }
        }
    }

}
