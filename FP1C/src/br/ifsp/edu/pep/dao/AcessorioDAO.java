/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsp.edu.pep.dao;

import br.edu.ifsp.pep.modelo.Acessorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author aluno
 */
public class AcessorioDAO {
    private EntityManagerFactory emf;
    
    public AcessorioDAO()
    {
        emf = Persistence.createEntityManagerFactory("aula1PU");
    }
    
    private EntityManager getEntityManager()
    {
        return this.emf.createEntityManager();
    }
    
    public void inserir(Acessorio acessorio)
    {
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(acessorio);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void alterar(Acessorio acessorio)
    {
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.merge(acessorio);
        em.getTransaction().commit();
        
        em.close();
    }
    
     public List<Acessorio> buscar()
    {
        TypedQuery<Acessorio> query = getEntityManager()
               .createQuery("SELECT p FROM Acessorio p", Acessorio.class);
        
        return query.getResultList();
    }
     
     public Acessorio retornarAcessorio(int codigo)
    {
        TypedQuery<Acessorio> query = getEntityManager()
               .createQuery("SELECT a FROM Acessorio a WHERE a.codigo = " + codigo, Acessorio.class);
        
        List<Acessorio> resultado = query.getResultList();
        return resultado.get(0);
    }
}
