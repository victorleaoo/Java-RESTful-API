package br.com.unisoma.folhapag.dto;

public class ImpostoDTO {
	private final Long cpf;
	private final String imposto;
	
	public ImpostoDTO(Long cpf, Double imposto) {
		super();
		this.cpf = cpf;
		if(imposto == 0.0) {
			this.imposto = "Isento";
		} else {
			this.imposto = "R$ " + imposto.toString();
		}
	}
	
	public Long getCpf() {
		return cpf;
	}
	public String getImposto() {
		return imposto;
	}
	
	
}
