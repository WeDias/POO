package com.wb;

public class Cliente {
	private String nome;
	private String telefone;
	private String dataNasc;
	private String genero;
	
	Cliente(){
		System.out.print("NOME: ");
		this.nome = Sistema.entrada.nextLine().toUpperCase();
		
		System.out.print("TELEFONE: ");
		this.telefone = Sistema.entrada.nextLine();
		
		System.out.println("DATA DE NASCIMENTO");
		System.out.print("DIA: ");
		String dia = Sistema.entrada.nextLine();
		System.out.print("MÊS: ");
		String mes = Sistema.entrada.nextLine();
		System.out.print("ANO: ");
		String ano = Sistema.entrada.nextLine();
		this.dataNasc = ano + "-" + mes + "-" + dia;
		
		System.out.print("GÊNERO M ou F: ");
		this.genero = Sistema.entrada.nextLine().toUpperCase();
		
	}
	
	public String getNome() {
		return this.nome;
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

	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNas) {
		this.dataNasc = dataNas;
	}

	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

}
