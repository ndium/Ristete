package com.example.ristete;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Score extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_responsive);
        genereScore(getCurrentFocus());
    }


    public void genereScore(View v)
    {
        //SharedPreferences spPseudo = getApplicationContext().getSharedPreferences("parametre", Context.MODE_PRIVATE);
        //String pseudo = spPseudo.getString("pseudo","");

        String[] tabJoueur = {"Juno","Hubble","Casini","WMAP","Spitzer","Pioneer","Columbia","Challenger","Apollo","Curiosity"};
        ListView lv = findViewById(R.id.listViewScore);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tabJoueur);
        lv.setAdapter(adapter);

        //int scoreQuiVientDetreFait = 100;

    }

    public void retour(View v)
    {
        finish();
    }
}
