package companhia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento implements Bean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="departamento_id")
	private int id;
	private String nome;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "departamento")
	private List<Funcionario> funcionarios;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "departamento")
	private List<Projeto> projetos;
	
	
	public Departamento(){}
	
	public Departamento(String nome){
		this.nome = nome;
	}
	
	public Departamento(int id, String nome, List<Funcionario> funcionarios, List<Projeto> projetos) {
		this.id = id;
		this.nome = nome;
		this.funcionarios = funcionarios;
		this.projetos = projetos;
	}


	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id=id;		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	@Override
	public String toString() {
		return "\nDepartamento [id=" + id + ", nome=" + nome + "]\n";
	}
	
	


}
