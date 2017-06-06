package com.example.ralp.flanelinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.ralp.flanelinha.TelaPrincipal.atualizarLogin;

public class Login extends AppCompatActivity implements Button.OnClickListener{

    EditText emailEdit, senhaEdit;
    Button entrar;
    UsuarioDB db = new UsuarioDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEdit = (EditText) findViewById(R.id.campoEmail);
        senhaEdit = (EditText) findViewById(R.id.campoSenha);
        entrar = (Button) findViewById(R.id.botaoEnviar);

        entrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String
                email = emailEdit.getText().toString(),
                senha = senhaEdit.getText().toString();

        if(email.matches("") || senha.matches("")) {
            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
            return;
        }

        Usuario usuario = db.get(email);
        if(senha.matches(usuario.getSenha())){
            String primeiroNome = usuario.getNome().substring(0, usuario.getNome().indexOf(" "));
            Toast.makeText(this, "Bem vindo, " + primeiroNome + "!", Toast.LENGTH_SHORT).show();

            atualizarLogin(usuario.getNome(), email);

            finish();
        }
        else
            Toast.makeText(this, "Email ou senha inválida!", Toast.LENGTH_SHORT).show();
    }
}
