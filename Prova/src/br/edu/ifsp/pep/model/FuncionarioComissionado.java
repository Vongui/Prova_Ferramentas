package br.edu.ifsp.pep.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "funcionario_comissionado")
@DiscriminatorValue(value = "funcionario_comissionado")
public class FuncionarioComissionado extends Funcionario{

    @Column(name = "salario")
    private double salario;
    
    @Column(name = "comissao")
    private double comissao;

    public FuncionarioComissionado() {
    }

    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    
    
    
}
