package companhia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries(
		@NamedQuery(name="Projeto.findByDpt",query="select P from Projeto P where departamento_id=:id")
		)
public class Projeto implements Bean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="projeto_id")
	private int id;
	private String nome;
	private String tempo;
	@ManyToOne
	@JoinColumn(name = "departamento_id", nullable = false)
	private Departamento departamento;
	@OneToMany(mappedBy = "projeto")
	private List<PesProj> pesproj;
	
	public Projeto(){}
	

	public Projeto(String nome, String tempo, Departamento departamento) {
		this.nome = nome;
		this.tempo = tempo;
		this.departamento = departamento;
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

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}


	@Override
	public String toString() {
		return "\nProjeto [id = " + id + ", nome = " + nome + ", tempo = " + tempo + ", departamento = " + departamento.getNome() + "]";
	}


}
