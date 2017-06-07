//Tela de cadastro de novo usuário

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

    EditText emailEdit, nomeEdit, senhaEdit;
    Button enviar;
    UsuarioDB db = new UsuarioDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        emailEdit = (EditText) findViewById(R.id.campoEmail);
        nomeEdit = (EditText) findViewById(R.id.campoNome);
        senhaEdit = (EditText) findViewById(R.id.campoSenha);
        enviar = (Button) findViewById(R.id.botaoEnviar);

        enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String
                email = emailEdit.getText().toString(),
                nome = nomeEdit.getText().toString(),
                senha = senhaEdit.getText().toString();

        if(email.matches("") || nome.matches("") || senha.matches(""))
            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        else {
            db.add(new Usuario(email, nome, senha));
            Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
