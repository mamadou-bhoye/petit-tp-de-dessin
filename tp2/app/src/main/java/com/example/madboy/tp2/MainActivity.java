package com.example.madboy.tp2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPalette(View v){
        Intent it = new Intent(this, PaletteActivity.class);
        startActivityForResult(it, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null){
            Dessin d = findViewById(R.id.dessin);
            d.setWidth(data.getFloatExtra(PaletteActivity.PALETTE_WITDH,5));
            d.setColor(data.getIntExtra(PaletteActivity.COLOR_NUMBER, 1));
        }

    }
}
/*
package com.example.mamadou.decomposition_binaire_parametree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ToggleButton> al =new ArrayList<>();
    //int n=8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       int n = getIntent().getIntExtra("NUMBER_OF_BITS", 8);
        LinearLayout ll=findViewById(R.id.linearLayout2);
        for(int i=0;i<n;i++){
            ToggleButton tb =new ToggleButton( this);
            tb.setText("0");
            tb.setTextOff("0");
            tb.setTextOn("1");
            tb.setWidth(100);
            tb.setMinimumWidth(60);
            ll.addView(tb);
            al.add(tb);
        }
        final EditText ed=findViewById(R.id.editText);
        ed.setOnEditorActionListener(new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                int n=Integer.parseInt(v.getText().toString());
                for (int i=al.size()-1;i>=0;i--){
                    al.get(i).setChecked(n%2!=0);
                    n=n/2;
                }
                return false;
            }
        });
        View.OnClickListener ocl =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n=0;
                int j=0;
                for (int i=al.size()-1;i>=0;i--){
                    if(al.get(i).isChecked())n=n+(1<<j);
                    j++;
                }
                ed.setText(Integer.toString(n));
            }
        };
        for (ToggleButton tb:al)tb.setOnClickListener(ocl);
    }
}
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
package com.example.mamadou.decomposition_binaire_parametree;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText ed =findViewById(R.id.editText2);
        final Context context=this;
        ed.setOnEditorActionListener(new EditText.OnEditorActionListener(){

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                int n = Integer.parseInt(v.getText().toString());
                Intent it =new Intent(context,MainActivity.class);
                it.putExtra("NUMBER_OF_BITS", n);
                startActivity(it);
                return false;
            }
        });
    }
}
*/