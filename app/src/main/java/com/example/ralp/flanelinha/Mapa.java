package com.example.ralp.flanelinha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Mapa extends AppCompatActivity implements View.OnClickListener{

    static String localEscolhido;
    TextView titulo;
    Button bt_mapainterno;
    Button bt_reservar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        titulo = (TextView) findViewById(R.id.tx_titulo);
        titulo.setText(localEscolhido);

        bt_mapainterno = (Button) findViewById(R.id.bt_mapainterno);
        bt_mapainterno.setOnClickListener(this);
        bt_reservar = (Button) findViewById(R.id.bt_reservar);
        bt_reservar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case(R.id.bt_mapainterno):
                Intent i = new Intent(this, MapaInterno.class);
                startActivity(i);
                break;
            case(R.id.bt_reservar):
                Toast.makeText(this, "Função ainda não implementada.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
