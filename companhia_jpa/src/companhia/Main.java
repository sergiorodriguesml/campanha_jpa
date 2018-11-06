package companhia;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.Scanner;

import companhia.dao.DepartamentoDAO;
import companhia.dao.DepartamentoJPADAO;
import companhia.dao.DependenteDAO;
import companhia.dao.DependenteJPADAO;
import companhia.dao.FuncionarioDAO;
import companhia.dao.FuncionarioJPADAO;
import companhia.dao.PesProjDAO;
import companhia.dao.PesProjJPADAO;
import companhia.dao.ProjetoDAO;
import companhia.dao.ProjetoJPADAO;
import companhia.model.Departamento;
import companhia.model.Dependente;
import companhia.model.FLimpeza;
import companhia.model.Funcionario;
import companhia.model.PesProj;
import companhia.model.Pesquisador;
import companhia.model.Projeto;
import companhia.model.Secretario;

public class Main {

	public static void menu(Scanner sc){
		DepartamentoDAO dptdao = new DepartamentoJPADAO();
		DependenteDAO depedao = new DependenteJPADAO();
		FuncionarioDAO fundao = new FuncionarioJPADAO();
		ProjetoDAO  projdao = new ProjetoJPADAO();
		PesProjDAO pesprojdao = new PesProjJPADAO();
		
		Departamento dpt;
		Dependente depe;
		Funcionario fun;
		FLimpeza funL;
		Pesquisador pesq;
		Projeto proj;
		PesProj pesproj;
		
		ArrayList<Departamento>dpts;
		ArrayList<Dependente>depes;
		ArrayList<Funcionario>funs;
		ArrayList<Projeto> projs;
		List<PesProj> pesprojs;
		
		int menu,jornada,horas;
		String nome,dt,endereco,areaAtuacao,grauEscolaridade,cargo,tempo,parentesco;
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
				+"8 - Cadastrar Gerente\n"
				+"9 - Remover Funcionario\n"
				+"10 - Ver Funcionarios de um Departamento\n"
				+"11 - Ver Funcionario pelo id\n"		
				+"Projeto ==================\n"
				+"12 - Ver Projetos\n"
				+"13 - Cadastrar Projeto\n"
				+"14 - Remover Projeto\n"
				+"15 - Cadastras Pesquisador em um Projeto\n"
				+"16 - Ver Projetos de um Departamento\n"
				+"17 - Ver Funcionarios de um Projeto\n"
				+"18 - Ver Projetos de um Funcionario\n"
				+"Dependentes==============\n"
				+"19 - Cadastrar Depedente de um Funcionario\n"
				+"20 - Ver Dependentes de um Funcionario\n"
				+"21 - Remover Dependente de um Funcionario\n"
				+"=========================\n"
				+"22 - Sair\n"
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
			break;
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
			System.out.println("=========================");
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
			System.out.println("=========================");
			menu(sc);
			break;
		case 4:
			System.out.println("=========================");
			funs = (ArrayList<Funcionario>) fundao.find();
			System.out.println(funs.toString());
			System.out.println("=========================");
			menu(sc);
			break;
		case 5:
			System.out.println("=========================");
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
			System.out.println("=========================");
			menu(sc);
			break;
		case 6:
			System.out.println("=========================");
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
			System.out.println("=========================");
			menu(sc);
			break;
		case 7:
			System.out.println("=========================");
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
			System.out.println("=========================");
			menu(sc);
			break;
		case 8:
			System.out.println("=========================");
			System.out.println("Digite o Id do funcionario: ");
			funL = (FLimpeza) fundao.find(sc.nextInt());			
			System.out.println("Digite o Id do Gerente");
			funL.setGerente((FLimpeza) fundao.find(sc.nextInt()));
			fundao.beginTransaction();
			fundao.save(funL);
			fundao.commit();
			System.out.println("Gerente Adicionado com Sucesso!");
			System.out.println("=========================");
			menu(sc);
			break;
		case 9:
			System.out.println("=========================");
			System.out.println("Digite o Id do funcionario: ");
			fun = fundao.find(sc.nextInt());
			fundao.beginTransaction();
			fundao.delete(fun);
			fundao.commit();
			System.out.println(fun.toString()+"\n"
					+"Removido com Sucesso!!");
			System.out.println("=========================");
			menu(sc);
			break;
		case 10:
			System.out.println("=========================");
			System.out.println("Digite o Id do Departamento");
			funs = (ArrayList<Funcionario>) fundao.findByDpt(sc.nextInt());
			System.out.println(funs.toString());
			System.out.println("=========================");
			menu(sc);
			break;
		case 11:
			System.out.println("=========================");
			System.out.println("Digite o id do funcionario: ");
			fun = fundao.find(sc.nextInt());
			System.out.println(fun.toString());
			System.out.println("=========================");
			menu(sc);
			break;
		case 12:
			System.out.println("=========================");
			projs = (ArrayList<Projeto>) projdao.find();
			System.out.println(projs.toString());
			System.out.println("=========================");
			menu(sc);
			break;
		case 13:
			System.out.println("=========================");
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
			System.out.println("=========================");
			menu(sc);
			break;
		case 14:
			System.out.println("=========================");
			System.out.println("Digite o Id do projeto: ");
			proj = projdao.find(sc.nextInt());
			projdao.beginTransaction();
			projdao.delete(proj);
			projdao.commit();
			System.out.println("Projeto Deletado com Sucesso!!");
			System.out.println("=========================");
			menu(sc);
			break;
		case 15:
			System.out.println("=========================");
			System.out.println("Digite o Id do Projeto: ");
			proj = projdao.find(sc.nextInt());
			System.out.println("digite o Id do Pesquisador: ");
			pesq = (Pesquisador) fundao.find(sc.nextInt());
			System.out.println("Digite a quantidade de Horas: ");
			horas = sc.nextInt();
			pesproj = new PesProj(pesq, proj, horas);
			if(pesq.getPesproj() != null){
				pesprojs = pesq.getPesproj();
				pesprojs.add(pesproj);
				pesq.setPesproj(pesprojs);
			}else{
				pesprojs =new ArrayList<>();
				pesprojs.add(pesproj);
				pesq.setPesproj(pesprojs);
			}
			pesprojdao.beginTransaction();
			pesprojdao.save(pesproj);
			pesprojdao.commit();
			System.out.println("=========================");
			menu(sc);
			break;
		case 16:
			System.out.println("=========================");
			System.out.println("Digite o Id do Departamento: ");
			System.out.println(projs = (ArrayList<Projeto>) projdao.findByDpt(sc.nextInt()));
			System.out.println("=========================");
			menu(sc);
			break;
		case 17:
			System.out.println("=========================");
			System.out.println("Digite o Id do Projeto: ");
			pesprojs = pesprojdao.findByProj(sc.nextInt());
			for(PesProj pp:pesprojs){
				System.out.println(pp.toFString());
			}
			System.out.println("=========================");
			menu(sc);
			break;
		case 18:
			System.out.println("=========================");
			System.out.println("Digite o Id do Funcionario: ");
			pesprojs = pesprojdao.findByFun(sc.nextInt());
			for(PesProj pp:pesprojs){
				System.out.println(pp.toPString());
			}
			System.out.println("=========================");
			menu(sc);
			break;
		case 19:
			System.out.println("=========================");
			System.out.println("Digite o nome: ");
			sc.nextLine();
			nome = sc.nextLine();
			System.out.println("Digite o Sexo: ");
			sexo = sc.nextLine().toUpperCase().charAt(0);
			System.out.println("Digite o Grau de Parentesco: ");
			parentesco = sc.nextLine();
			System.out.println("Digite o Id do Funcionario: ");
			fun = fundao.find(sc.nextInt());
			depe = new Dependente(nome, sexo, parentesco, fun);
			depedao.beginTransaction();
			depedao.save(depe);
			depedao.commit();
			System.out.println("Dependente Adicionado com Sucesso!");
			System.out.println("=========================");
			menu(sc);
			break;
		case 20:
			System.out.println("=========================");
			System.out.println("Digite o Id do Funcionario:");
			depes = (ArrayList<Dependente>) depedao.findByFun(sc.nextInt());
			System.out.println("=========================");
			System.out.println(depes.toString());
			System.out.println("=========================");
			menu(sc);
			break;
		case 21:
			System.out.println("=========================");
			System.out.println("Digite o Id do Dependente:");
			depe = depedao.find(sc.nextInt());
			depedao.beginTransaction();
			depedao.delete(depe);
			depedao.commit();
			System.out.println("Dependente Removido com Sucesso");
			System.out.println("=========================");
			menu(sc);
			break;
		case 22:
			depedao.close();
			dptdao.close();
			fundao.close();
			projdao.close();
			pesprojdao.close();
			System.out.println("=========================");
			System.out.println("Obrigado, volte sempre!");
			System.out.println("=========================");
			System.exit(0);
			break;
		default:
			System.out.println("=========================");
			System.out.println("Opção Inválida! \n");
			System.out.println("=========================");
			menu(sc);
			break;
		}


	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		menu(sc);


	}

}
