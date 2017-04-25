package com.example.ralp.flanelinha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText ed_login;
    private EditText ed_senha;
    private Button bt_entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_login = (EditText)findViewById(R.id.ed_login);
        ed_senha = (EditText)findViewById(R.id.ed_senha);
        bt_entrar = (Button)findViewById(R.id.bt_entrar);

        bt_entrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String login = ed_login.getText().toString();
        String senha = ed_senha.getText().toString();

        if(login.equals("usuario@m.com") && senha.equals("teste")){
            Toast.makeText(this, "Logado", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, ListaBairro.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Dados incorretos", Toast.LENGTH_LONG).show();
        }
    }
}
