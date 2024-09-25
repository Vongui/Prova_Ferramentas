package br.edu.ifsp.pep;

import br.edu.ifsp.pep.model.Funcionario;
import br.edu.ifsp.pep.model.FuncionarioAssalariado;
import br.edu.ifsp.pep.model.FuncionarioComissionado;
import br.edu.ifsp.pep.model.FuncionarioGerente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class Principal {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProvaPU");
    
    public static void main(String[] args) {
        cadastrarFuncioanrioAssalariado();
        cadastrarFuncionarioComissionado();
        cadastrarFuncionarioGerente();
        reajustarSalarioAssalariado(0.3);
        listarFuncionarioAssalariadosSalario();
        listarFuncionaro();
        
    }
    
    public static void cadastrarFuncioanrioAssalariado(){
        EntityManager em = emf.createEntityManager();
        
        FuncionarioAssalariado fa = new FuncionarioAssalariado();
        fa.setNome("guilherme");
        fa.setSalario(9000.00);
        
        if (verificarLogin("funcssalariado")){
            fa.setLogin("funcassalariado");
            fa.setSenha("123");
        
            em.getTransaction().begin();
        
            em.persist(fa);
            em.getTransaction().commit();
            
        }
        
        em.close();
        
    }
    
    public static void cadastrarFuncionarioComissionado(){
        EntityManager em = emf.createEntityManager();
        
        FuncionarioComissionado fc = new FuncionarioComissionado();
        fc.setNome("gustavo");
        fc.setSalario(1500.00);
        
        if (verificarLogin("funcacomissionado")) {
            fc.setLogin("funcacomissionado");
            fc.setSenha("123");
            fc.setComissao(200.0);
        
            em.getTransaction().begin();
        
            em.persist(fc);
            em.getTransaction().commit();
        }
       
        em.close();
    }
    
    public static void cadastrarFuncionarioGerente(){
        EntityManager em = emf.createEntityManager();
        
        FuncionarioGerente fg = new FuncionarioGerente();
        fg.setNome("gabriel");
        fg.setSalario(2200.00);
        fg.setPercentualVendas(20.0);
        
        if (verificarLogin("funcgerente")) {
            fg.setLogin("funcgerente");
            fg.setSenha("123");
        
            em.getTransaction().begin();
        
            em.persist(fg);
            em.getTransaction().commit();
        }
        
        em.close();
    }
    
    public static void reajustarSalarioAssalariado(double percent){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        double novo_salario = 0.0;
        
        
        TypedQuery<FuncionarioAssalariado> query = em.createNamedQuery("FuncionarioAssalariado.reajustaSalarioAssalariado", FuncionarioAssalariado.class);
        List<FuncionarioAssalariado> funcs = query.getResultList();
        
        if (funcs != null) {
            for (FuncionarioAssalariado func : funcs) {
            novo_salario = func.getSalario() + (func.getSalario() * percent);
            func.setSalario(novo_salario);
            em.persist(func);
            em.getTransaction().commit();
            
            }
        
        em.close();
        }
    }
    
    public static void listarFuncionarioAssalariadosSalario(){
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<FuncionarioAssalariado> query = em.createNamedQuery("FuncionarioAssalariado.listarFuncionarioAssalariadosSalario", FuncionarioAssalariado.class);
        
        List<FuncionarioAssalariado> funcs = query.getResultList();
        
        System.out.println("Listar Funcionario Assalariados pelo salario");
        for (FuncionarioAssalariado func : funcs) {
            System.out.println("nome: "+ func.getNome()+ " Salario: "+func.getSalario());
        }
        em.close();
        System.out.println("----------------------------------------");
    }
    
    public static void listarFuncionaro(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Funcionario> query = em.createNamedQuery("Funcionario.listarFuncionarios", Funcionario.class);
        
        List<Funcionario> funcs = query.getResultList();
        
        System.out.println("Listar Funcionarios");
        if (funcs != null) {
            for (Funcionario func : funcs) {
                if (func instanceof FuncionarioAssalariado) {
                    FuncionarioAssalariado fa = (FuncionarioAssalariado) func;
                    System.out.println("Codigo: "+fa.getCodigo()+" Nome: " +fa.getNome()+" Salario: " +fa.getSalario() +" Login: "+fa.getLogin()
                    +" Senha: " + fa.getSenha());
                }
                
                if (func instanceof FuncionarioComissionado) {
                    FuncionarioComissionado fa = (FuncionarioComissionado) func;
                    System.out.println("Codigo: "+fa.getCodigo()+" Nome: " +fa.getNome()+" Salario: " +fa.getSalario() +" Login: "+fa.getLogin()
                    +" Senha: " + fa.getSenha() +" Comissao: " +fa.getComissao());
                }
                
                if (func instanceof FuncionarioGerente) {
                    FuncionarioGerente fa = (FuncionarioGerente) func;
                    System.out.println("Codigo: "+fa.getCodigo()+" Nome: " +fa.getNome()+" Salario: " +fa.getSalario() +" Login: "+fa.getLogin()
                    +" Senha: " + fa.getSenha() +" Percentual de vendas: "+fa.getPercentualVendas());
                }
                
            }
            
        }
    }
    
    public static boolean verificarLogin(String log){
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Funcionario> query = em.createQuery("select f.login from Funcionario f where f.login = :log", Funcionario.class);
        query.setParameter("log", log);
        List<Funcionario> funcs = query.getResultList();
        
        if (funcs != null) {
            
            return true;
        }
            
        return false;
    }
        
}
