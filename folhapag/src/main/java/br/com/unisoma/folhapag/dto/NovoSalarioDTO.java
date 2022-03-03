package br.com.unisoma.folhapag.dto;

import java.text.NumberFormat;
import java.util.Locale;

public class NovoSalarioDTO {
	
	private final Long cpf;
	private final String salario;
	private final String reajuste;
	private final Integer percentual; 
	private static final NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
	
	public NovoSalarioDTO(Long cpf, Double salario, Integer percentual, Double novoSalario) {
		super();
		nf.setMaximumFractionDigits(2);
		this.cpf = cpf;
		this.salario = nf.format(novoSalario);
		this.reajuste = nf.format(novoSalario - salario);
		this.percentual = percentual;
	}

	public Long getCpf() {
		return cpf;
	}

	public String getSalario() {
		return salario;
	}

	public String getReajuste() {
		return reajuste;
	}

	public Integer getPercentual() {
		return percentual;
	}


}
