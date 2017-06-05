package br.com.olximoveis.model;

import java.util.Calendar;
import java.util.Date;

import br.com.olximoveis.utils.Utils;

public class Funcionario {
	
	private String cod; // 10
	private String nome; // 30
	private String email; // 30
	private Date data_nascimento; // DD-MM-YYYY
	private Date data_admissao; //DD-MM-YYYY
	private Telefone telefone; // tp_telefone
	private Endereco endereco; // tp_endereco
	private Funcionario supervisor;
	
	public Funcionario() {
		
	}

	public Funcionario(String cod, String nome, String email, Date data_nascimento, Date data_admissao,
			Telefone telefone, Endereco endereco, Funcionario supervisor) {
		this.cod = cod;
		this.nome = nome;
		this.email = email;
		this.data_nascimento = data_nascimento;
		this.data_admissao = data_admissao;
		this.telefone = telefone;
		this.endereco = endereco;
		this.supervisor = supervisor;
	}
	
	public Funcionario(String nome, String email, Date data_nascimento, Date data_admissao, Telefone telefone,
			Endereco endereco, Funcionario supervisor) {
		this.nome = nome;
		this.email = email;
		this.data_nascimento = data_nascimento;
		this.data_admissao = data_admissao;
		this.telefone = telefone;
		this.endereco = endereco;
		this.supervisor = supervisor;
	}

	public Funcionario(String cod) {
		this.cod = cod;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Date getData_admissao() {
		return data_admissao;
	}

	public void setData_admissao(Date data_admissao) {
		this.data_admissao = data_admissao;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Funcionario getSupervisor() {
		return supervisor;
	}
	
	public void setSupervisor(Funcionario supervisor) {
		this.supervisor = supervisor;
	}
	
//	INSERT INTO tb_funcionario VALUES(
//			'func123',
//			'fulano', 
//			'fulano@cicrano.com',
//			TO_DATE('10-10-1980','DD-MM-YYYY'),
//			TO_DATE('03-03-2005','DD-MM-YYYY'),
//			tp_fone(81,99999999),
//			tp_endereco(54400000, 'tal de alguma coisa', 20, 'bl.02 ap302', 'Esse bairro', 'raincife', 'pe')
//		);
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" tb_funcionario ")
		.append("VALUES ( ")
		.append(" '").append(this.cod).append("', ")
		.append(" '").append(this.nome).append("', ")
		.append(" '").append(this.email).append("', ")
		.append("TO_DATE('").append(Utils.Date.format(this.data_nascimento)).append("', 'DD-MM-YYYY'), ")
		.append("TO_DATE('").append(Utils.Date.format(this.data_admissao)).append("', 'DD-MM-YYYY'), ")
		.append(this.telefone).append(", ")
		.append(this.endereco).append(", ")
		.append(this.supervisor != null ? this.supervisor : "null").append(")");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		

		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
//		String reportDate = df.format(today);

		// Print what date is today!
		System.out.println("Report Date: " + Utils.Date.format(today));
		System.out.println(new Funcionario());
		Funcionario fun = new Funcionario("func12345", "carlos", "carlos@gmail.com", new Date("10/10/1990"), new Date(), 
				new Telefone(81, 999277710), new Endereco(51021360, "Rua do teste", 666, "A", "Boa prova", "Recife", "PE"), null);
		System.out.println(fun);
		
		
	}
		
}
