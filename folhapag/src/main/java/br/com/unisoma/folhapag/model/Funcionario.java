package br.com.unisoma.folhapag.model; 

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// DTO
public class Funcionario {
	private final String nome;
	private final Long cpf;
	private final LocalDate dataNascimento;
	private final String telefone;
	private final String endereco;
	private final Double salario;
	
	public Funcionario(String nome, Long cpf, String dataNascimento, String telefone, String endereco,
			Double salario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = strToDate(dataNascimento);
		this.telefone = telefone;
		this.endereco = endereco;
		this.salario = salario;
	}
	
	private LocalDate strToDate(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateTime = LocalDate.parse(str, formatter);
		return dateTime;
	}

	public String getNome() {
		return nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public Double getSalario() {
		return salario;
	}
	
}
