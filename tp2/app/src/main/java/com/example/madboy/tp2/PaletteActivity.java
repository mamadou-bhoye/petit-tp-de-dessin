package com.example.madboy.tp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PaletteActivity extends AppCompatActivity {

    public static final String PALETTE_WITDH = "Palette width";
    public static final String COLOR_NUMBER="COLOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
    }

    public void okButton(View v){
        float width = 5;
        int couleur=1;
        try{
            EditText ed = findViewById(R.id.editText);
            EditText col= findViewById(R.id.editText2);
            width = Float.parseFloat(ed.getText().toString());
            couleur = Integer.parseInt((col.getText().toString()));
        }catch (NumberFormatException e){};
        Intent it = new Intent();
        it.putExtra(PALETTE_WITDH,width);
        it.putExtra(COLOR_NUMBER,couleur);
        setResult(Activity.RESULT_OK,it);
        finish();
    }
}

