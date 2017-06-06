package com.example.ralp.flanelinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements Button.OnClickListener{

    EditText email, senha;
    Button entrar;
    UsuarioDB db = new UsuarioDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.campoEmail);
        senha = (EditText) findViewById(R.id.campoSenha);
        entrar = (Button) findViewById(R.id.botaoEnviar);

        entrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Usuario usuario = db.get(email.getText().toString());
        if(usuario == null || senha.getText().toString() != usuario.getSenha()){
            Toast.makeText(this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show();
        }
        else {
            String primeiroNome = usuario.getNome().substring(0, usuario.getNome().indexOf(" "));
            Toast.makeText(this, "Bem vindo, " + primeiroNome + "!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
