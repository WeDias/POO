package com.fatec;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Cliente implements Serializable {
	private String nome;
	private String telefone;
	private String endereco;
	private String cpf;
	private ArrayList<Veiculo> veiculos;
	
	public Cliente() {
		System.out.println("---------------- NOVO CLIENTE ----------------");
		System.out.print("Digite o nome: ");
		this.setNome(Sistema.entrada.nextLine().toUpperCase());
		
		System.out.print("Digite o telefone: ");
		this.setTelefone(Sistema.entrada.nextLine());
		
		System.out.print("Digite o endereço: ");
		this.setEndereco(Sistema.entrada.nextLine().toUpperCase());
		
		System.out.print("Digite o CPF: ");
		this.setCpf(Sistema.entrada.nextLine());
		
		veiculos = new ArrayList<Veiculo>();
		System.out.print("Digite o número de carros a serem cadastrados: ");
		int ncarros = Integer.parseInt(Sistema.entrada.nextLine());
		for(int c = 0; c < ncarros; c++) veiculos.add(new Veiculo());
	}
	
	@Override
	public String toString() {
		return String.format("CPF: %s Nome: %s", cpf, nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
