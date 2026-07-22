package com.example.repository;

import java.util.List;

public interface Crud<T> {
    List<T> listarTodos();
    boolean adicionar(T objeto);
    boolean atualizar(T objeto);
    boolean excluir(T objeto); 
    boolean excluir(int id); 
    T listarPorId(int id);
    
}
