package com.example.ralp.flanelinha;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DebugListaUsuariosAdapter extends BaseAdapter {

    private List<Usuario> usuarios;
    private Context context;

    public DebugListaUsuariosAdapter(Context context, List<Usuario> usuarios){
        this.context = context;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_debug_lista_usuarios, parent, false);

        TextView txtNome = (TextView) view.findViewById(R.id.txtNome);
        TextView txtEmail = (TextView) view.findViewById(R.id.txtEmail);

        txtNome.setText(usuarios.get(position).getNome());
        txtEmail.setText(usuarios.get(position).getEmail());

        return view;
    }
}
