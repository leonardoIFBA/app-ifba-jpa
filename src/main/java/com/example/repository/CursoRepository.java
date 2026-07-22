package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.model.Curso;
import com.example.util.JpaUtil;

public class CursoRepository implements Crud<Curso>, AutoCloseable{

    // cria uma instância de EntityManager
    private EntityManager em;

    // cria o construtor para inicializar a conexao com o BD
    public CursoRepository(){
        em = JpaUtil.getEntityManager();
    }

    @Override
    public boolean adicionar(Curso curso) {
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean atualizar(Curso curso) {
        em.getTransaction().begin();
        em.merge(curso);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean excluir(Curso curso) {
        em.getTransaction().begin();
        em.remove(curso);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean excluir(int id) {
        em.getTransaction().begin();
        em.remove(listarPorId(id));
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<Curso> listarTodos() {
        TypedQuery<Curso> query = em.createQuery("SELECT c FROM Curso c ORDER BY c.nome", Curso.class);
        return query.getResultList();
    }

    @Override
    public Curso listarPorId(int id) {
        Curso curso = em.find(Curso.class, id);
        return curso;       
    }

    @Override
    public void close() throws Exception {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    public List<Curso> listarPorNome(String nomeBusca) {
        TypedQuery<Curso> query = em.createQuery("SELECT c FROM Curso c WHERE c.nome like :nome ORDER BY c.nome", Curso.class);
        // Atribui o valor ao parâmetro nomeado
        query.setParameter("nome", "%" + nomeBusca + "%");
        return query.getResultList();
    }


    
}
