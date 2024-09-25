package br.edu.ifsp.pep.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "funcionario_assalariado")
//@PrimaryKeyJoinColumn(name = "codigo")
@DiscriminatorValue(value = "funcionario_assalariado")
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
