package com.example.ralp.flanelinha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDB extends SQLiteOpenHelper{

    private static final String TAG = "sql";
    public static final  String NOME_BANCO = "lista_usuarios.sqlite";
    private static final int VERSAO_BANCO = 1;

    public UsuarioDB(Context context) {

        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Criando tabela usuario..");
        db.execSQL("create table if not exists usuario (email text primary key, nome text, senha text)");
        Log.d(TAG, "Tabela criada com sucesso");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Caso exista uma nova versÃ£o do BD
    }

    public void save(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put("email", usuario.getEmail());
            values.put("nome", usuario.getNome());
            values.put("senha", usuario.getSenha());

            db.insert("usuario", "", values);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }
    }

    public String update(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("email", usuario.getEmail());
            values.put("nome", usuario.getNome());
            values.put("senha", usuario.getSenha());
            db.update("usuario", values, "email="+usuario.getEmail(),null);
            //db.update("aluno", values, "matricula=?",new String[]{aluno.getMatricula()});
        }
        finally {
            db.close();
        }
        return usuario.getEmail();
    }

    public Usuario validarLogin(String _email, String _senha){
        SQLiteDatabase db = getReadableDatabase();
        Usuario usuario = new Usuario();
        try{
            Cursor c = db.rawQuery("select email from usuario where email = "+_email+" and senha = "+_senha+" ", null);
            if (c.moveToFirst()){
                String nome = c.getString(c.getColumnIndex("nome"));
                String email = c.getString(c.getColumnIndex("email"));
                usuario.setNome(nome);
                usuario.setEmail(email);
            }
            return usuario;
        }
        finally {
            db.close();
        }
    }

    /*
    public ArrayList<Usuario> listarAlunos(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Aluno> alunos = null;
        try {
            //Cursor c = db.query("aluno", null, null, null, null, null, null);
            //rawQuery("SELECT id, name FROM people WHERE name = ? AND id = ?", new String[] {"David", "2"});
            Cursor c = db.rawQuery("select * from aluno", null);
            if(c.moveToFirst()){
                alunos = new ArrayList<Aluno>();
                do {
                    String matricula = c.getString(c.getColumnIndex("matricula"));
                    String nome = c.getString(c.getColumnIndex("nome"));
                    String email = c.getString(c.getColumnIndex("email"));
                    Aluno aluno = new Aluno(matricula, nome, email);
                    alunos.add(aluno);

                }while(c.moveToNext());
            }
        }
        finally {
            db.close();
        }
        return alunos;
    }

    public int delete(Aluno aluno){
        SQLiteDatabase db = getWritableDatabase();
        try{
            int count = db.delete("aluno", "matricula="+aluno.getMatricula(), null);
            return count;
        }
        finally {
            db.close();
        }
    }
    */
}

