package com.example.ristete;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DessinRistete extends AppCompatActivity
{
    private ZoneDessin zd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.zd = new ZoneDessin( this );
        setContentView( this.zd );
    }
}
