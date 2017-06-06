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

    EditText nome, email, senha;
    Button enviar;
    UsuarioDB db = new UsuarioDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (EditText) findViewById(R.id.campoNome);
        email = (EditText) findViewById(R.id.campoEmail);
        senha = (EditText) findViewById(R.id.campoSenha);
        enviar = (Button) findViewById(R.id.botaoEnviar);

        enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        db.save(new Usuario(
                nome.getText().toString(),
                email.getText().toString(),
                senha.getText().toString()) );
        Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
