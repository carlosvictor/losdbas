package br.com.olximoveis.model;

import java.math.BigDecimal;

public class Endereco {
	private int cep;
	private String rua; // 20
	private int numero;
	private String complemento; // 20
	private String bairro; // 15
	private String cidade; // 15
	private String estado; // 2
	
	public Endereco(int cep, String rua, int numero, String complemento, String bairro, String cidade, String estado) {
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Endereco(Object ... attributes) {
		this.cep = ((BigDecimal) attributes[0]).intValue();
		this.rua = (String) attributes[1];
		this.numero = ((BigDecimal) attributes[2]).intValue();
		this.complemento = (String) attributes[3];
		this.bairro = (String) attributes[4];
		this.cidade = (String) attributes[5];
		this.estado = (String) attributes[6];
	}
	
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
//	tp_endereco(54400000, 'tal de alguma coisa', 20, 'bl.02 ap302', 'Esse bairro', 'raincife', 'pe')
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" tp_endereco ( ")
		.append(this.cep).append(", ")
		.append("'").append(this.rua).append("', ")
		.append(this.numero).append(", ")
		.append("'").append(this.complemento).append("', ")
		.append("'").append(this.bairro).append("', ")
		.append("'").append(this.cidade).append("', ")
		.append("'").append(this.estado).append("')");
		
		return sb.toString();
	}
	
}
