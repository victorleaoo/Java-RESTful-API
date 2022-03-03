package br.com.unisoma.folhapag.dto;

public class ImpostoDTO {
	private final Long cpf;
	private final String imposto;
	
	public ImpostoDTO(Long cpf, String imposto) {
		super();
		this.cpf = cpf;
		this.imposto = imposto;		
	}
	
	public Long getCpf() {
		return cpf;
	}
	public String getImposto() {
		return imposto;
	}
	
	
}
