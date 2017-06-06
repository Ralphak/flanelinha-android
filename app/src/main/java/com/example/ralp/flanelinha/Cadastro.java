package com.example.ralp.flanelinha;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity implements Button.OnClickListener {

    EditText email, nome, senha;
    Button enviar;
    UsuarioDB db = new UsuarioDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        email = (EditText) findViewById(R.id.campoEmail);
        nome = (EditText) findViewById(R.id.campoNome);
        senha = (EditText) findViewById(R.id.campoSenha);
        enviar = (Button) findViewById(R.id.botaoEnviar);

        enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        db.add(new Usuario(
                email.getText().toString(),
                nome.getText().toString(),
                senha.getText().toString()) );
        Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
