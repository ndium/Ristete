package com.example.ristete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class Tetris extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_tetris);
        MonTetris montetris = new MonTetris(getApplicationContext());
        setContentView(montetris);
    }
}


/**
 * création d'une classe pour faire le dessin
 */
class MonTetris extends View implements View.OnClickListener, View.OnTouchListener
{

    Paint styleRouge, styleBleu, styleNoir;
    Random alea;
    float xDoigt = 150, yDoigt = 400; // coord du doigt sur l'écran
    //Bitmap drone;
    //float largDrone = 100, hautDrone= 100;

    public MonTetris(Context c) {
        super(c);
        init();
    }

    /**
     * c'est dans cette méthode que le dessin va être effectué
     * @param canvas
     */
    @Override
    public void onDraw(Canvas canvas) {
        //canvas.drawColor(Color.rgb(167,89,156));
        canvas.drawColor(Color.LTGRAY);
        //canvas.drawRect(100,100,200,600,styleRouge);
        //canvas.drawRect(200,200,300,700,styleRouge);

        //Lig et col sont inversés je crois
        for(int lig = 80; lig < 800; lig+=80)
            for(int col = 160; col < 1281; col+=80)
                canvas.drawRect(80+lig,80+col,160+lig,160+col, styleNoir);


        canvas.drawCircle(xDoigt,yDoigt,20,styleBleu);
        //canvas.drawBitmap(drone,xDoigt-largDrone/2,yDoigt-hautDrone/2,null);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        xDoigt = event.getX();
        yDoigt = event.getY();
        // je veux que mon dessin soit redessiné
        // l'instruction invalidate() appelle indirectement la méthode onDraw()
        this.invalidate();
        // return:
        // si false l'event est passé à une autre méthode
        // si true l'event est détruit (ici la méthode onClick ne
        //         sera pas exécutée
        return false;
    }

    @Override
    public void onClick(View v) {
        styleBleu.setColor(Color.rgb(100+alea.nextInt(150),100+alea.nextInt(150),100+alea.nextInt(150)));
        this.invalidate();
    }

    private void initListener() {
        this.setOnTouchListener(this);
        this.setOnClickListener(this);
    }

    private void init() {
        initStyle();
        initListener();
        alea = new Random(System.currentTimeMillis());
        //drone = BitmapFactory.decodeResource(getResources(),R.drawable.drone);
        //largDrone = drone.getWidth();
        //hautDrone = drone.getHeight();
    }

    private void initStyle() {
        styleRouge = new Paint();
        styleRouge.setColor(Color.RED);
        styleRouge.setStyle(Paint.Style.FILL);
        styleRouge.setAntiAlias(true);

        styleNoir = new Paint();
        styleNoir.setColor(Color.BLACK);
        styleNoir.setStyle(Paint.Style.STROKE);
        styleNoir.setStrokeWidth(10);

        styleBleu = new Paint();
        styleBleu.setColor(Color.BLUE);
        styleBleu.setStyle(Paint.Style.STROKE);
        styleBleu.setStrokeWidth(5);
    }

}