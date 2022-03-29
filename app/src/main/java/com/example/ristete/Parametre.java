package com.example.ristete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class Parametre extends AppCompatActivity implements TextWatcher, RadioGroup.OnCheckedChangeListener {

    EditText editText;
    SharedPreferences spPseudo, spRadioB;
    RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre_responsive);

        editText = findViewById(R.id.txtPseudo);
        editText.addTextChangedListener(this);
        editText.setTextColor(Color.parseColor("#BBBBBB"));

        rg = findViewById(R.id.radioGroup_character);
        rg.setOnCheckedChangeListener(this);

        spPseudo = getSharedPreferences("parametre", Context.MODE_PRIVATE);
        spRadioB = getSharedPreferences("boutonradio", Context.MODE_PRIVATE);
    }

    public void accueil(View v)
    {
        //Intent intentTetris = new Intent(this,Accueil.class);
        //startActivity(intentTetris);
        finish();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        editText = findViewById(R.id.txtPseudo);
        RadioButton rbTactile = findViewById(R.id.radioButton_tactile);
        RadioButton rbDetecteur = findViewById(R.id.radioButton_detecteur);

        SharedPreferences spBoutonRadio = getApplicationContext().getSharedPreferences("boutonradio", Context.MODE_PRIVATE);
        String mode = spBoutonRadio.getString("boutonRadio","");

        if (mode.equals("boutonTactile"))
        {
            rbTactile.setChecked(true);
        }
        else if (mode.equals("boutonDetecteur"))
        {
            rbDetecteur.setChecked(true);
        }

        SharedPreferences sp = getApplicationContext().getSharedPreferences("parametre", Context.MODE_PRIVATE);
        String pseudo = sp.getString("pseudo","");

        editText.setText(pseudo);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

    @Override
    public void afterTextChanged(Editable editable)
    {
        editText = findViewById(R.id.txtPseudo);
        String pseudo = editText.getText().toString();

        SharedPreferences.Editor editor = spPseudo.edit();
        editor.putString("pseudo", pseudo);
        editor.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i)
    {
        try
        {
            SharedPreferences.Editor editor = spRadioB.edit();
            RadioButton radioBoutonTactile = findViewById(R.id.radioButton_tactile);
            RadioButton radioButtonDetecteur = findViewById(R.id.radioButton_detecteur);
            if (radioBoutonTactile.createAccessibilityNodeInfo().isChecked())
            {
                editor.remove("boutonRadio");
                editor.putString("boutonRadio","boutonTactile");
            }
            else if (radioButtonDetecteur.createAccessibilityNodeInfo().isChecked())
            {
                editor.remove("boutonRadio");
                editor.putString("boutonRadio", "boutonDetecteur");
            }
            editor.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
