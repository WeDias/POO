package com.wb;

import java.util.Scanner;
import java.sql.SQLException;

public class Sistema {
	public static Scanner entrada = new Scanner(System.in);
	public static Agenda agenda = new Agenda();
	public static Cliente cliente;
	
	public static void menuOpcao() throws ClassNotFoundException, SQLException {
		System.out.println("\n============== MENU ==============\n");
		System.out.println("[1] CADASTRAR NOVO CLIENTE");
		System.out.println("[2] EDITAR CADASTRO");
		System.out.println("[3] REMOVER CADASTRO");
		System.out.println("[4] MOSTRAR UM CLIENTE");
		System.out.println("[5] MOSTRAR TODOS CLIENTES");
		System.out.println("[6] MOSTRAR CLIENTES POR GÊNERO");
		System.out.println("[7] RELATÓRIOS BÁSICOS ");
		System.out.println("[0] SAIR DO PROGRAMA\n");
		System.out.print("DIGITE UM OPÇÃO: ");
	}
	
	public static void selecionador() throws ClassNotFoundException, SQLException {
		boolean online = true;
		while(online) {
			menuOpcao();
			String escolha = entrada.nextLine();
			if(escolha.contentEquals("0")) {
				online = false;
				entrada.close();
				System.out.println("\n============== FIM! ==============");
				break;
			}
			switch(escolha) {
			case "1": novoCadastro();
				break;
			case "2": editarCadastro();
				break;
			case "3": removerCadastro();
				break;
			case "4": dadosCliente();
				break;
			case "5": mostrarTodosClientes();
				break;
			case "6": clientePorGenero();
				break;
			case "7": mostrarRelatorios();
				break;
			}
		}
	}
	
	public static void novoCadastro() throws ClassNotFoundException, SQLException {
		System.out.println("\n===== CADASTRAR NOVO CLIENTE =====");
		cliente = new Cliente();
		agenda.cadastrarCliente(cliente);
		System.out.println("CLIENTE CADASTRADO COM SUCESSO!");
	}
	
	public static void editarCadastro() throws ClassNotFoundException, SQLException {
		System.out.println("\n======== EDITAR CADASTRO ========");
		System.out.print("DIGITE A ID: ");
		String idCa = entrada.nextLine();
		cliente = new Cliente();
		agenda.atualizarCliente(idCa, cliente);
		System.out.println("CLIENTE CADASTRADO COM SUCESSO!");
	}
	
	public static void removerCadastro() throws ClassNotFoundException, SQLException {
		System.out.println("\n======== REMOVER CADASTRO ========");
		System.out.print("DIGITE A ID: ");
		String id = entrada.nextLine();
		agenda.removerCliente(id);
		System.out.println("CLIENTE REMOVIDO COM SUCESSO!");
	}
	
	public static void dadosCliente() throws ClassNotFoundException, SQLException {
		System.out.println("\n========= DADOS CLIENTE =========");
		System.out.print("DIGITE A ID: ");
		String idC = entrada.nextLine();
		System.out.println();
		agenda.cliente(idC);
	}
	
	public static void mostrarTodosClientes() throws ClassNotFoundException, SQLException{
		System.out.println("\n========= TODOS CLIENTES =========\n");
		agenda.clientes();
	}
	
	public static void clientePorGenero() throws ClassNotFoundException, SQLException{
		System.out.println("\n====== CLIENTES POR GÊNERO ======");
		while(true) {
			System.out.print("DIGITE O GÊNERO M OU F: ");
			String opcao = entrada.nextLine().toUpperCase();
			System.out.println();
			if(opcao.contentEquals("F") || opcao.contentEquals("M")) {
				agenda.clientes(opcao);
				break;
			}
		}
	}
	
	public static void mostrarRelatorios() throws ClassNotFoundException, SQLException{
		System.out.println("\n======= RELATÓRIOS BÁSICOS =======\n");
		agenda.relatorios();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		selecionador();
	}

}