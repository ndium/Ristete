package com.example.ristete;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ristete.metier.Ristete;

public class DessinRistete extends AppCompatActivity
{
    private ZoneDessin zd;
    private Ristete    ristete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.ristete = new Ristete();
        this.zd = new ZoneDessin( this, this.ristete );
        setContentView( this.zd );

    }


}
