package com.example.model;

import javax.persistence.*;

/*** As classe do model representam a estrutura de dados (entidades/tabelas) e a lógica de negócios da aplicação.  
   * Ela herda as caracteristicas da classe Pessoa */
@Entity
@Table(name = "TB_ALUNO")
public class Aluno{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private int idade;
    private String cpf;
    
    /*** Construtor vazio e com parametros, auxiliam na criação dos objetos alunos */
    public Aluno(){}

    public Aluno(int idade, String cpf, Curso curso) {
              this.idade = idade;
        this.cpf = cpf;
        //this.curso = curso;
    }

    public Aluno(int id, String nome, String email, int idade, String cpf, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.cpf = cpf;
        //this.curso = curso;
    }

    /**** Implementação concreta do métodoo herdado da classe Pessoa  */
    public double calcularBonus() {
        return 1000 * 1.10;
    }
    
}
