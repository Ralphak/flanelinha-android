package com.example.ralp.flanelinha;

/**
 * Created by ralph on 05/06/2017.
 */

public class Usuario {

    private String nome, email, senha;
    public Usuario(String email, String nome, String senha){
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }
    public Usuario(String email, String nome){
        this.email = email;
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
