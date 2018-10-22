package companhia;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

import companhia.dao.DepartamentoDAO;
import companhia.dao.DepartamentoJPADAO;
import companhia.dao.DependenteDAO;
import companhia.dao.FuncionarioDAO;
import companhia.dao.FuncionarioJPADAO;
import companhia.dao.ProjetoDAO;
import companhia.dao.ProjetoJPADAO;
import companhia.model.Departamento;
import companhia.model.FLimpeza;
import companhia.model.Funcionario;
import companhia.model.Pesquisador;
import companhia.model.Projeto;
import companhia.model.Secretario;

public class Main {

	public static void menu(Scanner sc){
		DepartamentoDAO dptdao = new DepartamentoJPADAO();
		FuncionarioDAO fundao = new FuncionarioJPADAO();
		ProjetoDAO  projdao = new ProjetoJPADAO();
		
		Departamento dpt;
		Funcionario fun;
		FLimpeza funL;
		Projeto proj;
		
		ArrayList<Departamento>dpts;
		ArrayList<Funcionario>funs;
		ArrayList<Projeto> projs;
		
		int menu,id,jornada;
		String nome,dt,endereco,areaAtuacao,grauEscolaridade,cargo,tempo;
		char sexo;
		double salario;
		Date data;
		
		System.out.println("Bem Vindo a CompanhiaJPA\n"
				+"=========================\n"
				+"Departamento ============\n"
				+"1 - Ver Departamentos\n"
				+"2 - Cadastrar Departamento\n"
				+"3 - Remover Departamento\n"
				+"Funcionario =============\n"
				+"4 - Ver Funcionarios da Companhia\n"
				+"5 - Cadastrar Pesquisador\n"
				+"6 - Cadastrar Secretario\n"
				+"7 - Cadastrar F. de Limpeza\n"
				+"8 - Cadastras Gerente\n"
				+"9 - Remover Funcionario\n"
				+"10 - Ver Funcionarios de um Departamento\n"
				+"11 - Ver Funcionario pelo id\n"		
				+"Projeto ==================\n"
				+"12 - Ver Projetos\n"
				+"13 - Cadastrar Projeto\n"
				+"14 - Remover Projeto\n"
				+"15 - Cadastras Pesquisador em um Projeto"
				+"16 - Ver Projetos de um Departamento\n"
				+"17 - Ver Funcionarios de um Projeto\n"
				+"=========================\n"
				+"18 - Sair\n"
				+"=========================\n");
		System.out.print("Digite uma opcao: ");
		menu = sc.nextInt();
		switch (menu) {
		case 1:
			dpts = new ArrayList<>();
			dpts = (ArrayList<Departamento>) dptdao.find();
			System.out.println("=========================");
			System.out.println(dpts.toString());
			System.out.println("=========================");
			menu(sc);
		case 2:
			System.out.println("=========================");
			System.out.print("Digite um nome: ");
			sc.nextLine();
			nome = sc.nextLine();
			dpt = new Departamento(nome);
			dptdao.beginTransaction();
			dptdao.save(dpt);
			dptdao.commit();
			System.out.println("Departamento adicionado com sucesso");
			menu(sc);			
			break;
		case 3:
			System.out.println("=========================");
			System.out.print("Digite o Id do Departamento: ");
			dpt = dptdao.find(sc.nextInt());
			dptdao.beginTransaction();
			dptdao.delete(dpt);
			dptdao.commit();
			System.out.println("Departamento Removido com sucesso!");
			menu(sc);
			break;
		case 4:
			funs = (ArrayList<Funcionario>) fundao.find();
			System.out.println(funs.toString());
			menu(sc);
			break;
		case 5:
			System.out.println("Digite o nome: ");
			sc.nextLine();
			nome = sc.nextLine();
			System.out.println("Digite o sexo: ");
			sexo = sc.nextLine().toUpperCase().charAt(0);
			System.out.println("Digite a data de nascimento: ");
			dt = sc.nextLine();
			data = Date.valueOf(dt);
			System.out.println("Digite o endereco: ");
			endereco = sc.nextLine();
			System.out.println("Digite a area de atuacao: ");
			areaAtuacao = sc.nextLine();
			System.out.println("Digite o salario: ");
			salario = sc.nextDouble();
			System.out.println("Digite o id do Departamento: ");
			dpt = dptdao.find(sc.nextInt());
			System.out.println("nome: "+nome+"\n"
					+"sexo: "+sexo+"\n"
					+"dt: "+data+"\n"
					+"endereco: "+endereco+"\n"
					+"salario: "+salario+"\n"
					+"area de atuacao: "+areaAtuacao+"\n"
					+dpt.toString());
			fun = new Pesquisador(nome, sexo, data, endereco, salario, dpt, areaAtuacao);
			fundao.beginTransaction();
			fundao.save(fun);
			fundao.commit();
			System.out.println("Pesquisador adicionado com sucesso!");

			menu(sc);
			break;
		case 6:
			System.out.println("Digite o nome: ");
			sc.nextLine();
			nome = sc.nextLine();
			System.out.println("Digite o sexo: ");
			sexo = sc.nextLine().toUpperCase().charAt(0);
			System.out.println("Digite a data de nascimento: ");
			dt = sc.nextLine();
			data = Date.valueOf(dt);
			System.out.println("Digite o endereco: ");
			endereco = sc.nextLine();
			System.out.println("Digite o salario: ");
			salario = sc.nextDouble();
			System.out.println("Digite o grau de escolaridade: ");
			sc.nextLine();
			grauEscolaridade = sc.nextLine();
			System.out.println("Digite o id do Departamento: ");
			dpt = dptdao.find(sc.nextInt());
			System.out.println("nome: "+nome+"\n"
					+"sexo: "+sexo+"\n"
					+"dt: "+data+"\n"
					+"endereco: "+endereco+"\n"
					+"salario: "+salario+"\n"
					+"grau de escolaridade: "+grauEscolaridade+"\n"
					+dpt.toString());
			fun = new Secretario(nome, sexo, data, endereco, salario, dpt,grauEscolaridade);
			fundao.beginTransaction();
			fundao.save(fun);
			fundao.commit();
			System.out.println("Secretario adicionado com sucesso!");
			menu(sc);
			break;
		case 7:
			System.out.println("Digite o nome: ");
			sc.nextLine();
			nome = sc.nextLine();
			System.out.println("Digite o sexo: ");
			sexo = sc.nextLine().toUpperCase().charAt(0);
			System.out.println("Digite a data de nascimento: ");
			dt = sc.nextLine();
			data = Date.valueOf(dt);
			System.out.println("Digite o endereco: ");
			endereco = sc.nextLine();
			System.out.println("Digite o cargo: ");
			cargo = sc.nextLine();
			System.out.println("Digite a jornada: ");
			jornada = sc.nextInt();
			System.out.println("Digite o salario: ");
			salario = sc.nextDouble();
			System.out.println("Digite o id do Departamento: ");
			dpt = dptdao.find(sc.nextInt());
			System.out.println("nome: "+nome+"\n"
					+"sexo: "+sexo+"\n"
					+"dt: "+data+"\n"
					+"endereco: "+endereco+"\n"
					+"salario: "+salario+"\n"
					+"cargo: "+cargo+"\n"
					+"jornada de trabalho: "+jornada+"\n"
					+dpt.toString());
			fun = new FLimpeza(nome, sexo, data, endereco, salario, dpt, cargo, jornada);
			fundao.beginTransaction();
			fundao.save(fun);
			fundao.commit();
			System.out.println("F. Limpeza adicionado com sucesso!");
			menu(sc);
			break;
		case 8:
			System.out.println("Digite o Id do funcionario: ");
			funL = (FLimpeza) fundao.find(sc.nextInt());			
			System.out.println("Digite o Id do Gerente");
			funL.setGerente((FLimpeza) fundao.find(sc.nextInt()));
			fundao.beginTransaction();
			fundao.save(funL);
			fundao.commit();
			System.out.println("Gerente Adicionado com Sucesso!");
			menu(sc);
			break;
		case 9:
			System.out.println("Digite o Id do funcionario: ");
			fun = fundao.find(sc.nextInt());
			fundao.beginTransaction();
			fundao.delete(fun);
			fundao.commit();
			System.out.println(fun.toString()+"\n"
					+"Removido com Sucesso!!");
			menu(sc);
			break;
		case 10:
			System.out.println("Digite o Id do Departamento");
			funs = (ArrayList<Funcionario>) fundao.findByDpt(sc.nextInt());
			System.out.println(funs.toString());
			break;
		case 11:
			System.out.println("Digite o id do funcionario: ");
			fun = fundao.find(sc.nextInt());
			System.out.println(fun.toString());
			menu(sc);
			break;
		case 12:
			projs = (ArrayList<Projeto>) projdao.find();
			System.out.println(projs.toString());
			menu(sc);
			break;
		case 13:
			System.out.println("Digite o nome: ");
			sc.nextLine();
			nome = sc.nextLine();
			System.out.println("Digite o tempo: ");
			tempo = sc.nextLine();
			System.out.println("Digite o id do Departamento: ");
			dpt = dptdao.find(sc.nextInt());
			proj = new Projeto(nome, tempo, dpt);
			projdao.beginTransaction();
			projdao.save(proj);
			projdao.commit();
			System.out.println("Projeto Adicionado com Sucesso!!");
			menu(sc);
			break;
		case 14:
			System.out.println("Digite o Id do projeto: ");
			proj = projdao.find(sc.nextInt());
			projdao.beginTransaction();
			projdao.delete(proj);
			projdao.commit();
			System.out.println("Projeto Deletado com Sucesso!!");
			menu(sc);
			break;
		case 15:
			break;
		case 16:
			break;
		case 17:
			break;
		case 18:
			System.out.println("Obrigado, volte sempre!");
			System.exit(0);
			break;
		default:
			System.out.println("Opção Inválida! \n");
			menu(sc);
			break;
		}


	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		menu(sc);


	}

}
