package br.edu.ifsp.pep;

import br.edu.ifsp.pep.model.FuncionarioAssalariado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Principal {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProvaPU");
    
    public static void main(String[] args) {
        
    }
    
    public static void cadastrarFuncioanrioAssalariado(){
        EntityManager em = emf.createEntityManager();
        
        FuncionarioAssalariado fa = new FuncionarioAssalariado();
        fa.setNome("guilherme");
        fa.setSalario(1200.00);
        fa.setLogin("funcassalariado");
        fa.setSenha("123");
        
        em.getTransaction().begin();
        
        em.persist(fa);
        em.getTransaction().commit();
        em.close();
        
    }
}
