package com.example.ralp.flanelinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mapa extends AppCompatActivity implements View.OnClickListener{

    static String localEscolhido;
    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        titulo = (TextView) findViewById(R.id.tx_titulo);
        titulo.setText(localEscolhido);
    }

    @Override
    public void onClick(View v) {

    }
}
