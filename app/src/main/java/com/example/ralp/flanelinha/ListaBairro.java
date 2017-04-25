package com.example.ralp.flanelinha;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaBairro extends AppCompatActivity implements ListView.OnItemClickListener{

    List<String> bairros = new ArrayList<String>();
    ListView listaBairros;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bairro);

        bairros.add("Tijuca");
        bairros.add("Centro");
        bairros.add("Barra");
        bairros.add("Ipanema");

        listaBairros = (ListView) findViewById(R.id.listaBairro);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bairros);

        listaBairros.setAdapter(adapter);
        listaBairros.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListaEstacionamentos.bairroEscolhido = adapter.getItem(position);
        Intent i = new Intent(this, ListaEstacionamentos.class);
        startActivity(i);
    }
}
