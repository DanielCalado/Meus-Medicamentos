package com.example.myapplication.model.entidades;

public class Usuario {
    public String email;
    public String nome;
    public String senha;
    public String celular;
    public int idade;

    public  Usuario(String nome, String email, String senha, String celular, int idade){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
        this.idade = idade;
    }
    public Usuario(){

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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}