//Tela principal do aplicativo, onde serão executadas as principais funções.

package com.example.ralp.flanelinha;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    View header;
    static TextView headerNome, headerEmail;
    static private boolean usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        header = navigationView.getHeaderView(0);
        headerNome = (TextView) header.findViewById(R.id.headerNome);
        headerEmail = (TextView) header.findViewById(R.id.headerEmail);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent i = null;

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_cadastrar){
            if(usuarioLogado)
                Toast.makeText(this, "Usuário já logado!", Toast.LENGTH_SHORT).show();
            else
                i = new Intent(this, Cadastro.class);
        }
        else if(id == R.id.nav_login){
            if(usuarioLogado)
                Toast.makeText(this, "Usuário já logado!", Toast.LENGTH_SHORT).show();
            else
                i = new Intent(this, Login.class);
        }
        else if(id == R.id.nav_alterarSenha){
            if(!usuarioLogado)
                Toast.makeText(this, "Nenhum login detectado!", Toast.LENGTH_SHORT).show();
            else
                i = new Intent(this, AlterarSenha.class);
        }
        else if(id == R.id.nav_sair){
            if(!usuarioLogado)
                Toast.makeText(this, "Nenhum login detectado!", Toast.LENGTH_SHORT).show();
            else {
                Toast.makeText(this, "Desconectado", Toast.LENGTH_SHORT).show();
                atualizarLogin();
            }
        }
        else if(id == R.id.nav_debugListar){
            i = new Intent(this, DebugListaUsuarios.class);
        }
        else if(id == R.id.nav_debugMapa){
            i = new Intent(this, Mapa.class);
        }

        if(i != null)
            startActivity(i);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Atualiza informações para o usuário logado
    static void atualizarLogin(String nome, String email){
        headerNome.setText(nome);
        headerEmail.setText(email);
        usuarioLogado = true;
    }
    //Desconecta o usuário e volta para o visitante
    static void atualizarLogin(){
        headerNome.setText("Visitante");
        headerEmail.setText("");
        usuarioLogado = false;
    }
    //Retorna o email do usuário logado (usado para alterar sua senha)
    static String getLoginEmail(){
        return headerEmail.getText().toString();
    }
}
