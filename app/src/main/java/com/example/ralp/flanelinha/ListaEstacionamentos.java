//Tela de consulta aos estacionamentos disponíveis
//Obs: O SearchView atualmente está causando erro no aplicativo.

package com.example.ralp.flanelinha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class ListaEstacionamentos extends AppCompatActivity implements ListView.OnItemClickListener/*,
        SearchView.OnQueryTextListener*/ {

    ArrayList<Estacionamento> estacionamentos = new ArrayList<>();
    ListView listaEstacionamentos;
    ListaEstacionamentosAdapter adapter;
    //SearchView busca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estacionamentos);

        //TODO: Criar uma nova tabela no SQLite para os estacionamentos
        estacionamentos.add(new Estacionamento("Bangu", new LatLng(-22.880086, -43.467088)));
        estacionamentos.add(new Estacionamento("Barra", new LatLng(-23.000667, -43.394302)));
        estacionamentos.add(new Estacionamento("Centro", new LatLng(-22.904940, -43.177698)));
        estacionamentos.add(new Estacionamento("Copacabana", new LatLng(-22.966461, -43.179182)));
        estacionamentos.add(new Estacionamento("Ipanema", new LatLng(-22.985188, -43.207555)));
        estacionamentos.add(new Estacionamento("Irajá", new LatLng(-22.847962, -43.323348)));
        estacionamentos.add(new Estacionamento("Méier", new LatLng(-22.901758, -43.278079)));
        estacionamentos.add(new Estacionamento("Penha", new LatLng(-22.844621, -43.281230)));
        estacionamentos.add(new Estacionamento("Recreio", new LatLng(-23.021822, -43.451447)));
        estacionamentos.add(new Estacionamento("Tijuca", new LatLng(-22.926578, -43.235287)));

        adapter = new ListaEstacionamentosAdapter(this, estacionamentos);

        listaEstacionamentos = (ListView) findViewById(R.id.listaEstacionamentos);
        listaEstacionamentos.setAdapter(adapter);
        listaEstacionamentos.setOnItemClickListener(this);

        /*
        busca = (SearchView) findViewById(R.id.busca);
        busca.setQuery("Buscar por estacionamento", false);
        busca.clearFocus();
        busca.setOnQueryTextListener(this);
        */
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Mapa.destino = estacionamentos.get(position);
        Intent i = new Intent(this, Mapa.class);
        startActivity(i);
    }
    /*
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }
    */
}
