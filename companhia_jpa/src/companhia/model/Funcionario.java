package companhia.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
		@NamedQuery(name="Funcionario.findByDpt",query = "select f from Funcionario f where departamento_id=:id")
		})
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo_funcionario", discriminatorType=DiscriminatorType.STRING, length=1)
@DiscriminatorValue("F")
public class Funcionario implements Bean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="funcionario_id")
	private int id;
	private String nome;
	private char sexo;
	private Date dtNascimento;
	private String endereco;
	private double salario;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "funcionario")
	private List<Dependente> dependentes;
	@ManyToOne
	@JoinColumn(name = "departamento_id", nullable = false)
	private Departamento departamento;

	public Funcionario() {}

	public Funcionario(String nome, char sexo, Date dtNascimento, String endereco, double salario,Departamento departamento) {
		this.nome = nome;
		this.sexo = sexo;
		this.dtNascimento = dtNascimento;
		this.endereco = endereco;
		this.salario = salario;
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "id = " + id + ", nome = " + nome + ", sexo = " + sexo + ", dtNascimento = " + dtNascimento
				+ ", endereco = " + endereco + ", salario = " + salario + ", departamento = " + departamento.getNome();
	}



}
