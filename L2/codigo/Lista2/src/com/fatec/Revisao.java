package com.fatec;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Revisao implements Serializable {
	private String data;
	private String descricao;
	private Cliente cliente;
	
	public Revisao() {
		System.out.println("---------------- NOVA REVISÃO ----------------");
		cliente = Sistema.agenda.selecionarCliente();
		System.out.print("Digite a descrição do serviço: ");
		setDescricao(Sistema.entrada.nextLine());
		setData();
	}

	public String getData() {
		return data;
	}

	public void setData() {
		System.out.print("Digite o dia: ");
		String dia = Sistema.entrada.nextLine();
		
		System.out.print("Digite o mês: ");
		String mes = Sistema.entrada.nextLine();
		
		System.out.print("Digite o ano: ");
		String ano = Sistema.entrada.nextLine();
		this.data = String.format("%s/%s/%s", dia, mes, ano);
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String nome) {
		this.descricao = nome;
	}
	
	@Override
	public String toString() {
		return String.format("Data: %s %s", data, cliente);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
