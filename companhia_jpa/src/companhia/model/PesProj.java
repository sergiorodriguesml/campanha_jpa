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
	@NamedQuery(name="PesProj.findByProj",query="select p from PesProj p where projeto_id=:id"),
	@NamedQuery(name="PesProj.findByFun",query="select p from PesProj p where funcionario_id=:id")
})
public class PesProj implements Bean{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pesproj_id")
	private int id;
	@ManyToOne @JoinColumn(name = "funcionario_id", nullable=false)
	private Pesquisador pesquisador;
	@ManyToOne @JoinColumn(name = "projeto_id",nullable=false)
	private Projeto projeto;
	private int horas;
	
	public PesProj() {}

	
	
	public PesProj(Pesquisador pesquisador, Projeto projeto, int horas) {
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



	@Override
	public String toString() {
		return "PesProj [pesquisador=" + pesquisador + ", projeto=" + projeto + ", horas=" + horas + "]";
	}
	public String toFString() {
		return "\n[projeto = " + projeto.getNome() + ",horas = " + horas + "," + pesquisador + "]";
	}
	public String toPString() {
		return "\n[pesquisador = " + pesquisador.getNome() + ",horas = " + horas + "," + projeto + "]";
	}
}
