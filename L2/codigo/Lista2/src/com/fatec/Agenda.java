package com.fatec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Agenda {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Revisao> revisoes = new ArrayList<Revisao>();
	
	public void cadastrarCliente() {
		clientes.add(new Cliente());
	}
	
	public void verClientes() {
		int index = 0;
		for(Cliente cliente : Sistema.agenda.getClientes())
			System.out.println(String.format("[ID: %d] %s", index++, cliente));
	}
	
	public Cliente selecionarCliente() {
		verClientes();
		System.out.print("Digite o ID do cliente: ");
		int id = Integer.parseInt(Sistema.entrada.nextLine());
		return Sistema.agenda.getClientes().get(id);
	}
	
	public void relatorioCliente() {
		System.out.println("-------------- RELATÓRIO CLIENTE --------------");
		Cliente cliente = selecionarCliente();
		for(Revisao revisao : Sistema.agenda.getRevisoes())
			if(cliente.getCpf().contentEquals(revisao.getCliente().getCpf()))
				System.out.println(String.format("%s %s", revisao.getData(), revisao.getDescricao()));
	}
	
	public void novaRevisao() {
		revisoes.add(new Revisao());
	}
	
	public void alterarRevisao() {
		System.out.println("-------------- ALTERAR REVISÃO --------------");
		Revisao revisao = selecionarRevisao();
		revisao.setData();
	}
	
	public void cancelarRevisao() {
		System.out.println("-------------- CANCELAR REVISÃO --------------");
		verRevisoes();
		System.out.print("Digite o ID da revisão: ");
		int ind = Integer.parseInt(Sistema.entrada.nextLine());
		revisoes.remove(ind);
	}
	
	public void verRevisoes() {
		int index = 0;
		for(Revisao revisao : Sistema.agenda.getRevisoes())
			System.out.println(
					String.format("[ID: %d] Data: %s %s",
							index++, revisao.getData(), revisao.getCliente()));
	}
	
	public Revisao selecionarRevisao() {
		verRevisoes();
		System.out.print("Digite o ID da revisão: ");
		int id = Integer.parseInt(Sistema.entrada.nextLine());
		return Sistema.agenda.getRevisoes().get(id);
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Revisao> getRevisoes() {
		return revisoes;
	}

	public void setRevisoes(ArrayList<Revisao> revisoes) {
		this.revisoes = revisoes;
	}
	
	public void salvar() throws IOException {
		FileOutputStream salvarClientes = new FileOutputStream("clientes.ser");
	    ObjectOutputStream sC = new ObjectOutputStream(salvarClientes);
	    sC.writeObject(clientes); sC.close();
	    
	    FileOutputStream salvarRevisoes = new FileOutputStream("revisoes.ser");
	    ObjectOutputStream sR = new ObjectOutputStream(salvarRevisoes);
	    sR.writeObject(revisoes); sR.close();
	}
	
	@SuppressWarnings("unchecked")
	public void carregar() throws IOException, ClassNotFoundException {
		FileInputStream lerClientes = new FileInputStream("clientes.ser");
	    ObjectInputStream lC = new ObjectInputStream(lerClientes);
	    clientes = (ArrayList<Cliente>) lC.readObject(); lC.close();
	    
	    FileInputStream lerRevisoes = new FileInputStream("revisoes.ser");
	    ObjectInputStream lR = new ObjectInputStream(lerRevisoes);
	    revisoes = (ArrayList<Revisao>) lR.readObject(); lR.close();
	}
	
}
