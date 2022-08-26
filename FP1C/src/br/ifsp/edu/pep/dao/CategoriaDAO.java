package br.ifsp.edu.pep.dao;

import br.edu.ifsp.pep.modelo.Categoria;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class CategoriaDAO extends AbstractDAO<Categoria>{
    private EntityManagerFactory emf;
    
    public List<Categoria> buscar()
    {
        TypedQuery<Categoria> query = getEntityManager()
               .createQuery("SELECT p FROM Categoria p", Categoria.class);
        
        return query.getResultList();
    }
}
