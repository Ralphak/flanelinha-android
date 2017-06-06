package com.example.ralp.flanelinha;

/**
 * Created by ralph on 05/06/2017.
 */

public class Usuario {

    private String nome, email, senha;
    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    public Usuario(){

    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
