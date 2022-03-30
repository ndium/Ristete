package com.example.ristete;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Score extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_responsive);
    }

    /*
    public void genereScore(View v)
    {
        SharedPreferences spPseudo = getApplicationContext().getSharedPreferences("parametre", Context.MODE_PRIVATE);
        String pseudo = spPseudo.getString("pseudo","");

        int scoreQuiVientDetreFait = 100;

        TextView txtViewScore = new TextView(this);
        ScrollView scrollView = findViewById(R.id.barScrollView);


    }*/

    public void retour(View v)
    {
        finish();
    }
}
