package com.example.ristete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Accueil extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_responsive);
    }

    public void jouer(View v)
    {
        Intent intentTetris = new Intent(this,DessinRistete.class);
        startActivity(intentTetris);
    }

    public void parametre(View v)
    {
        Intent intentTetris = new Intent(this,Parametre.class);
        startActivity(intentTetris);
    }

    public void score(View v)
    {
        Intent intentTetris = new Intent(this,Score.class);
        startActivity(intentTetris);
    }

    public void quitter(View v)
    {
        finish();
    }

}