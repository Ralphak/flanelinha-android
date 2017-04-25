package com.example.ralp.flanelinha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListaEstacionamentos extends AppCompatActivity implements ListView.OnItemClickListener{

    static String bairroEscolhido;
    TextView bairro;
    List<String> estacionamentos = new ArrayList<String>();
    ListView listaEstacionamentos;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estacionamentos);

        bairro = (TextView) findViewById(R.id.tx_bairro);
        bairro.setText("em "+bairroEscolhido);

        for(int i = 1; i <= 5; i++)
            estacionamentos.add(bairroEscolhido+" "+i);

        listaEstacionamentos = (ListView) findViewById(R.id.listaEstacionamentos);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, estacionamentos);

        listaEstacionamentos.setAdapter(adapter);
        listaEstacionamentos.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Mapa.localEscolhido = adapter.getItem(position);
        Intent i = new Intent(this, Mapa.class);
        startActivity(i);
    }
}
