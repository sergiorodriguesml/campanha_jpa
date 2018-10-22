package companhia.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("L")
public class FLimpeza extends Funcionario {
	private String cargo;
	private int jornada;
	@ManyToOne
	@JoinColumn(name="gerente_id")
	private FLimpeza gerente;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "gerente")
	private List<FLimpeza> subordinados;

	public FLimpeza() {}

	public FLimpeza(String nome, char sexo, Date dtNascimento, String endereco, double salario,Departamento departamento,String cargo, int jornada) {
		super(nome,sexo,dtNascimento,endereco,salario,departamento);
		this.cargo = cargo;
		this.jornada = jornada;
	}

	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getJornada() {
		return jornada;
	}
	public void setJornada(int jornada) {
		this.jornada = jornada;
	}



	public FLimpeza getGerente() {
		return gerente;
	}



	public void setGerente(FLimpeza gerente) {
		this.gerente = gerente;
	}



	public List<FLimpeza> getSubordinados() {
		return subordinados;
	}



	public void setSubordinados(List<FLimpeza> subordinados) {
		this.subordinados = subordinados;
	}



	@Override
	public String toString() {
		if(gerente != null){
			return "\nFLimpeza ["+super.toString()+", cargo = " + cargo + ", jornada = " + jornada + ", gerente = " + gerente.getNome() + "]";
		}else{
			return "\nFLimpeza ["+super.toString()+", cargo = " + cargo + ", jornada = " + jornada + "]";
		}
	}




}
