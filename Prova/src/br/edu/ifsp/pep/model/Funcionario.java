package br.edu.ifsp.pep.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "funcionario")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "funcionario")
@DiscriminatorColumn(name = "tipo", length = 30, discriminatorType = DiscriminatorType.STRING)
public class Funcionario implements Serializable{

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Column(name = "nome", length = 50)
    private String nome;
    
    @Column(name = "login", length = 20, nullable = false)
    private String login;
    
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;

    public Funcionario() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
