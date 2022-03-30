package com.example.ristete;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.example.ristete.metier.Ristete;

public class ZoneDessin extends View
{
    private Ristete ristete;

    private Paint grille = new Paint();
    private Paint bordure = new Paint();

    private Paint figureCarre  = new Paint();
    private Paint figureZ  = new Paint();
    private Paint figureS  = new Paint();
    private Paint figureL  = new Paint();
    private Paint figureJ  = new Paint();
    private Paint figureT  = new Paint();
    private Paint figureI  = new Paint();


    public ZoneDessin(Context context, Ristete ristete)
    {
        super( context );
        setFocusable( true );
        this.ristete = ristete;

        //Style de la grille et des bordures
        grille.setColor( Color.DKGRAY );
        grille.setAntiAlias(true);
        grille.setStyle(Paint.Style.STROKE);
        grille.setStrokeWidth(3);

        bordure.setColor( Color.WHITE );
        bordure.setAntiAlias(true);
        bordure.setStyle(Paint.Style.STROKE);
        bordure.setStrokeWidth(5);


        //Style des figures
        figureCarre.setColor( Color.YELLOW );
        figureCarre.setAntiAlias(true);
        figureCarre.setStyle(Paint.Style.FILL);
        figureCarre.setStrokeWidth(1);

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


    }

    public void onDraw( Canvas canvas )
    {
        // Création de la grille de jeu
        int largeurGrille = canvas.getWidth()-((canvas.getWidth()/10)*2); //80%
        int largeurCube = largeurGrille/10;

        for( int i = 0; i < 10; i++ )
        {
            for( int j = 0; j < 20; j++ )
            {
                canvas.drawRect((canvas.getWidth()/10) + largeurCube * i,
                                canvas.getHeight()/20 + (largeurCube * j),
                               (canvas.getWidth()/10) + largeurCube + (largeurCube * i),
                              canvas.getHeight()/20+ largeurCube + (largeurCube * j), this.grille);
            }
        }

        // Dessin de la bordure
        canvas.drawRect((canvas.getWidth()/10),
                     canvas.getHeight()/20,
                    (canvas.getWidth()/10) + largeurCube + (largeurCube * 9),
                  canvas.getHeight()/20+ largeurCube + (largeurCube * 19), this.bordure);

    }
}
