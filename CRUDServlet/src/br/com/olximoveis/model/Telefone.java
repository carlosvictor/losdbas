package br.com.olximoveis.model;

import java.math.BigDecimal;

public class Telefone {
	private int cod;
	private int numero;
	
	public Telefone(int cod, int numero) {
		this.cod = cod;
		this.numero = numero;
	}
	
	public Telefone(Object ... attributes) {
		this.cod = ((BigDecimal) attributes[0]).intValue();
		this.numero = ((BigDecimal) attributes[1]).intValue();
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
//	tp_fone(81,99999999),
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("tp_fone(")
		.append(this.cod).append(", ")
		.append(this.numero).append(")");
		return sb.toString();
	}
	
}
