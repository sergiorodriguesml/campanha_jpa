package companhia.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("P")
public class Pesquisador extends Funcionario{
	@Column(name="area_atuacao")
	private String areaAtuacao;
	@OneToMany(mappedBy = "pesquisador")
	private List<PesProj> pesproj;
	
	public Pesquisador() {}
	
	
	
	public Pesquisador(String nome, char sexo, Date dtNascimento, String endereco, double salario,Departamento departamento,String areaAtuacao) {
		super(nome,sexo,dtNascimento,endereco,salario,departamento);
		this.areaAtuacao = areaAtuacao;
	}



	public String getAreaAtuacao() {
		return areaAtuacao;
	}



	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}



	public List<PesProj> getPesproj() {
		return pesproj;
	}



	public void setPesproj(List<PesProj> pesproj) {
		this.pesproj = pesproj;
	}



	@Override
	public String toString() {
		return "\nPesquisador ["+super.toString()+", areaAtuacao = " + areaAtuacao+"]";
	}

	
	

	
}
