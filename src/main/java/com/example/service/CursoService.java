package com.example.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.model.Curso;
import com.example.repository.CursoRepository;


public class CursoService {
    private List<Curso> listaCursos;
    private Scanner scanner;
    private CursoRepository cursoRepo;
 
    public CursoService(){
        this.listaCursos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.cursoRepo = new CursoRepository();
    }
 
    public void adicionar() {
        System.out.println("\n--- Novo Curso ---");
        System.out.print("Digite o nome do curso: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a duração do curso: ");
        int duracao = scanner.nextInt();

        Curso novoCurso = new Curso(nome, duracao);
        if (cursoRepo.adicionar(novoCurso)) {
            System.out.println("Curso adicionado com sucesso!");     
        }else{
            System.out.println("Erro ao adicionar um novo curso");
        }
      
        //System.out.println("Adicionado com sucesso! ID: " + novoCurso.getId());
    }

    public void listar() {
        listaCursos = cursoRepo.listarTodos();
        if(listaCursos.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }
        
        System.out.println("\n=== Lista de Cursos ===");
        for(Curso c : listaCursos) {
            System.out.println(c);
        }
        System.out.println("Total: " + listaCursos.size() + " cursos");
    }

    public void remover() {
        listar();
        if(listaCursos.isEmpty()) return;
        
        System.out.print("Digite o ID do curso para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if(cursoRepo.excluir(id)){
            System.out.println("Curso deletado com sucesso!");
        } else {
            System.out.println("Curso não encontrado!");
        }

        /*
        if(cursoRepo.excluir(cursoRepo.listarPorId(id))){
            System.out.println("Curso deletado com sucesso!");
        } else {
            System.out.println("Curso não encontrado!");
        }
        */
    }

    public void atualizar() {
        listar();
        if(listaCursos.isEmpty()) return;
        
        System.out.print("Digite o ID do curso para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Curso cursoSelecionado = cursoRepo.listarPorId(id);
        /*for (Curso c : listaCursos){
            if(c.getId() == id) {
                cursoSelecionado = c;
                break;
            }
        }*/

        if(cursoSelecionado == null) {
            System.out.println("Curso não encontrado!");
            return;
        }
        
        System.out.println("\nAtualizando curso: " + cursoSelecionado.getNome());
        
        System.out.print("Novo nome (Enter para manter): ");
        String nome = scanner.nextLine();
        if(!nome.isEmpty()) {
            cursoSelecionado.setNome(nome);
        }
        
        System.out.print("Nova duração (0 para manter): ");
        int duracao = scanner.nextInt();
        if(duracao > 0) {
            cursoSelecionado.setDuracao(duracao);
        }

        scanner.nextLine();

        if (cursoRepo.atualizar(cursoSelecionado)){
            System.out.println("Curso atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar curso!");
        }       
        
    }

    
    public void buscar() {
        //listaCursos = cursoRepo.listarTodos();
        
        System.out.print("\nDigite o nome para buscar: ");
        String nome = scanner.nextLine().toLowerCase();
        
        List<Curso> resultados = cursoRepo.listarPorNome(nome);
        
        if(resultados.isEmpty()) {
            System.out.println("Nenhum curso encontrado.");
        } else {
            System.out.println("\n--- Resultados da Busca ---");
            for(Curso c : resultados) {
                System.out.println(c);
            }
            System.out.println("Encontrados: " + resultados.size() + " cursos");
        }
    }
}
