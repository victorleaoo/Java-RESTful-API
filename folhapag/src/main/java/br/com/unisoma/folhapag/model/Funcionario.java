package br.com.unisoma.folhapag.model; 

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nome")
	private String nome;
	@Column(name = "cpf", unique = true)
	private Long cpf;
	@Column(name = "dataNascimento")
	private LocalDate dataNascimento;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "endereco")
	private String endereco;
	@Column(name = "salario")
	private Double salario;
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(String nome, Long cpf, LocalDate dataNascimento, String telefone, String endereco,
			Double salario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.salario = salario;
	}
	
	public Integer getId() {
		return id;
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

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
}
