package com.example.ristete;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.example.ristete.metier.Ristete;

public class ZoneDessin extends View
{
    Paint dessinFigure = new Paint();
    Paint bordure = new Paint();


    public ZoneDessin(Context context, Ristete ristete)
    {
        super( context );
        setFocusable( true );
        //ristete.getFigureCourante().getColor()
        dessinFigure.setColor( Color.DKGRAY );
        dessinFigure.setAntiAlias(true);
        dessinFigure.setStyle(Paint.Style.STROKE);
        dessinFigure.setStrokeWidth(3);

        bordure.setColor( Color.WHITE );
        bordure.setAntiAlias(true);
        bordure.setStyle(Paint.Style.STROKE);
        bordure.setStrokeWidth(5);


    }

    public void onDraw( Canvas canvas )
    {
        int largeurGrille = canvas.getWidth()-((canvas.getWidth()/10)*2); //80%
        int largeurCube = largeurGrille/10;



        for( int i = 0; i < 10; i++ )
        {
            for( int j = 0; j < 20; j++ )
            {
                canvas.drawRect((canvas.getWidth()/10) + largeurCube * i,
                        canvas.getHeight()/20 + (largeurCube * j),
                        (canvas.getWidth()/10) + largeurCube + (largeurCube * i),
                        canvas.getHeight()/20+ largeurCube + (largeurCube * j), dessinFigure);
            }
        }

        canvas.drawRect((canvas.getWidth()/10),
                canvas.getHeight()/20,
                (canvas.getWidth()/10) + largeurCube + (largeurCube * 9),
                canvas.getHeight()/20+ largeurCube + (largeurCube * 19), bordure);
    }
}
