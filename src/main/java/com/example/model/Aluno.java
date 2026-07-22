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
    //private Curso curso;

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



    /**** Metodos getters e Setters dos atributos (Encapsulamento) */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    /*public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }*/

    /**** Implementação concreta do métodoo herdado da classe Pessoa  */
    public double calcularBonus() {
        return 1000 * 1.10;
    }

    /**** permite visualiza as informações do objeto Aluno */
    public String toString() {
        return "id=" + id + ", nome=" + nome + ", email=" + email + ", idade=" + idade + ", cpf=" + cpf + ", curso=";// + curso.getNome() ;
    }

    
}
