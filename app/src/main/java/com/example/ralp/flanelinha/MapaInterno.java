package com.example.ralp.flanelinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MapaInterno extends AppCompatActivity {

    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_interno);

        titulo = (TextView) findViewById(R.id.tx_titulo);
        titulo.setText(Mapa.localEscolhido);
    }
}
