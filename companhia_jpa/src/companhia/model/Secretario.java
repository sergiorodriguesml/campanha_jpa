package companhia.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class Secretario extends Funcionario{
	@Column(name="grau_escolaridade")
	private String grauEscolaridade;



	public Secretario(String nome, char sexo, Date dtNascimento, String endereco, double salario,Departamento departamento,String grauEscolaridade) {
		super(nome,sexo,dtNascimento,endereco,salario,departamento);
		this.grauEscolaridade = grauEscolaridade;
	}
	public Secretario(){}
	
	public String getGrauEscolaridade() {
		return grauEscolaridade;
	}
	public void setGrauEscolaridade(String grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}
	@Override
	public String toString() {
		return "\nSecretario ["+ super.toString() +", grauEscolaridade = " + grauEscolaridade + "]";
	}
	
	
	
}
