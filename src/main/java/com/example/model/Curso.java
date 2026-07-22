package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*** As classe do model representam a estrutura de dados (entidades/tabelas) e a lógica de negócios da aplicação. */
@Entity
@Table(name = "TB_CURSO")
public class Curso {

    /**** Atributos do objeto Aluno */  
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int duracao;

    /*** Construtor vazio e com parametros, auxiliam na criação dos objetos cursos */
    public Curso(){}

    public Curso(int id, String nome, int duracao){
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
    }

    public Curso(String nome, int duracao){
        this.nome = nome;
        this.duracao = duracao;
    }

    /**** Metodos getters e Setters dos atributos (Encapsulamento) */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**** permite visualiza as informações do objeto Curso */
    @Override
    public String toString() {
        return "Curso [id=" + id + ", nome=" + nome + ", duracao=" + duracao + "]";
    }   

    
}
