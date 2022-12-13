package com.example.myapplication.model;

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
}