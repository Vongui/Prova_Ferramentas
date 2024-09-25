package br.edu.ifsp.pep.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario_gerente")
//@PrimaryKeyJoinColumn(name = "codigo")
@DiscriminatorValue(value = "funcionario_gerente")
public class FuncionarioGerente extends Funcionario{

    @Column(name = "salario")
    private double salario;
    
    @Column(name = "percentual_venda")
    private double percentualVendas;

    public FuncionarioGerente() {
    }

    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getPercentualVendas() {
        return percentualVendas;
    }

    public void setPercentualVendas(double percentualVendas) {
        this.percentualVendas = percentualVendas;
    }
    
    
}
