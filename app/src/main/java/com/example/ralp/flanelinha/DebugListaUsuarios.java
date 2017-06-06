package com.example.ralp.flanelinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DebugListaUsuarios extends AppCompatActivity {

    private ListView listView;
    private List<Usuario> usuarios;
    UsuarioDB db = new UsuarioDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug_lista_usuarios);

        listView = (ListView) findViewById(R.id.listaUsuarios);
        usuarios = db.getAll();

        DebugListaUsuariosAdapter usuarioAdapter = new DebugListaUsuariosAdapter(this, usuarios);
        listView.setAdapter(usuarioAdapter);
    }
}
