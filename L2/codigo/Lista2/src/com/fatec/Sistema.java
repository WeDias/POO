package com.fatec;

import java.io.IOException;
import java.util.Scanner;

public class Sistema {
	public static Agenda agenda = new Agenda();
	public static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String escolha; agenda.carregar();
		do {
			System.out.println("-------------------- MENU --------------------");
			System.out.println("[1] Cadastrar cliente");
			System.out.println("[2] Agendar revisão");
			System.out.println("[3] Trocar data de revisão");
			System.out.println("[4] Cancelar agendamento");
			System.out.println("[5] Relatório de um cliente");
			System.out.println("[0] Sair");
			System.out.print("Digite uma opção: ");
			escolha = entrada.nextLine();
			switch (escolha) {
				case "1": agenda.cadastrarCliente(); break;
				case "2": agenda.novaRevisao(); break;
				case "3": agenda.alterarRevisao(); break;
				case "4": agenda.cancelarRevisao(); break;
				case "5": agenda.relatorioCliente(); break;
			}
		} while(!escolha.contentEquals("0"));
		entrada.close(); agenda.salvar();
		System.out.println("-------------------- FIM! --------------------");
	}
	
}
