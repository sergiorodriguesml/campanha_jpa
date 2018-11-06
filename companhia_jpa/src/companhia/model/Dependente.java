package companhia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Dependente.findByFun",query = "select d from Dependente d where funcionario_id=:id")
	})
public class Dependente implements Bean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Dependente_id")
	private  int id;
	private String nome;
	private char sexo;
	@Column(name="grau_parentesco")
	private String grauParentesco;
	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;
	
	public Dependente() {}

	public Dependente(String nome, char sexo, String grauParentesco, Funcionario funcionario) {
		this.nome = nome;
		this.sexo = sexo;
		this.grauParentesco = grauParentesco;
		this.funcionario = funcionario;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	@Override
	public String toString() {
		return "\nDependente [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", grauParentesco=" + grauParentesco
				+ "]";
	}
	
	
	
	
	
}
