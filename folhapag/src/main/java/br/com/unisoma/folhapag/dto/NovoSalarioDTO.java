package br.com.unisoma.folhapag.dto;

public class NovoSalarioDTO {
	
	private final Long cpf;
	private final Double salario;
	private final Double reajuste;
	private final Integer percentual; 
	
	public NovoSalarioDTO(Long cpf, Double salario, Integer percentual) {
		super();
		Double novoSalario = salario * (1 + ((double)percentual/100));
		this.cpf = cpf;
		this.salario = novoSalario;
		this.reajuste = novoSalario - salario;
		this.percentual = percentual;
	}

	public Long getCpf() {
		return cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public Double getReajuste() {
		return reajuste;
	}

	public Integer getPercentual() {
		return percentual;
	}


}
