package com.example.ristete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_responsive);
    }

    public void tetris(View v)
    {
        Intent intentTetris = new Intent(this,Tetris.class);
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

}