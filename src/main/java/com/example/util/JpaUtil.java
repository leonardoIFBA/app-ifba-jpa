package com.example.util;

import javax.persistence.*;

public class JpaUtil {
    // criar uma fabrica de EntityManagers
    private static EntityManagerFactory factory;

    static{
        //retorna a fabrica de EntityManager de acordo o arquivo de conexao
        factory = Persistence.createEntityManagerFactory("IFBA-PU");
    }

    //retorna um EntityManager para persistir objetos
    public static EntityManager getEntityManager(){
        System.out.println("Conexao efetuada com sucesso");
        return factory.createEntityManager();
    }

    //fechar a fabrica de EntityManagers
    public static void close(){
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}