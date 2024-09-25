package br.edu.ifsp.pep.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "funcionario_assalariado")
@DiscriminatorValue(value = "funcionario_assalariado")
@NamedQuery(name = "FuncionarioAssalariado.reajustaSalarioAssalariado", query = "select fa from FuncionarioAssalariado fa")
@NamedQuery(name = "FuncionarioAssalariado.listarFuncionarioAssalariadosSalario", query = "select fa from FuncionarioAssalariado fa where fa.salario > 10000")
public class FuncionarioAssalariado extends Funcionario{

    @Column(name = "salario")
    private double salario;

    public FuncionarioAssalariado() {
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
 
    
}
