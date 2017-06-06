package com.example.ralp.flanelinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.ralp.flanelinha.TelaPrincipal.getLoginEmail;

public class AlterarSenha extends AppCompatActivity implements Button.OnClickListener{

    EditText senhaAtualEdit, novaSenhaEdit, repetirEdit;
    Button enviar;
    UsuarioDB db = new UsuarioDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_senha);

        senhaAtualEdit = (EditText) findViewById(R.id.campoSenhaAtual);
        novaSenhaEdit = (EditText) findViewById(R.id.campoNovaSenha);
        repetirEdit = (EditText) findViewById(R.id.campoRepetir);
        enviar = (Button) findViewById(R.id.botaoEnviar2);

        enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String
                senhaAtual = senhaAtualEdit.getText().toString(),
                novaSenha = novaSenhaEdit.getText().toString(),
                repetir = repetirEdit.getText().toString();

        if(senhaAtual.matches("") || novaSenha.matches("") || repetir.matches("")) {
            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
            return;
        }

        Usuario usuario = db.get(getLoginEmail());

        if(senhaAtual.matches(usuario.getSenha()) && repetir.matches(novaSenha)){
            usuario.setSenha(novaSenha);
            db.updatePassword(usuario);
            Toast.makeText(this, "Sua senha foi alterada!", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(this, "Dados incorretos", Toast.LENGTH_SHORT).show();
        }
    }
}
