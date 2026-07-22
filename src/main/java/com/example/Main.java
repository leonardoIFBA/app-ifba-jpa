package com.example;

import java.sql.SQLException;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.example.service.CursoService;
import com.example.util.JpaUtil;

public class Main {
    private static Scanner scanner = new Scanner(System.in);    
    CursoService cursoService = new CursoService();
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //EntityManager em = JpaUtil.getEntityManager();
        try {
            new Main().executar();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void mostrarMenuCurso() {
        System.out.println("\n=== SISTEMA CRUD : CURSO ===");
        System.out.println("1 - Adicionar");
        System.out.println("2 - Listar todos");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Remover");
        System.out.println("5 - Buscar");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");
    }

    private void mostrarMenuAluno() {
        System.out.println("\n=== SISTEMA CRUD : ALUNO ===");
        System.out.println("1 - Adicionar novo aluno");
        System.out.println("2 - Listar todos alunos");
        System.out.println("3 - Atualizar aluno");
        System.out.println("4 - Remover aluno");
        System.out.println("5 - Buscar aluno");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");
    }

    private void mostrarMenuProfessor() {
        System.out.println("\n=== SISTEMA CRUD : PROFESSOR ===");
        System.out.println("1 - Adicionar novo professor");
        System.out.println("2 - Listar todos professores");
        System.out.println("3 - Atualizar professor");
        System.out.println("4 - Remover professor");
        System.out.println("5 - Buscar professor");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");
    }

    public void executar() throws SQLException {
        int menuPrincipal, submenu;
        do {
            System.out.println("\n=== Bem vindo ao Aula1 ===");
            System.out.println("1 - Gerenciar Curso");
            System.out.println("2 - Gerenciar Aluno");
            System.out.println("3 - Gerenciar Professor");
            System.out.println("0 - Sair");
            System.out.println("Escolha a opção: ");
            menuPrincipal = scanner.nextInt();
            
            switch (menuPrincipal) {
                case 0: System.out.println("Aplicação encerrada."); break;
                
                case 1: 
                    do{
                        mostrarMenuCurso();
                        submenu = scanner.nextInt();
                        scanner.nextLine(); // Limpar buffer
                        
                        switch(submenu) {
                            case 1: cursoService.adicionar(); break;
                            case 2: cursoService.listar(); break;
                            case 3: cursoService.atualizar(); break;
                            case 4: cursoService.remover(); break;
                            case 5: cursoService.buscar(); break;
                            case 0: System.out.println("Voltar"); break;
                            default: System.out.println("Opção inválida!"); break;
                        }                    
                    }while (submenu != 0);
                break;                        
                    
                case 2: 
                    do{
                        mostrarMenuAluno();
                        submenu = scanner.nextInt();
                        scanner.nextLine(); // Limpar buffer
                        
                        /*switch(submenu) {
                            case 1: alunoService.adicionar(); break;
                            case 2: alunoService.listar(); break;
                            case 3: alunoService.atualizar(); break;
                            case 4: alunoService.remover(); break;
                            case 5: alunoService.buscar(); break;
                            case 0: System.out.println("Voltar"); break;
                            default: System.out.println("Opção inválida!"); break;
                        }  */                  
                    }while (submenu != 0);
                break;

                case 3: 
                    do{
                        mostrarMenuProfessor();
                        submenu = scanner.nextInt();
                        scanner.nextLine(); // Limpar buffer
                        
                        /*switch(submenu) {
                            case 1: professorService.adicionar(); break;
                            case 2: professorService.listar(); break;
                            case 3: professorService.atualizar(); break;
                            case 4: professorService.remover(); break;
                            case 5: professorService.buscar(); break;
                            case 0: System.out.println("Voltar"); break;
                            default: System.out.println("Opção inválida!"); break;
                        }*/                    
                    }while (submenu != 0);
                break;

                default: System.out.println("Opção inválida!"); break;                  
            }            
        } while(menuPrincipal != 0);
        
        scanner.close();
    }

}