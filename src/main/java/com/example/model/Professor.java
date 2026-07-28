package com.example.model;

import javax.persistence.*;

/*** As classe do model representam a estrutura de dados (entidades/tabelas) e a lógica de negócios da aplicação.  
   * Ela herda as caracteristicas da classe Pessoa */
@Entity
@Table(name = "TB_PROFESSOR")
public class Professor{
    /**** Atributos do objeto Professor */ 
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String siape;

    /*** Construtor vazio e com parametros, auxiliam na criação dos objetos professores */
    public Professor(){}

    public Professor(int id, String nome, String email, String siape){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.siape = siape;

    }

    public double calcularBonus() {
        return 2000 * 1.10;
    }
}
