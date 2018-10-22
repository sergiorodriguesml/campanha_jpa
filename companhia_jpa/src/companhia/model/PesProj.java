package companhia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PesProj implements Bean{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pesproj_id")
	private int id;
	@ManyToOne @JoinColumn(name = "funcionario_id")
	private Pesquisador pesquisador;
	@ManyToOne @JoinColumn(name = "projeto_id")
	private Projeto projeto;
	private int horas;
	
	public PesProj() {}

	
	
	public PesProj(int id, Pesquisador pesquisador, Projeto projeto, int horas) {
		this.id = id;
		this.pesquisador = pesquisador;
		this.projeto = projeto;
		this.horas = horas;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Pesquisador getPesquisador() {
		return pesquisador;
	}



	public void setPesquisador(Pesquisador pesquisador) {
		this.pesquisador = pesquisador;
	}



	public Projeto getProjeto() {
		return projeto;
	}



	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}



	public int getHoras() {
		return horas;
	}



	public void setHoras(int horas) {
		this.horas = horas;
	}
}
