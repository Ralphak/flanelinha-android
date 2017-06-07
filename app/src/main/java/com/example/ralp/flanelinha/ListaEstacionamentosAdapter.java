package com.example.ralp.flanelinha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ralph on 07/06/2017.
 */

public class ListaEstacionamentosAdapter extends BaseAdapter{
    private ArrayList<Estacionamento> estacionamentos;
    private Context context;

    public ListaEstacionamentosAdapter(Context context, ArrayList<Estacionamento> estacionamentos) {
        this.context = context;
        this.estacionamentos = estacionamentos;
    }

    @Override
    public int getCount() {
        return estacionamentos.size();
    }

    @Override
    public Object getItem(int position) {
        return estacionamentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_lista_estacionamentos, parent, false);

        TextView txtLocal = (TextView) view.findViewById(R.id.txtLocal);
        TextView txtVagas = (TextView) view.findViewById(R.id.txtVagas);

        txtLocal.setText(estacionamentos.get(position).getLocal());
        txtVagas.setText("Vagas: " + String.valueOf(new Random().nextInt(51)));

        return view;
    }

}
