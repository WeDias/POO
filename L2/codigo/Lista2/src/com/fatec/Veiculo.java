package com.fatec;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Veiculo implements Serializable {
	private String placa;
	private String modelo;
	private int anoFab;
	private double valor;
	
	public Veiculo() {
		System.out.println("---------------- NOVO VEICULO ----------------");
		System.out.print("Digite a placa do veículo: ");
		this.setPlaca(Sistema.entrada.nextLine().toUpperCase());
		
		System.out.print("Digite o modelo do veículo: ");
		this.setModelo(Sistema.entrada.nextLine().toUpperCase());
		
		System.out.print("Digite o ano de fabricação do veículo: ");
		this.setAnoFab(Integer.parseInt(Sistema.entrada.nextLine()));
		
		System.out.print("Digite o valor de compra do veículo: ");
		this.setValor(Double.parseDouble(Sistema.entrada.nextLine()));
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoFab() {
		return anoFab;
	}

	public void setAnoFab(int anoFab) {
		this.anoFab = anoFab;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
